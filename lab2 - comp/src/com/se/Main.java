package com.se;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Events> event = new ArrayList<>();
        List<Rooms> room = new ArrayList<>();

        event.add(new Events(100, 8, 10, "C1"));
        event.add(new Events(100, 10, 12, "C2"));
        event.add(new Events(30, 8, 10, "L1"));
        event.add(new Events(30, 8, 10, "L2"));
        event.add(new Events(30, 10, 12, "L3"));

        room.add(new Rooms(30, Types.lab, "401"));
        room.add(new Rooms(30, Types.lab, "403"));
        room.add(new Rooms(30, Types.lab, "405"));
        room.add(new Rooms(30, Types.lecture_hall, "401"));

        System.out.print("Events: ");

        for(Events e : event)
            System.out.print(e + " ");

        System.out.println();

        System.out.print("Rooms: ");
        for(Rooms r : room)
            System.out.print(r + " ");
    }
}
