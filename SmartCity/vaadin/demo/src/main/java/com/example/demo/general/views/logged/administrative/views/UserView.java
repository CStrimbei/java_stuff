package com.example.demo.general.views.logged.administrative.views;

import com.example.demo.features.business.entity.Job;
import com.example.demo.general.entity.Person;
import com.example.demo.general.repos.PersonRepo;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.QueryParameters;

import java.util.List;

@PageTitle("User Table")
public class UserView extends VerticalLayout implements HasUrlParameter<String> {
    private PersonRepo personRepo;
    private Grid<Person> personGrid = new Grid<>(Person.class);

    public UserView(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.add(new H1("Here is the user list!"));
        add(headerLayout);
        add(getUserList(s));
    }

    private VerticalLayout getUserList(String s) {
        var layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        var homeButton = new Button("Home");
        homeButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        var allPersons = personRepo.findAll();
        configureGrid(allPersons);
        add(personGrid, homeButton);
        homeButton.addClickListener(click->{
            UI.getCurrent().navigate("admindash/" + s, QueryParameters.fromString(s));
        });
        return layout;
    }

    private void configureGrid(List<Person> allJobs) {
        personGrid.setColumns("firstname", "lastname", "username", "usertype");
        personGrid.setItems(personRepo.findAll());
    }

}
