package com.example.demo.general.views.logged.administrative.views;

import com.example.demo.features.business.repo.JobRepo;
import com.example.demo.features.parking.repos.ReservedRepo;
import com.example.demo.general.repos.PersonRepo;
import com.example.demo.general.views.logged.administrative.threading.ThreadManager;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.QueryParameters;

@PageTitle("Admin Dashboard")
public class DashboardView extends VerticalLayout implements HasUrlParameter<String> {


    private PersonRepo personRepo;
    private ReservedRepo reservedRepo;
    private JobRepo jobRepo;

    public DashboardView(PersonRepo personRepo, ReservedRepo reservedRepo, JobRepo jobRepo) {
        this.personRepo = personRepo;
        this.reservedRepo = reservedRepo;
        this.jobRepo = jobRepo;
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {

        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        headerLayout.add(new H1("Welcome to the admin dashboard, " + s + "!"));


        add(headerLayout);
        add(getStatsPanel(s));
        add(getButtonPanel(s));
    }

    private VerticalLayout getStatsPanel(String s) {
        var layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        try {
            var valuelist = new ThreadManager(reservedRepo, personRepo, jobRepo).runThreads();
            layout.add(new H2("Number of users in the DB: " + valuelist.get(0)));
            var buttonUsers = new Button("View");
            buttonUsers.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
            layout.add(buttonUsers);
            layout.add(new H2("Number of jobs in the DB: " + valuelist.get(1)));
            var buttonJobs = new Button("View");
            buttonJobs.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
            layout.add(buttonJobs);
            layout.add(new H2("Number of reserved spots stored in the DB: " + valuelist.get(2)));

            buttonUsers.addClickListener(click->{
                UI.getCurrent().navigate("usertable/" + s, QueryParameters.fromString(s));
            });

            buttonJobs.addClickListener(click->{
                UI.getCurrent().navigate("jobtableadmin/" + s, QueryParameters.fromString(s));
            });


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return layout;
    }

    private VerticalLayout getButtonPanel(String s) {
        var layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        var button = new Button("Register Panel");
        var logout = new Button("Log out");
        logout.addThemeVariants(ButtonVariant.LUMO_ERROR);
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickListener(click->{
            UI.getCurrent().navigate("adminpanel/" + s, QueryParameters.fromString(s));
        });

        logout.addClickListener(click->{
            UI.getCurrent().navigate("/logout/");
        });
        layout.add(button, logout);
        return layout;
    }
}
