package com.se;

public class Lab extends Room {
    public Lab(int CAP, String NAME, OSType OS){
        this.name=NAME;
        this.cap=CAP;
        this.type="Laboratory";
        this.os = OS;
    }
    public int getCap() {
        return cap;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name + '(' +
                "cap=" + cap +
                ", name='" + name + '\'' +
                ", type=" + type + " os=" + os +
                ')';
    }
}
