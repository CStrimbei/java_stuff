package com.example.lab11.Entities;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class FriendEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusr1")
    private UserEntity idusr1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusr2")
    private UserEntity idusr2;

    public UserEntity getIdusr2() {
        return idusr2;
    }

    public void setIdusr2(UserEntity idusr2) {
        this.idusr2 = idusr2;
    }

    public UserEntity getIdusr1() {
        return idusr1;
    }

    public void setIdusr1(UserEntity idusr1) {
        this.idusr1 = idusr1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}