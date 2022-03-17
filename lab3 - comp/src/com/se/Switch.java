package com.se;

/**
 * The Switch class.
 */

public class Switch extends Node{
    private String location;

    /**
     * Constructor for the Switch class.
     * @param NAME The name of the switch.
     * @param LOCATION The location of the switch.
     */
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
