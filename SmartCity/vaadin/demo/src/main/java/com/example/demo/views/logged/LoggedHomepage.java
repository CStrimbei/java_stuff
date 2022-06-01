package com.example.demo.views.logged;

import com.example.demo.repos.PersonRepo;
import com.example.demo.views.surface.LoginView;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.awt.*;

@PageTitle("SmartCity")
public class LoggedHomepage extends VerticalLayout implements HasUrlParameter<String> {

    private PersonRepo personRepo;

/*    public LoggedHomepage() {
        this.personRepo = personRepo;
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.add(new H1("Welcome to my SmartCity app!"));
        headerLayout.add("Press a button below and choose your feature!");
        add(headerLayout);
        add(getButtons());

        //boolean isLogged = (boolean) readData(UI.getCurrent());

        //System.out.println(isLogged);

    }*/

    private VerticalLayout getButtons(){
        var buttonLayout = new VerticalLayout();
        buttonLayout.setAlignItems(Alignment.CENTER);
        var logoutButton = new Button("Log Out");
        logoutButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        buttonLayout.add(logoutButton);

        logoutButton.addClickListener(click -> {
            UI.getCurrent().navigate("/logout");
        });

        return buttonLayout;
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {
        this.personRepo = personRepo;
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.add(new H1("Welcome, " + s + "!"));
        headerLayout.add("Press a button below and choose your feature!");
        add(headerLayout);
        add(getButtons());
    }
}
