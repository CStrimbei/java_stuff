package com.example.demo.features.parking.management;

import com.example.demo.features.parking.entity.Parking;
import com.example.demo.features.parking.repos.ParkingRepo;
import com.example.demo.features.parking.repos.ReservedRepo;

import java.util.Random;

public class SpaceCounter {

    private ParkingRepo parkingRepo;
    private ReservedRepo reservedRepo;
    private int totalSpaces;
    private int occupiedSpaces;
    private int reservedSpaces;
    private int freeSpaces;


    public SpaceCounter(ParkingRepo parkingRepo, ReservedRepo reservedRepo) {
        this.parkingRepo = parkingRepo;
        this.reservedRepo = reservedRepo;
    }

    public void seatCounter(String address, int occupiedSpaces, int totalSpaces){
        //this function will update the parking table, filling in the occupied spaces and everything

        Parking parking = new Parking();
        parking = parkingRepo.getObject(address);
        int occupied = occupiedSpaces;
        int total = totalSpaces;
        /*System.out.println("Debug: " + address + "///" +parkingRepo.getId(address));
        System.out.println("Debug: " + reservedRepo.getFreeSpaceCount(parking));*/
        reservedSpaces = reservedRepo.getFreeSpaceCount(parking);
        occupied += reservedSpaces;
        freeSpaces = total - occupied;
        //System.out.println("Occupied: " + occupied + " " + "Reserved: " + reservedSpaces + " "+ "Free: " + freeSpaces + " Total: " + total);
        updateSeats(reservedSpaces, freeSpaces, address);
    }

    public void updateSeats(int reservedSpaces, int freeSpaces, String address){
        var parking = parkingRepo.getObject(address);
        parkingRepo.updateParking(freeSpaces, reservedSpaces, parking.getId());
    }

}
