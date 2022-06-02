package com.example.demo.features.parking.repos;

import com.example.demo.features.parking.entity.Parking;
import com.example.demo.features.parking.entity.Reserved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservedRepo extends JpaRepository<Reserved, Long> {
    @Query("select count(u.id) from Reserved u where u.parkid=:p_id")
    Integer getFreeSpaceCount(Parking p_id);
}
