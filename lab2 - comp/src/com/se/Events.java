package com.se;

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

    @Override
    public String toString() {
        return name + "(" +
                "size=" + size +
                ", start=" + start +
                ", end=" + end +
                ')';
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
}
