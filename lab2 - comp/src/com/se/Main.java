package com.se;

public class Main {

    public static void main(String[] args) {
        Problem method = new Problem();



        method.addEvent(new Event(100, 8, 10, "C1"));
        method.addEvent(new Event(100, 8, 10, "C1"));
        method.addEvent(new Event(100, 10, 12, "C2"));
        method.addEvent(new Event(30, 8, 10, "L1"));
        method.addEvent(new Event(30, 8, 10, "L2"));
        method.addEvent(new Event(30, 10, 12, "L3"));
        
        method.addRoom(new Room(30, Types.lab, "401"));
        method.addRoom(new Room(30, Types.lab, "401"));
        method.addRoom(new Room(30, Types.lab, "403"));
        method.addRoom(new Room(30, Types.lab, "405"));
        method.addRoom(new Room(30, Types.lecture_hall, "401"));


        method.runProblem();
    }
}
