package com.se;

import java.util.ArrayList;
import java.util.List;

public class Problem {

    public void instProblem(){
        List<Event> event = new ArrayList<>();
        List<Room> room = new ArrayList<>();

        event.add(new Event(100, 8, 10, "C1"));
        event.add(new Event(100, 10, 12, "C2"));
        event.add(new Event(30, 8, 10, "L1"));
        event.add(new Event(30, 8, 10, "L2"));
        event.add(new Event(30, 10, 12, "L3"));

        room.add(new Room(30, Types.lab, "401"));
        room.add(new Room(30, Types.lab, "403"));
        room.add(new Room(30, Types.lab, "405"));
        room.add(new Room(30, Types.lecture_hall, "401"));

        System.out.print("Events: ");

        for(Event e : event)
            System.out.print(e + " ");

        System.out.println();

        System.out.print("Rooms: ");

        for(Room r : room)
            System.out.print(r + " ");
    }
}