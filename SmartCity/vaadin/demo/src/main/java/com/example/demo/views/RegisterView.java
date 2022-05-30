package com.example.demo.views;


import com.example.demo.repos.PersonRepo;
import com.example.demo.entity.Person;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;

@Route("")
public class RegisterView extends VerticalLayout {
    private PersonRepo personRepo;
    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private EmailField email = new EmailField("E-Mail");
    private TextField username = new TextField("Username");
    private TextField userType = new TextField("Type");
    private PasswordField password = new PasswordField("Password");
    private Binder<Person> binder = new Binder<>(Person.class);
    private Grid<Person> grid = new Grid<>(Person.class);

    public RegisterView(PersonRepo personRepo) {
        this.personRepo = personRepo;
        grid.setColumns("firstname", "lastname", "username", "email", "usertype");
        add(getForm(), grid);
        refreshGrid();
    }

    private HorizontalLayout getForm() {
        var layout = new HorizontalLayout();
        layout.setAlignItems(Alignment.BASELINE);
        var registerButton = new Button("Register");
        registerButton.addClickShortcut(Key.ENTER);
        registerButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layout.add(firstName, lastName, email, userType, username, password, registerButton);
        binder.bindInstanceFields(this);

        registerButton.addClickListener(click -> {
            try{
                var person = new Person();
                binder.writeBean(person);
                if(personRepo.findByUsername(person.getUsername())!=null){
                    layout.add("Username already exists!");
                } else{
                    personRepo.saveAndFlush(person);
                    binder.readBean(new Person());
                    refreshGrid();
                    layout.add("User added successfully!");
                }
            } catch (ValidationException e){
                e.printStackTrace();
            }
        });

        return layout;
    }

    private void refreshGrid() {
        grid.setItems(personRepo.findAll());
    }
}
