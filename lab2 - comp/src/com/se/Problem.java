package com.se;

import java.util.ArrayList;
import java.util.List;

public class Problem {

    List<Event> events = new ArrayList<>();
    List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room){
        for (Room r:rooms) {
            if(r.equals(room))
                return;
        }
        rooms.add(room);
    }

    public void addEvent(Event event){
        for(Event e:events){
            if(e.equals(event))
                return;
        }
    }

    public void runProblem(){
        System.out.print("Events: ");

        for(Event e : events)
            System.out.print(e + " ");

        System.out.println();

        System.out.print("Rooms: ");

        for(Room r : rooms)
            System.out.print(r + " ");
    }
}