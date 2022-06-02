package com.example.demo.general.views.logged;

import com.example.demo.general.repos.PersonRepo;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.QueryParameters;

@PageTitle("SmartCity")
public class LoggedHomepage extends VerticalLayout implements HasUrlParameter<String> {

    private PersonRepo personRepo;

/*    public LoggedHomepage() {
        this.personRepo = personRepo;
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.add(new H1("Welcome to my SmartCity app!"));
        headerLayout.add("Press a button below and choose your feature!");
        add(headerLayout);
        add(getButtons());

        //boolean isLogged = (boolean) readData(UI.getCurrent());

        //System.out.println(isLogged);

    }*/

    private VerticalLayout getButtons(String s){
        var buttonLayout = new VerticalLayout();

        buttonLayout.setAlignItems(Alignment.CENTER);
        var logoutButton = new Button("Log Out");
        var parkingButton = new Button("Parking");
        var buttonJobs = new Button("Job Listings");
        var buttonHotels = new Button("Book a hotel room");
        var buttonMuseums = new Button("Museums and history");
        var buttonQuality = new Button("See the quality of air in areas of the city");
        var buttonUniversities = new Button("See the Universities of Iasi");
        buttonUniversities.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonQuality.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonMuseums.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonJobs.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        parkingButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        logoutButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        buttonHotels.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(parkingButton, buttonJobs, buttonHotels, buttonMuseums, buttonQuality, buttonUniversities, logoutButton);

        logoutButton.addClickListener(click -> {
            UI.getCurrent().navigate("/logout");
        });

        parkingButton.addClickListener(click -> {
            UI.getCurrent().navigate("/parking/" + s, QueryParameters.fromString(s));
        });

        buttonJobs.addClickListener(click -> {
            UI.getCurrent().navigate("/jobs/" + s, QueryParameters.fromString(s));
        });

        buttonHotels.addClickListener(click->{
            UI.getCurrent().navigate("/hotels/" + s, QueryParameters.fromString(s));
        });

        buttonMuseums.addClickListener(click->{
            UI.getCurrent().navigate("/history/" + s, QueryParameters.fromString(s));
        });

        buttonQuality.addClickListener(click-> {
            UI.getCurrent().navigate("/qualityair/" + s, QueryParameters.fromString(s));
        });

        buttonUniversities.addClickListener(click->{
            UI.getCurrent().navigate("/universities/" + s, QueryParameters.fromString(s));
        });

        return buttonLayout;
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {
        this.personRepo = personRepo;
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.add(new H1("Welcome, " + s + "!"));
        headerLayout.add("Press a button below and choose your feature!");
        add(headerLayout);
        add(getButtons(s));
    }
}
