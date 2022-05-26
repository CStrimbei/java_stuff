package com.example.lab11.Entities;

import com.example.lab11.Entities.User;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusr1")
    private User idusr1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusr2")
    private User idusr2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getIdusr1() {
        return idusr1;
    }

    public void setIdusr1(User idusr1) {
        this.idusr1 = idusr1;
    }

    public User getIdusr2() {
        return idusr2;
    }

    public void setIdusr2(User idusr2) {
        this.idusr2 = idusr2;
    }

}