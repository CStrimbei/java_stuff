package com.example.demo.views.surface;


import com.example.demo.repos.PersonRepo;
import com.example.demo.entity.Person;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;

import java.util.concurrent.atomic.AtomicBoolean;

@Route("/login")
public class LoginView extends VerticalLayout {
    private PersonRepo personRepo;
    private TextField username = new TextField("Username");
    private PasswordField password = new PasswordField("Password");

    private Binder<Person> binder = new Binder<>(Person.class);

    public LoginView(PersonRepo personRepo) {
        this.personRepo = personRepo;
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.add(new H1("Welcome to my SmartCity app!"));
        headerLayout.add("Enter your credentials below to login!");
        add(headerLayout);
        add(getLogin());
    }

    private VerticalLayout getLogin() {
        AtomicBoolean isLogged = new AtomicBoolean(false);
        var layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        var registerButton = new Button("Register");
        var loginButton = new Button("Login");
        registerButton.addClickShortcut(Key.ENTER);
        registerButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layout.add(username, password, loginButton ,registerButton);
        binder.bindInstanceFields(this);

        registerButton.addClickListener(event -> UI.getCurrent().navigate("/register"));

        loginButton.addClickListener(click -> {
            var person = new Person();
            try {
                binder.writeBean(person);
                String passServer = personRepo.findPassword(person.getUsername());
                String passApp = person.getPassword();
                if(person.getUsername()==""||person.getPassword()==""){
                    layout.removeAll();
                    layout.add(username, password);
                    layout.add("Enter your credentials properly please!");
                    layout.add(loginButton ,registerButton);
                    isLogged.set(false);

                } else if(passServer.equals(passApp)){
                    layout.removeAll();
                    layout.add(username, password);
                    layout.add("Ayy te-ai logat!");
                    //aici va veni un redirect in interfata userilor logat
                    layout.add(loginButton ,registerButton);
                    isLogged.set(true);
                }else {
                    layout.removeAll();
                    layout.add(username, password);
                    layout.add("Wrong username or password!");
                    //System.out.println(personRepo.findPassword(person.getUsername()) + " " + person.getPassword());
                    layout.add(loginButton ,registerButton);
                    isLogged.set(false);
                }
            } catch (ValidationException e) {
                throw new RuntimeException(e);
            }
        });

        return layout;
    }
}
