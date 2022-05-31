package com.example.demo.views.logged;

import com.example.demo.repos.PersonRepo;
import com.example.demo.views.surface.LoginView;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/loggedhome")
public class LoggedHomepage extends VerticalLayout{

    private static final String tempval = "temp";

    private PersonRepo personRepo;

    public LoggedHomepage() {
        this.personRepo = personRepo;
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.add(new H1("Welcome to my SmartCity app!"));
        headerLayout.add("Press a button below and choose your feature!");
        add(headerLayout);

        //boolean isLogged = (boolean) readData(UI.getCurrent());

        //System.out.println(isLogged);

    }
}
