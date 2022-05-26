package com.example.lab11.Spring.Repos;

import com.example.lab11.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    @Query("select u from UserEntity u where u.name=?1")
    UserEntity findName(String name);
    @Query("select u from UserEntity u where u.id=?1")
    UserEntity findId(int id);
}
