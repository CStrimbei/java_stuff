package com.example.demo.features.hotels.views;

import com.example.demo.features.business.entity.Job;
import com.example.demo.features.hotels.entity.Hotel;
import com.example.demo.features.hotels.repo.HotelRepo;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.QueryParameters;

import java.util.List;

@PageTitle("Hotels")
public class HotelView extends VerticalLayout implements HasUrlParameter<String> {
    private HotelRepo hotelRepo;
    private Grid<Hotel> grid = new Grid<>(Hotel.class);

    public HotelView(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.add(new H1("Here is a hotel list!"));
        add(headerLayout);
        add(getHotels(s));
    }

    private VerticalLayout getHotels(String s) {
        var layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        var homeButton = new Button("Home");
        homeButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        var allHotels = hotelRepo.findAll();
        configureGrid(allHotels);
        add(grid, homeButton);
        homeButton.addClickListener(click->{
            UI.getCurrent().navigate("logged/" + s, QueryParameters.fromString(s));
        });
        return layout;
    }
    private void configureGrid(List<Hotel> allHotels) {
        grid.setColumns("name", "address", "roomprice", "contact");
        grid.setItems(hotelRepo.findAll());
    }
}
