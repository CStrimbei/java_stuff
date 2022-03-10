package com.se;

import java.util.Objects;

/**
 *  The abstract Room class, whose variables are inherited by the LectureHall and Lab class.
 */

public abstract class Room {
    public int cap;
    public String name;
    public String type;
    public int projector;
    OSType os;


    /**
     *  The new, overwritten equals method.
     * @param o The transmitted object.
     * @return Returns true or false, depending on if the objects compared are equal.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        return name.equals(room.name);
    }
}
