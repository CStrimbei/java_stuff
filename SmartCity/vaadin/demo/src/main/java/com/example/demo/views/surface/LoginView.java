package com.example.demo.views.surface;


import com.example.demo.entity.Person;
import com.example.demo.features.business.views.BusinessView;
import com.example.demo.features.business.views.JobListView;
import com.example.demo.features.parking.views.ParkingView;
import com.example.demo.repos.PersonRepo;
import com.example.demo.views.logged.administrative.AdminView;
import com.example.demo.views.logged.LoggedHomepage;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteConfiguration;

import java.util.ArrayList;
import java.util.List;

@Route("/login")
@PageTitle("Login")
public class LoginView extends VerticalLayout {
    private PersonRepo personRepo;

    public record AuthRoute(String route, String name, Class<? extends Component> view){
    }

    public LoginView(PersonRepo personRepo){
        this.personRepo = personRepo;
        add(
                getHeader(),
                getLogin()
        );
    }

    private VerticalLayout getHeader() {
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.add(new H1("Welcome to my SmartCity app!"));
        return headerLayout;
    }

    private VerticalLayout getLogin() {
        var loginLayout = new VerticalLayout();
        var username = new TextField("Username");
        var password = new PasswordField("Password");
        var loginButton = new Button("Login");
        var registerButton = new Button("Register");
        loginButton.addClickShortcut(Key.ENTER);
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        registerButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        loginLayout.setAlignItems(Alignment.CENTER);
        loginLayout.add(
                username,
                password,
                loginButton,
                registerButton
        );
        registerButton.addClickListener(click -> UI.getCurrent().navigate("/register"));
        loginButton.addClickListener(click -> {
            authenticate(username.getValue(), password.getValue());
        });
        return loginLayout;
    }


    public void authenticate(String username, String password){
        Person person = personRepo.findByUsername(username);
        if(person!=null && password.equals(person.getPassword())){
            createRoutes(person.getUsertype());
            if(person.getUsertype().equals("Businessman")){
                UI.getCurrent().navigate("business/");
            }else if(!person.getUsertype().equals("Admin")){
                UI.getCurrent().navigate("logged/" + username, QueryParameters.fromString(username));
            } else UI.getCurrent().navigate("adminpanel/" + username, QueryParameters.fromString(username));

        } else{
            Notification.show("Wrong credentials!");
        }
    }

    private void createRoutes(String usertype) {
        getAuthRoutes(usertype).stream()
                .forEach(authRoute ->
                        RouteConfiguration.forSessionScope().setRoute(
                                authRoute.route, authRoute.view));
    }

    public List<AuthRoute> getAuthRoutes(String usertype){

        var authRoutes = new ArrayList<AuthRoute>();
        authRoutes.clear();
        if(usertype.equals("Businessman")){
            authRoutes.add(new AuthRoute("logged/", "LoggedHome", LoggedHomepage.class));
            authRoutes.add(new AuthRoute("business/", "BusinessPanel", BusinessView.class));
        }else if(!usertype.equals("Admin")){
            authRoutes.add(new AuthRoute("logged/", "LoggedHome", LoggedHomepage.class));
            authRoutes.add(new AuthRoute("parking/", "ParkingManagement", ParkingView.class));
            authRoutes.add(new AuthRoute("jobs/", "JobList", JobListView.class));
        } else {
            authRoutes.add(new AuthRoute("logged/", "LoggedHome", LoggedHomepage.class));
            authRoutes.add(new AuthRoute("adminpanel/", "AdminPanel", AdminView.class));
            authRoutes.add(new AuthRoute("parking/", "ParkingManagement", ParkingView.class));
            authRoutes.add(new AuthRoute("jobs/", "JobList", JobListView.class));
            authRoutes.add(new AuthRoute("business/", "BusinessPanel", BusinessView.class));
        }
        System.out.println(authRoutes);
        return authRoutes;
    }

}
