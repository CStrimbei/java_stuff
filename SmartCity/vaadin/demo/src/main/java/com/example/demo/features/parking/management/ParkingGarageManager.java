package com.example.demo.features.parking.management;

import com.example.demo.features.parking.repos.ParkingRepo;
import com.example.demo.features.parking.repos.ReservedRepo;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

public class ParkingGarageManager{
    /*TODO: split the three parking garages on three different threads, that update the database regularly with occupied spots
            and reserve spots
    * */

    private ParkingRepo parkingRepo;
    private ReservedRepo reservedRepo;
    private int occupiedSpaces;
    private int totalSpaces;

    public ParkingGarageManager(ParkingRepo parkingRepo, ReservedRepo reservedRepo, int totalSpaces, int occupiedSpaces) {
        this.parkingRepo = parkingRepo;
        this.reservedRepo = reservedRepo;
        this.occupiedSpaces = occupiedSpaces;
        this.totalSpaces = totalSpaces;
    }

    public void startThread(String address){
        /*SpaceCounter spaceCounter = new SpaceCounter(parkingRepo, reservedRepo);
        spaceCounter.seatCounter(address);*/
        ParkingThread parkingThread = new ParkingThread(parkingRepo, reservedRepo, address, totalSpaces, occupiedSpaces);
        System.out.println("Creating new thread for " + address);
        parkingThread.start();
    }
}
