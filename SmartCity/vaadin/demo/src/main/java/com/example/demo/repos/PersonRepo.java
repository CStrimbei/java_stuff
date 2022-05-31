package com.example.demo.repos;

import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {
    @Query("select u from Person u where u.username=?1")
    Person findByUsername(String username);
    @Query("select u.password from Person u where u.username=?1")
    String findPassword(String username);
}
