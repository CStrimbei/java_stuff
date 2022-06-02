package com.example.demo.features.business.views;


import com.example.demo.entity.Person;
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
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;

@PageTitle("Business Panel")
public class BusinessView extends VerticalLayout {

    public JobRepo jobRepo;
    private TextField company = new TextField("Company name");
    private TextField position = new TextField("Position");
    private TextField salary = new TextField("Salary");
    private TextField contact = new TextField("Contact");
    private Binder<Job> binder = new Binder<>(Job.class);
    public BusinessView(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.add(new H1("Welcome to the business interface!"));
        headerLayout.add("Add a job below!");
        add(headerLayout);
        add(getForm());
    }
    public VerticalLayout getForm(){
        var layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        var addButton = new Button("Add");
        var homeButton = new Button("Hotels");
        var logoutButton = new Button("Log out");
        logoutButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        addButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        homeButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        layout.add(company, position, salary, contact, addButton, homeButton, logoutButton);
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

        //TODO: interfata hotels la click pe butonul hotels

        return layout;
    }
}
