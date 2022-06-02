package com.example.demo.features.parking.repos;


import com.example.demo.features.parking.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepo extends JpaRepository<Parking, Integer> {
    @Query("select u.id from Parking u where u.address=?1")
    Integer getId(String address);
    @Query("select u from Parking u where u.address=?1")
    Parking getObject(String address);
    @Query("select u.totalspots from Parking u where u.address=?1")
    Integer getTotalSpaces(String address);
}