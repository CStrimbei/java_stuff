package com.example.demo.general.views.surface;


import com.example.demo.general.repos.PersonRepo;
import com.example.demo.general.entity.Person;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("/register")
@PageTitle("Register")
public class RegisterView extends VerticalLayout {
    private PersonRepo personRepo;
    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private EmailField email = new EmailField("E-Mail");
    private TextField username = new TextField("Username");
    //private TextField userType = new TextField("Type");

    private Select<String> userType = new Select<>();

    private PasswordField password = new PasswordField("Password");
    private Binder<Person> binder = new Binder<>(Person.class);

    public RegisterView(PersonRepo personRepo) {
        this.personRepo = personRepo;
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.add(new H1("Welcome to SmartCity Iasi!"));
        headerLayout.add("Enter your credentials below to register!");
        add(headerLayout);
        userType.setLabel("Type");
        userType.setItems("Resident", "Tourist", "Foreigner", "Businessman");
        userType.setValue("Resident");
        add(getForm());
    }

    private VerticalLayout getForm() {
        var layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        var registerButton = new Button("Register");
        var loginButton = new Button("Login");
        registerButton.addClickShortcut(Key.ENTER);
        registerButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        loginButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        layout.add(firstName, lastName, email, userType, username, password, registerButton, loginButton);
        binder.bindInstanceFields(this);

        registerButton.addClickListener(click -> {
            try{
                var person = new Person();
                binder.writeBean(person);
                if(personRepo.findByUsername(person.getUsername())!=null){
                    layout.removeAll();
                    layout.add(firstName, lastName, email, userType, username, password);
                    Notification.show("User already exists!");
                    layout.add(registerButton, loginButton);
                } else if (person.getUsername()==""||person.getEmail()==""||person.getFirstname()==""||person.getLastname()==""||person.getPassword()==""||person.getUsertype()=="") {
                    layout.removeAll();
                    layout.add(firstName, lastName, email, userType, username, password);
                    Notification.show("You haven't entered all of the credentials!");
                    layout.add(registerButton, loginButton);
                }else{
                    layout.removeAll();
                    person.setUsertype(userType.getValue());
                    personRepo.saveAndFlush(person);
                    binder.readBean(new Person());
                    layout.add(firstName, lastName, email, userType, username, password);
                    Notification.show("User added successfully!");
                    layout.add(registerButton, loginButton);
                }
            } catch (ValidationException e){
                e.printStackTrace();
            }
        });

        loginButton.addClickListener(event -> UI.getCurrent().navigate("/login"));

        return layout;
    }

    /*private void refreshGrid() {
        grid.setItems(personRepo.findAll());
    }*/
}
