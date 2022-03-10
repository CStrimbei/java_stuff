package com.se;

public class Computer extends Node implements Identifiable, Storage {
    private String address;
    private int storageCapacity;

    public Computer(String NAME, String IP, int CAP) {
       this.setName(NAME);
       this.address=IP;
       this.storageCapacity=CAP;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int getStorageCapacity() {
        return storageCapacity;
    }
}
