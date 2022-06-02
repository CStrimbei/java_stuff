package com.example.demo.general.views.logged.administrative.views;

import com.example.demo.features.business.entity.Job;
import com.example.demo.features.business.repo.JobRepo;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.QueryParameters;

import java.util.List;

public class JobListAdmin extends VerticalLayout implements HasUrlParameter<String> {
    private JobRepo jobRepo;
    private Grid<Job> grid = new Grid<>(Job.class);

    public JobListAdmin(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    private VerticalLayout getJobList(String s) {
        var layout = new VerticalLayout();
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        var homeButton = new Button("Home");
        homeButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        var allJobs = jobRepo.findAll();
        configureGrid(allJobs);
        add(grid, homeButton);
        homeButton.addClickListener(click->{
            UI.getCurrent().navigate("admindash/" + s, QueryParameters.fromString(s));
        });
        return layout;
    }

    private void configureGrid(List<Job> allJobs) {
        grid.setColumns("company", "position", "salary", "contact");
        grid.setItems(jobRepo.findAll());
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        headerLayout.add(new H1("Here is a job list!"));
        add(headerLayout);
        add(getJobList(s));
    }
}
