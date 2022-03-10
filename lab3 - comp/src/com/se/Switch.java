package com.se;

public class Switch extends Node implements Identifiable{
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

    @Override
    public String getAddress() {
        return null;
    }
}
