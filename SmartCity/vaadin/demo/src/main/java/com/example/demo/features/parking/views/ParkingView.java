package com.example.demo.features.parking.views;

import com.example.demo.features.parking.entity.Parking;
import com.example.demo.features.parking.entity.Reserved;
import com.example.demo.features.parking.management.ParkingGarageManager;
import com.example.demo.features.parking.repos.ParkingRepo;
import com.example.demo.features.parking.repos.ReservedRepo;
import com.example.demo.general.repos.PersonRepo;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@PageTitle("Parking Management")
public class ParkingView extends VerticalLayout implements HasUrlParameter<String> {

    private PersonRepo personRepo;
    private ParkingRepo parkingRepo;
    private ReservedRepo reservedRepo;
    private Select<String> parkingGarages = new Select<>();
    private Binder<Reserved> reservedBinder = new Binder<>(Reserved.class);
    private Binder<Parking> parkingBinder = new Binder<>(Parking.class);
    private Random randomizer = new Random();

    public ParkingView(PersonRepo personRepo, ParkingRepo parkingRepo, ReservedRepo reservedRepo) {
        this.personRepo = personRepo;
        this.parkingRepo = parkingRepo;
        this.reservedRepo = reservedRepo;
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.add(new H1("Welcome, " + s + "!"));
        headerLayout.add("Choose a parking garage!");
        add(headerLayout);
        add(getParking(s));
        add(getButtons(s));
    }

    private VerticalLayout getParking(String s) {

        var layout = new VerticalLayout();
        var reserveButton = new Button("Reserve space now!");
        var freeSpaceButton = new Button("Free spaces?");
        freeSpaceButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        var park1 = parkingRepo.getObject("Parking Garage 1");
        var park2 = parkingRepo.getObject("Parking Garage 2");
        var park3 = parkingRepo.getObject("Parking Garage 3");
        int totalSpaces1 = 170;
        AtomicInteger occupiedSpaces1 = new AtomicInteger(randomizer.nextInt(totalSpaces1 + 1));
        int totalSpaces2 = 130;
        AtomicInteger occupiedSpaces2 = new AtomicInteger(randomizer.nextInt(totalSpaces2 + 1));
        int totalSpaces3 = 200;
        AtomicInteger occupiedSpaces3 = new AtomicInteger(randomizer.nextInt(totalSpaces3 + 1));
        reserveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        parkingGarages.setLabel("Choose a parking garage");
        parkingGarages.setValue("Parking Garage 1");
        parkingGarages.setItems("Parking Garage 1", "Parking Garage 2", "Parking Garage 3");
        layout.setAlignItems(Alignment.CENTER);
        layout.add(parkingGarages, reserveButton, freeSpaceButton);
        freeSpaceButton.addClickListener(click ->{
            if(parkingGarages.getValue()==null){
                Notification.show("Select a parking garage to see the free spaces!");
            }else if(parkingGarages.getValue().equals("Parking Garage 1")){
                occupiedSpaces1.addAndGet(reservedRepo.getFreeSpaceCount(park1));
                Notification.show("Parking garage 1 has " + (totalSpaces1- occupiedSpaces1.get()) + " free spaces");
            } else if(parkingGarages.getValue().equals("Parking Garage 2")){
                occupiedSpaces2.addAndGet(reservedRepo.getFreeSpaceCount(park2));
                Notification.show("Parking garage 2 has " + (totalSpaces2- occupiedSpaces2.get()) + " free spaces");
            } else if(parkingGarages.getValue().equals("Parking Garage 3")){
                occupiedSpaces3.addAndGet(reservedRepo.getFreeSpaceCount(park3));
                Notification.show("Parking garage 3 has " + (totalSpaces3- occupiedSpaces3.get()) + " free spaces");
            }
        });
        reserveButton.addClickListener(click -> {
                var reserved = new Reserved();
                var person = personRepo.findByUsername(s);
                var parking = parkingRepo.getObject(parkingGarages.getValue());
                reserved.setUsername(person);
                reserved.setParkid(parking);
                //System.out.println("Debug: "+ parking.getId());
                reservedRepo.saveAndFlush(reserved);

                if(parkingGarages.getValue().equals("Parking Garage 1")){
                    ParkingGarageManager parkingGarageManager = new ParkingGarageManager(parkingRepo, reservedRepo, totalSpaces1, occupiedSpaces1.get());
//               System.out.println("Debug: " + parkingGarages.getValue());
                    parkingGarageManager.startThread(parkingGarages.getValue());
                } else if (parkingGarages.getValue().equals("Parking Garage 2")){
                    ParkingGarageManager parkingGarageManager = new ParkingGarageManager(parkingRepo, reservedRepo, totalSpaces2, occupiedSpaces2.get());
//               System.out.println("Debug: " + parkingGarages.getValue());
                    parkingGarageManager.startThread(parkingGarages.getValue());
                } else if (parkingGarages.getValue().equals("Parking Garage 3")){
                    ParkingGarageManager parkingGarageManager = new ParkingGarageManager(parkingRepo, reservedRepo, totalSpaces3, occupiedSpaces3.get());
//               System.out.println("Debug: " + parkingGarages.getValue());
                    parkingGarageManager.startThread(parkingGarages.getValue());
                }
            Notification.show("Parking spot reserved successfully!");
        });
        return layout;
    }

    private VerticalLayout getButtons(String s) {
        var layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        var buttonHome = new Button("Home");
        buttonHome.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        layout.add(buttonHome);

        buttonHome.addClickListener(click -> {
            UI.getCurrent().navigate("/logged/" + s);
        });

        return layout;
    }
}
