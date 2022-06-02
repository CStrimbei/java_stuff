package com.example.demo.general.views.surface;

import com.example.demo.general.repos.PersonRepo;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
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
        headerLayout.add(new H1("Welcome to SmartCity Iasi!"));
        headerLayout.add("Whether you're visiting or a resident, this app will help you find your way around the city! You have the possibility to book a parking space, to see or add job listings in the city, see hotel info, see a list of museums and maybe plan your studies here!");
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
