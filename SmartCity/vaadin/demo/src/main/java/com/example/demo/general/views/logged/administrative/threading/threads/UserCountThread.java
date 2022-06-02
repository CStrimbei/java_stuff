package com.example.demo.general.views.logged.administrative.threading.threads;

import com.example.demo.general.repos.PersonRepo;

public class UserCountThread extends Thread{

    private PersonRepo personRepo;
    private Integer value;

    public UserCountThread(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public void run(){
        this.value = getTotalUserNumber();
        System.out.println("Debug thread 1: "+ value);
    }

    public Integer getValue() {
        return value;
    }

    private int getTotalUserNumber(){
        return personRepo.findCountAll();
    }
}
