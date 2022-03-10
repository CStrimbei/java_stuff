package com.se;

import java.util.Objects;

/**
 * The Event class.
 */

public class Event {
    public int size;
    public int start;
    public int end;
    public String name;

    /**
     * The constructor for the Event class.
     * @param SIZE The participant size of the event.
     * @param START The starting time of the event.
     * @param END The end time of the event.
     * @param NAME The name of the room in which the event is held.
     */
    public Event(int SIZE, int START, int END, String NAME) {
        this.size=SIZE;
        this.start=START;
        this.end=END;
        this.name=NAME;
    }

    public double getSize() {
        return size;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    public String getName() {
        return name;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setStart(int start) {
        this.start = start;
    }

    /**
     * The new, overwritten toString method.
     * @return Prints an instance of the Event class.
     */
    @Override
    public String toString() {

            return name + "(" +
                "size=" + size +
                ", start=" + start +
                ", end=" + end +
                ')';
    }

    /**
     * The new, overwritten equals method.
     * @param o The transmitted object.
     * @return Returns true or false, depending on if the objects compared are equal.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (start != event.start) return false;
        if (end != event.end) return false;
        return name.equals(event.name);
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        result = 31 * result + name.hashCode();
        return result;
    }
}
