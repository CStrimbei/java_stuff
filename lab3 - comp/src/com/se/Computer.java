package com.se;

public class Computer extends Node implements Identifiable, Storage {
    private String address;
    private double storageCapacity;

    public Computer(String NAME, String IP, double CAP) {
       this.setName(NAME);
       this.address=IP;
       this.storageCapacity=CAP;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
