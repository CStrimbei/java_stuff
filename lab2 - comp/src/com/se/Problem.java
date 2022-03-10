package com.se;

import java.util.ArrayList;
import java.util.List;

/**
 * The Problem class, which contains some methods that are used in Main.
 */

public class Problem {


    List<Event> events = new ArrayList<>();
    List<Room> rooms = new ArrayList<>();

    /**
     * This function adds a room instance to the array list, and uses the equals
     * method to make sure that there's no duplicates.
     * @param room The instance.
     */
    public void addRoom(Room room){
        if(rooms.contains(room))
            return;
        rooms.add(room);
    }

    /**
     * This function adds an event instance to the array list, and uses the equals
     *      * method to make sure that there's no duplicates.
     * @param event The instance.
     */

    public void addEvent(Event event){
        if(events.contains(event))
            return;
        events.add(event);
    }

    /**
     * The method that prints the rooms/events.
     */

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