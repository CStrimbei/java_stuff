package com.example.demo.general.views.logged.administrative.threading.threads;

import com.example.demo.features.business.repo.JobRepo;

public class JobCountThread extends Thread{
    private JobRepo jobRepo;
    private Integer value2;
    public JobCountThread(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    public Integer getValue2() {
        return value2;
    }

    @Override
    public void run(){
        this.value2 = getAllJobCount();
        System.out.println("Debug thread 2: "+ value2);
    }
    private int getAllJobCount(){
        return jobRepo.getAllJobCount();
    }
}
