package com.se;

public class Rooms{
    public int cap;
    public String name;
    public Types type;
    public Rooms(int CAP, Types TYPE, String NAME) {
        this.cap=CAP;
        this.type=TYPE;
        this.name=NAME;
    }

    @Override
    public String toString() {
        return name + '(' +
                "cap=" + cap +
                ", name='" + name + '\'' +
                ", type=" + type +
                ')';
    }


    public int getCap() {
        return cap;
    }

    public String getName() {
        return name;
    }

    public Types getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public void setType(Types type) {
        this.type = type;
    }
}
