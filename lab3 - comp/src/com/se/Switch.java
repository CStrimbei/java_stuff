package com.se;

public class Switch extends Node{
    private String location;
    public Switch(String NAME, String LOCATION) {
        this.setName(NAME);
        this.location=LOCATION;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
