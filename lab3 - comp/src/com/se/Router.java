package com.se;

public class Router extends Node implements Identifiable{
    private String address;
    private String mac;

    public Router(String NAME, String IP, String MAC) {
        this.setName(NAME);
        this.address=IP;
        this.mac=MAC;
    }

    @Override
    public String getAddress() {
        return address;
    }
    public String getMac() {
        return mac;
    }
}
