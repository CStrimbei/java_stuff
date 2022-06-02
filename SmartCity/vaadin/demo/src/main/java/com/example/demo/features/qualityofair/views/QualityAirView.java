package com.example.demo.features.qualityofair.views;

import com.example.demo.features.qualityofair.randomizer.QualityRandomizer;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.QueryParameters;

@PageTitle("Quality of air")
public class QualityAirView extends VerticalLayout implements HasUrlParameter<String> {
    private Select<String> areas = new Select<>();
    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.add(new H1("Welcome, " + s + "!"));
        headerLayout.add("Choose an area!");
        add(headerLayout);
        add(getAreaList());
        add(getResultButton(s));
    }

    private VerticalLayout getResultButton(String s) {
        var layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        var checkOutButton = new Button("See quality");
        checkOutButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        var homeButton = new Button("Home");
        homeButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        layout.add(checkOutButton, homeButton);
        checkOutButton.addClickListener(click ->{
            QualityRandomizer qualityRandomizer = new QualityRandomizer();
            String quality = qualityRandomizer.getQuality();
            layout.removeAll();
            layout.add("The quality of air in " + areas.getValue() + " is " + quality + ".");
            layout.add(checkOutButton, homeButton);
        });
        homeButton.addClickListener(click->{
            UI.getCurrent().navigate("/logged/" + s, QueryParameters.fromString(s));
        });
        return layout;
    }

    private VerticalLayout getAreaList() {
        var layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        areas.setLabel("Choose the area you want to check out");
        areas.setItems("Pacurari", "Copou", "Alexandru", "Dacia");
        layout.add(areas);
        return layout;
    }
}
