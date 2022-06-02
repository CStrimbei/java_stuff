package com.example.demo.features.parking.repos;


import com.example.demo.features.parking.entity.Parking;

import org.springframework.boot.context.properties.bind.Name;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ParkingRepo extends JpaRepository<Parking, Integer> {
    @Query("select u.id from Parking u where u.address=:p_name")
    Integer getId(String p_name);
    @Query("select u from Parking u where u.address=?1")
    Parking getObject(String address);
    @Query("select u.totalspots from Parking u where u.address=?1")
    Integer getTotalSpaces(String address);
    @Transactional
    @Modifying
    @Query("update Parking u set u.freespots=?1, u.reservedspots=?2 where u.id=?3")
    void updateParking(Integer freespots, Integer reservedspots, Integer id);
}