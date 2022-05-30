package com.example.demo.views;


import com.example.demo.repos.PersonRepo;
import com.example.demo.entity.Person;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
@Route("/login")
public class LoginView extends VerticalLayout {
    private PersonRepo personRepo;
    private TextField username = new TextField("Username");
    private PasswordField password = new PasswordField("Password");

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
        var layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        var registerButton = new Button("Register");
        var loginButton = new Button("Login");
        registerButton.addClickShortcut(Key.ENTER);
        registerButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layout.add(username, password, loginButton ,registerButton);
        registerButton.addClickListener(event -> UI.getCurrent().navigate("/register"));

        loginButton.addClickListener(click -> {
            layout.add("Work in progress!");
        });

        return layout;
    }
}
