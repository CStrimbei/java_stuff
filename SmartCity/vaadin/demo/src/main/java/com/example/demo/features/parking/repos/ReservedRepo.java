package com.example.demo.features.parking.repos;

import com.example.demo.features.parking.entity.Parking;
import com.example.demo.features.parking.entity.Reserved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ReservedRepo extends JpaRepository<Reserved, Long> {
    @Query("select count(u.id) from Reserved u where u.parkid=:p_id")
    Integer getFreeSpaceCount(Parking p_id);
    @Query("select u.username from Reserved u")
    ArrayList<String> getList();
    @Query("select count(u.id) from Reserved u")
    Integer getCountOfReserved();
}
