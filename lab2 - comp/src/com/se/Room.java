package com.se;

import java.util.Objects;

public abstract class Room {
    public int cap;
    public String name;
    public String type;
    public int projector;
    OSType os;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        return name.equals(room.name);
    }
}
