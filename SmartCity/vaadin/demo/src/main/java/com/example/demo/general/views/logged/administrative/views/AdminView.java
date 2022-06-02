package com.example.demo.general.views.logged.administrative.views;
import com.example.demo.general.repos.PersonRepo;
import com.example.demo.general.entity.Person;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.QueryParameters;


@PageTitle("Admin Panel")
public class AdminView extends VerticalLayout implements HasUrlParameter<String> {
    private PersonRepo personRepo;
    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private EmailField email = new EmailField("E-Mail");
    private TextField username = new TextField("Username");
    private Select<String> userType = new Select<>();
    private PasswordField password = new PasswordField("Password");
    private Binder<Person> binder = new Binder<>(Person.class);

    public AdminView(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }
    private VerticalLayout getForm(String s) {
        var layout = new VerticalLayout();
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        var registerButton = new Button("Register new user");
        var logoutButton = new Button("Log Out");
        var homeButton = new Button("Home");
        var dashboardButton = new Button("Dashboard");
        dashboardButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        homeButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        registerButton.addClickShortcut(Key.ENTER);
        registerButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        logoutButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        layout.add(firstName, lastName, email, userType, username, password, registerButton, dashboardButton, homeButton, logoutButton);
        binder.bindInstanceFields(this);

        registerButton.addClickListener(click -> {
            try{
                var person = new Person();
                binder.writeBean(person);
                if(personRepo.findByUsername(person.getUsername())!=null){
                    layout.removeAll();
                    layout.add(firstName, lastName, email, userType, username, password);
                    Notification.show("User already exists!");
                    layout.add(registerButton, dashboardButton, homeButton, logoutButton);
                } else if (person.getUsername()==""||person.getEmail()==""||person.getFirstname()==""||person.getLastname()==""||person.getPassword()==""||person.getUsertype()=="") {
                    layout.removeAll();
                    layout.add(firstName, lastName, email, userType, username, password);
                    Notification.show("You haven't entered all of the credentials!");
                    layout.add(registerButton, dashboardButton, homeButton, logoutButton);
                }else{
                    layout.removeAll();
                    personRepo.saveAndFlush(person);
                    binder.readBean(new Person());
                    layout.add(firstName, lastName, email, userType, username, password);
                    Notification.show("User added successfully!");
                    layout.add(registerButton, dashboardButton, homeButton, logoutButton);
                }
            } catch (ValidationException e){
                e.printStackTrace();
            }
        });

        logoutButton.addClickListener(click -> {
            UI.getCurrent().navigate("/logout");
        });

        homeButton.addClickListener(click -> {
            UI.getCurrent().navigate("/logged/" + s, QueryParameters.fromString(s));
        });

        dashboardButton.addClickListener(click->{
            UI.getCurrent().navigate("/admindash/" + s, QueryParameters.fromString(s));
        });

        return layout;
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {
        this.personRepo = personRepo;
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        headerLayout.add(new H1("Welcome, " + s + "!"));
        headerLayout.add("Enter some credentials below to register users!");
        add(headerLayout);
        userType.setLabel("Type");
        userType.setItems("Resident", "Tourist", "Foreigner", "Businessman", "Admin");
        userType.setValue("Resident");
        add(getForm(s));
    }
}
