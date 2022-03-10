package com.se;

import java.util.Objects;

public class Events {
    public int size;
    public int start;
    public int end;
    public String name;
    public Events(int SIZE, int START, int END, String NAME) {
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

    public int checkEquals(){
        if(equals(name)==true){
            return 0;
        }
        return 1;
    }

    @Override
    public String toString() {

        //if(checkEquals()==1)
            return name + "(" +
                "size=" + size +
                ", start=" + start +
                ", end=" + end +
                ')';
        //else return "Nu poti adauga acelasi eveniment de 2 ori!";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Events events = (Events) o;
        return size == events.size && start == events.start && end == events.end && Objects.equals(name, events.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, start, end, name);
    }
}
