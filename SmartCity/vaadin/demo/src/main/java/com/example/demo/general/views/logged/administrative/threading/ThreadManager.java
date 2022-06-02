package com.example.demo.general.views.logged.administrative.threading;

import com.example.demo.features.business.repo.JobRepo;
import com.example.demo.features.parking.repos.ReservedRepo;
import com.example.demo.general.repos.PersonRepo;
import com.example.demo.general.views.logged.administrative.threading.threads.JobCountThread;
import com.example.demo.general.views.logged.administrative.threading.threads.ReservedSpotsThread;
import com.example.demo.general.views.logged.administrative.threading.threads.UserCountThread;
import com.vaadin.flow.server.VaadinService;

import java.util.ArrayList;

public class ThreadManager{
    private ReservedRepo reservedRepo;
    private PersonRepo personRepo;
    private JobRepo jobRepo;

    public ThreadManager(ReservedRepo reservedRepo, PersonRepo personRepo, JobRepo jobRepo) {
        this.reservedRepo = reservedRepo;
        this.personRepo = personRepo;
        this.jobRepo = jobRepo;
    }

    public ArrayList<Object> runThreads() throws InterruptedException {

        UserCountThread userCountThread = new UserCountThread(personRepo);
        JobCountThread jobCountThread = new JobCountThread(jobRepo);
        ReservedSpotsThread reservedSpotsThread = new ReservedSpotsThread(reservedRepo);

        userCountThread.start();
        while(!userCountThread.getState().equals(Thread.State.TERMINATED)){continue;}
        jobCountThread.start();
        while(!jobCountThread.getState().equals(Thread.State.TERMINATED)){continue;}
        reservedSpotsThread.start();
        while(!reservedSpotsThread.getState().equals(Thread.State.TERMINATED)){continue;}
        //while(value1==0&&value2==0&&value3==0)
        while(!userCountThread.getState().equals(Thread.State.TERMINATED)&&!jobCountThread.getState().equals(Thread.State.TERMINATED)&&!reservedSpotsThread.getState().equals(Thread.State.TERMINATED)){

            //VaadinService.getCurrent().wait(1000);
            continue;
        }
        System.out.println("Debug while: "+ userCountThread.getValue() + " " + jobCountThread.getValue2() + " " + reservedSpotsThread.getValue3());
        var valuelist = new ArrayList<>();
        valuelist.add(userCountThread.getValue());
        valuelist.add(jobCountThread.getValue2());
        valuelist.add(reservedSpotsThread.getValue3());
        return valuelist;
    }
}
