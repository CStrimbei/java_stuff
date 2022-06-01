package com.example.demo.features.parking.entity;

import javax.persistence.*;

@Entity
@Table(name = "parking")
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "totalspots")
    private Integer totalspots;

    @Column(name = "reservedspots")
    private Integer reservedspots;

    @Column(name = "freespots")
    private Integer freespots;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getTotalspots() {
        return totalspots;
    }

    public void setTotalspots(Integer totalspots) {
        this.totalspots = totalspots;
    }

    public Integer getReservedspots() {
        return reservedspots;
    }

    public void setReservedspots(Integer reservedspots) {
        this.reservedspots = reservedspots;
    }

    public Integer getFreespots() {
        return freespots;
    }

    public void setFreespots(Integer freespots) {
        this.freespots = freespots;
    }

}