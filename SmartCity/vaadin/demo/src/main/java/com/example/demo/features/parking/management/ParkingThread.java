package com.example.demo.features.parking.management;

import com.example.demo.features.parking.repos.ParkingRepo;
import com.example.demo.features.parking.repos.ReservedRepo;

import java.util.Random;

public class ParkingThread extends Thread{
    private String address;
    private ParkingRepo parkingRepo;
    private ReservedRepo reservedRepo;

    private int totalSpaces;
    private int occupiedSpaces;

    public ParkingThread(ParkingRepo parkingRepo, ReservedRepo reservedRepo, String address, int totalSpaces, int occupiedSpaces) {
        this.parkingRepo = parkingRepo;
        this.reservedRepo = reservedRepo;
        this.address = address;
        this.totalSpaces = totalSpaces;
        this.occupiedSpaces = occupiedSpaces;
    }

    @Override
    public void run(){
        var spaceCounter = new SpaceCounter(parkingRepo, reservedRepo);
        spaceCounter.seatCounter(address, occupiedSpaces, totalSpaces);
    }
}
