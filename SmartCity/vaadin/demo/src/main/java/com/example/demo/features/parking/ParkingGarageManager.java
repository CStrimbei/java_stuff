package com.example.demo.features.parking;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingGarageManager {
    public ParkingGarageManager() {
        String username = (String) VaadinSession.getCurrent().getSession().getAttribute("username");
        if(username!=null){
            System.out.println("Debug: " + username);
        }
    }
}
