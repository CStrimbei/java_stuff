package com.example.demo.features.business.views;

import com.example.demo.features.business.entity.Job;
import com.example.demo.features.business.repo.JobRepo;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;

import java.util.List;

@PageTitle("Job List")
public class JobListView extends VerticalLayout {
    private JobRepo jobRepo;
    private Grid<Job> grid = new Grid<>(Job.class);

    public JobListView(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.add(new H1("Here is a job list!"));
        add(headerLayout);
        add(getJobList());
    }

    private VerticalLayout getJobList() {
            var layout = new VerticalLayout();
            layout.setAlignItems(Alignment.CENTER);
            var homeButton = new Button("Home");
            var allJobs = jobRepo.findAll();
            configureGrid(allJobs);
            add(grid);
            return layout;
    }

    private void configureGrid(List<Job> allJobs) {
        grid.setColumns("company", "position", "salary", "contact");
        grid.setItems(jobRepo.findAll());
    }
}
