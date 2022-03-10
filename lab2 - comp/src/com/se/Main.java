package com.se;

/**
 * The Main class.
 */

public class Main {

    /**
     * The main class, where Events and Rooms are added, and methods are called.
     * @param args
     */

    public static void main(String[] args) {
        Problem method = new Problem();
        method.addEvent(new Event(100, 8, 10, "C1"));
        method.addEvent(new Event(100, 8, 10, "C1"));
        method.addEvent(new Event(100, 10, 12, "C2"));
        method.addEvent(new Event(30, 8, 10, "L1"));
        method.addEvent(new Event(30, 8, 10, "L2"));
        method.addEvent(new Event(30, 10, 12, "L3"));
        
        method.addRoom(new Lab(30, "401", OSType.Windows));
        method.addRoom(new Lab(30, "401", OSType.MacOS));
        method.addRoom(new Lab(30, "403", OSType.Windows));
        method.addRoom(new Lab(30, "405", OSType.Linux));
        method.addRoom(new LectureHall(30, "402",1));
        method.addRoom(new LectureHall(30, "404",0));
        method.runProblem();
    }
}
