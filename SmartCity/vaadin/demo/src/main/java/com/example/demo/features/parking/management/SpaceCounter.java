package com.example.demo.features.parking.management;

import com.example.demo.features.parking.repos.ParkingRepo;
import com.example.demo.features.parking.repos.ReservedRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class SpaceCounter {
    private Random randomizer = new Random();
    private ParkingRepo parkingRepo;
    private ReservedRepo reservedRepo;
    private int totalSpaces;
    private int occupiedSpaces;
    private int reservedSpaces;
    private int freeSpaces;

    public SpaceCounter(){

    }

    @Autowired
    SpaceCounter(ParkingRepo parkingRepo, ReservedRepo reservedRepo) {
        this.parkingRepo = parkingRepo;
        this.reservedRepo = reservedRepo;
    }

    public void seatCounter(String address){
        //this function will update the parking table, filling in the occupied spaces and everything
        totalSpaces = parkingRepo.getTotalSpaces(address);
        occupiedSpaces = randomizer.nextInt(totalSpaces + 1);
        reservedSpaces = reservedRepo.getFreeSpaceCount(parkingRepo.getId(address));
        occupiedSpaces += reservedSpaces;
        freeSpaces = totalSpaces - occupiedSpaces;
        System.out.println(occupiedSpaces + " " + reservedSpaces + " " + freeSpaces);
    }
}
