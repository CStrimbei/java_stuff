package com.example.demo.views.surface;


import com.example.demo.repos.PersonRepo;
import com.example.demo.entity.Person;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
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
    boolean isLogged;
    private static final String tempval = "temp";
    private Binder<Person> binder = new Binder<>(Person.class);

    public LoginView(PersonRepo personRepo) {
        this.personRepo = personRepo;
        add(getLoginForm());
    }

    private LoginOverlay getLoginForm() {
        var layout = new LoginOverlay();
        layout.setTitle("SmartCity");
        layout.setDescription("The app that helps you move around the city!");

        layout.addLoginListener(event -> {
            if(event.getPassword().equals(personRepo.findPassword(event.getUsername()))){
                layout.close();
                UI.getCurrent().navigate("/loggedhome");
            } else{
                Notification.show("Wrong username or password!");
                layout.setOpened(true);
            }
        });

        layout.setOpened(true);
        return layout;
    }

    /*private VerticalLayout getLogin() {
        isLogged = false;
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
                    isLogged = false;
                } else if(passServer.equals(passApp)){
                    *//*layout.removeAll();
                    layout.add(username, password);
                    layout.add("Ayy te-ai logat!");
                    //aici va veni un redirect in interfata userilor logat
                    layout.add(loginButton ,registerButton);*//*

                    UI.getCurrent().navigate("/loggedhome");

                    isLogged = true;
                }else {
                    layout.removeAll();
                    layout.add(username, password);
                    layout.add("Wrong username or password!");
                    //System.out.println(personRepo.findPassword(person.getUsername()) + " " + person.getPassword());
                    layout.add(loginButton ,registerButton);
                    isLogged = false;
                }
            } catch (ValidationException e) {
                throw new RuntimeException(e);
            }
        });

        return layout;
    }*/

}
