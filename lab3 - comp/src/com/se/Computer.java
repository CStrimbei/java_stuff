package com.se;

/**
 * The Computer class.
 */

public class Computer extends Node implements Identifiable, Storage {
    private String address;
    private double storageCapacity;

    /**
     * Constructor for the Computer class.
     * @param NAME The name of the computer.
     * @param IP The IP address for the computer.
     * @param CAP The storage capacity of the computer.
     */
    public Computer(String NAME, String IP, double CAP) {
       this.setName(NAME);
       this.address=IP;
       this.storageCapacity=CAP;
    }
    /**
     * Overwritten method for getAddress()
     * @return Returns the address.
     */
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
