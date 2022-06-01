package com.example.demo.features.parking.views;

import com.example.demo.repos.PersonRepo;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;

@PageTitle("Parking Management")
public class ParkingView extends VerticalLayout implements HasUrlParameter<String> {

    private PersonRepo personRepo;
    private Select<String> parkingGarages = new Select<>();

    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {
        this.personRepo = personRepo;
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.add(new H1("Welcome, " + s + "!"));
        headerLayout.add("Choose a parking garage!");
        add(headerLayout);
        add(getParking());
        add(getButtons(s));
    }

    private VerticalLayout getParking() {

        //TODO: add a button that checks the db for free spaces

        var layout = new VerticalLayout();
        var reserveButton = new Button("Reserve space now!");
        reserveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        parkingGarages.setLabel("Choose a parking garage");
        parkingGarages.setValue("Parking Garage 1");
        parkingGarages.setItems("Parking Garage 1", "Parking Garage 2", "Parking Garage 3");
        layout.setAlignItems(Alignment.CENTER);
        layout.add(parkingGarages, reserveButton);
        reserveButton.addClickListener(click -> {
            //TODO: handle the click, updating the DB
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
