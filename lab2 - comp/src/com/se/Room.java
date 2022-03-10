package com.se;

import java.util.Objects;

public class Room {
    public int cap;
    public String name;
    public Types type;

    public Room(int CAP, Types TYPE, String NAME) {
        this.cap = CAP;
        this.type = TYPE;
        this.name = NAME;
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

        Room room = (Room) o;

        return name.equals(room.name);
    }
}
