package com.example.demo.features.business.views;


import com.example.demo.features.business.entity.Job;
import com.example.demo.features.business.repo.JobRepo;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.QueryParameters;

@PageTitle("Business Panel")
public class BusinessView extends VerticalLayout implements HasUrlParameter<String> {

    public JobRepo jobRepo;
    private TextField company = new TextField("Company name");
    private TextField position = new TextField("Position");
    private TextField salary = new TextField("Salary");
    private TextField contact = new TextField("Contact");
    private Binder<Job> binder = new Binder<>(Job.class);
    public BusinessView(JobRepo jobRepo) {
        this.jobRepo = jobRepo;

    }
    public VerticalLayout getForm(String s){
        var layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        var addButton = new Button("Add");
        var hotelButton = new Button("Hotels");
        var logoutButton = new Button("Log out");
        var jobButton = new Button("Job listings");
        jobButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        logoutButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        addButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        hotelButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layout.add(company, position, salary, contact, addButton, hotelButton, jobButton, logoutButton);
        addButton.addClickShortcut(Key.ENTER);
        addButton.addClickListener(click -> {
                var job = new Job();
                job.setCompany(company.getValue());
                job.setContact(contact.getValue());
                job.setPosition(position.getValue());
                job.setSalary(Double.valueOf(salary.getValue()));
                jobRepo.saveAndFlush(job);
                Notification.show("Job added successfully!");
        });

        logoutButton.addClickListener(click -> {
            UI.getCurrent().navigate("/logout");
        });

        jobButton.addClickListener(click ->{
            UI.getCurrent().navigate("jobs/" + s, QueryParameters.fromString(s));
        });

        hotelButton.addClickListener(click->{
            UI.getCurrent().navigate("/hotels/" + s, QueryParameters.fromString(s));
        });

        return layout;
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.add(new H1("Welcome to the business interface!"));
        headerLayout.add("Add a job below!");
        add(headerLayout);
        add(getForm(s));
    }
}
