package com.example.demo.general.views.logged.administrative.threading.threads;

import com.example.demo.features.parking.repos.ReservedRepo;

public class ReservedSpotsThread extends Thread{
    private ReservedRepo reservedRepo;
    private Integer value3;

    public ReservedSpotsThread(ReservedRepo reservedRepo) {
        this.reservedRepo = reservedRepo;
    }

    public Integer getValue3() {
        return value3;
    }

    @Override
    public void run(){
       this.value3=getReservedSpaceCount();
        System.out.println("Debug thread 3: "+ value3);
    }
    private int getReservedSpaceCount(){
        return reservedRepo.getCountOfReserved();
    }
}
