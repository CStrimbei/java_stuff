package com.example.demo.features.parking.entity;

import com.example.demo.general.entity.Person;

import javax.persistence.*;

@Entity
@Table(name = "reserved")
public class Reserved {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private Person username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parkid")
    private Parking parkid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getUsername() {
        return username;
    }

    public void setUsername(Person username) {
        this.username = username;
    }

    public Parking getParkid() {
        return parkid;
    }

    public void setParkid(Parking parkid) {
        this.parkid = parkid;
    }

}