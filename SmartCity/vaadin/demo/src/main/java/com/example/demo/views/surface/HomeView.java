package com.example.demo.views.surface;

import com.example.demo.features.parking.ParkingGarageManager;
import com.example.demo.repos.PersonRepo;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
@PageTitle("Home")
public class HomeView extends VerticalLayout {

    private PersonRepo personRepo;

    @Autowired
    ParkingGarageManager parkingGarageManager;

    public HomeView(PersonRepo personRepo) {
        this.personRepo = personRepo;
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.add(new H1("Welcome to my SmartCity app!"));
        headerLayout.add("Lorem ipsum info stuff");
        add(headerLayout);
        add(getHomepage());
    }

    private VerticalLayout getHomepage() {
        var layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        var loginButton = new Button("Login");
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layout.add("Press the button below to login into the application!");
        layout.add(loginButton);
        loginButton.addClickListener(click -> UI.getCurrent().navigate("/login"));

        return layout;
    }
}
