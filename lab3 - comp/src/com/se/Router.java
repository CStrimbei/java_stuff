package com.se;

import java.util.Map;

/**
 * The Router class.
 */

public class Router extends Node implements Identifiable{
    private String address;
    private String mac;

    /**
     * Constructor for the Router class.
     * @param NAME Name of the router.
     * @param IP The IP address for the router.
     * @param MAC The MAC address for the router.
     */
    public Router(String NAME, String IP, String MAC) {
        this.setName(NAME);
        this.address=IP;
        this.mac=MAC;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    /**
     * Overwritten method for getAddress()
     * @return Returns the address.
     */
    @Override
    public String getAddress() {
        return address;
    }
    public String getMac() {
        return mac;
    }
}
