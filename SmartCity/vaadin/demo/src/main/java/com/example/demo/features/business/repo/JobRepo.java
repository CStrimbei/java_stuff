package com.example.demo.features.business.repo;

import com.example.demo.features.business.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<Job, Integer> {
    @Query("select u from Job u")
    List<Job> findAll();
    @Query("select count(u) from Job u")
    Integer getAllJobCount();
}
