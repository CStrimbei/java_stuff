package com.example.lab11.Spring.Repos;

import com.example.lab11.Entities.FriendEntity;
import com.example.lab11.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepo extends JpaRepository<FriendEntity, Integer> {
    @Query("select f from FriendEntity f where f.idusr1 = ?1 and f.idusr2 = ?2")
    FriendEntity areFriends(int id1, int id2);
}
