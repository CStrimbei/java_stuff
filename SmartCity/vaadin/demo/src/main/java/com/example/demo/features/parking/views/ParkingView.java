package com.example.demo.features.parking.views;

import com.example.demo.features.parking.entity.Parking;
import com.example.demo.features.parking.entity.Reserved;
import com.example.demo.features.parking.management.ParkingGarageManager;
import com.example.demo.features.parking.management.SpaceCounter;
import com.example.demo.features.parking.repos.ParkingRepo;
import com.example.demo.features.parking.repos.ReservedRepo;
import com.example.demo.repos.PersonRepo;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;

import java.util.Random;

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

        //TODO: add a button that checks the db for free spaces

        var layout = new VerticalLayout();
        var reserveButton = new Button("Reserve space now!");
        int totalSpaces1 = parkingRepo.getTotalSpaces("Parking Garage 1");
        int occupiedSpaces1 = randomizer.nextInt(totalSpaces1+1);
        int totalSpaces2 = parkingRepo.getTotalSpaces("Parking Garage 2");
        int occupiedSpaces2 = randomizer.nextInt(totalSpaces2+1);
        int totalSpaces3 = parkingRepo.getTotalSpaces("Parking Garage 3");
        int occupiedSpaces3 = randomizer.nextInt(totalSpaces3+1);
        reserveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        parkingGarages.setLabel("Choose a parking garage");
        parkingGarages.setValue("Parking Garage 1");
        parkingGarages.setItems("Parking Garage 1", "Parking Garage 2", "Parking Garage 3");
        layout.setAlignItems(Alignment.CENTER);
        layout.add(parkingGarages, reserveButton);
        reserveButton.addClickListener(click -> {
            //TODO: handle the click, updating the DB
                var reserved = new Reserved();
                var person = personRepo.findByUsername(s);
                var parking = parkingRepo.getObject(parkingGarages.getValue());
                reserved.setUsername(person);
                reserved.setParkid(parking);
                //System.out.println("Debug: "+ parking.getId());
                reservedRepo.saveAndFlush(reserved);

                if(parkingGarages.getValue().equals("Parking Garage 1")){
                    ParkingGarageManager parkingGarageManager = new ParkingGarageManager(parkingRepo, reservedRepo, totalSpaces1, occupiedSpaces1);
//               System.out.println("Debug: " + parkingGarages.getValue());
                    parkingGarageManager.startThread(parkingGarages.getValue());
                } else if (parkingGarages.getValue().equals("Parking Garage 2")){
                    ParkingGarageManager parkingGarageManager = new ParkingGarageManager(parkingRepo, reservedRepo, totalSpaces2, occupiedSpaces2);
//               System.out.println("Debug: " + parkingGarages.getValue());
                    parkingGarageManager.startThread(parkingGarages.getValue());
                } else if (parkingGarages.getValue().equals("Parking Garage 3")){
                    ParkingGarageManager parkingGarageManager = new ParkingGarageManager(parkingRepo, reservedRepo, totalSpaces3, occupiedSpaces3);
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
