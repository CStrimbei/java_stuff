package com.se;

import java.util.Objects;

public class Rooms {
    public int cap;
    public String name;
    public Types type;
    public Rooms(int CAP, Types TYPE, String NAME) {
        this.cap=CAP;
        this.type=TYPE;
        this.name=NAME;
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

    @Override
    public String toString() {
        return name + '(' +
                "cap=" + cap +
                ", name='" + name + '\'' +
                ", type=" + type +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rooms rooms = (Rooms) o;
        return cap == rooms.cap && Objects.equals(name, rooms.name) && type == rooms.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cap, name, type);
    }
}
