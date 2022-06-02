package com.example.demo.general.views.surface;

import com.example.demo.general.repos.PersonRepo;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("")
@PageTitle("Home")
public class HomeView extends VerticalLayout {

    private PersonRepo personRepo;



    public HomeView(PersonRepo personRepo) {
        this.personRepo = personRepo;
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.add(new H1("Welcome to my SmartCity app!"));
        headerLayout.add("Whether you're visiting or a resident, this app will help you find your way around the city! We'll give you the possibility to book a parking space, to see or add potential job listings in the city and see information about hotels!");
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
