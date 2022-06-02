package com.example.demo.features.qualityofair.randomizer;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QualityRandomizer {
    private List<String> qualities = new ArrayList<>();
    private Random rand = new Random();
    private DateTimeFormatter dtf;
    private LocalDateTime now;
    public QualityRandomizer() {
        qualities.add("fresh");
        qualities.add("good");
        qualities.add("mediocre");
        qualities.add("bad");
        qualities.add("dangerous");
        dtf = DateTimeFormatter.ofPattern("HH");
        now = LocalDateTime.now();
    }
    public String getQuality(){
        //System.out.println("Debug: " + dtf.format(now));
        //System.out.println("Debug: " + qualities.size());
        if(dtf.format(now).equals("03")||dtf.format(now).equals("04")||dtf.format(now).equals("05")) { // 3->5
            return qualities.get(1);
        } else if(dtf.format(now).equals("06")||dtf.format(now).equals("07")||dtf.format(now).equals("08")||dtf.format(now).equals("09")){ // 5 -> 9
            return qualities.get(rand.nextInt(2));
        } else if(dtf.format(now).equals("10")||dtf.format(now).equals("11")){ // 9 -> 11
            return qualities.get(rand.nextInt(3-2)+2);
        } else if(dtf.format(now).equals("12")||dtf.format(now).equals("13")){ // 11 -> 13
            return qualities.get(rand.nextInt(4-3)+3);
        } else if(dtf.format(now).equals("14")||dtf.format(now).equals("15")||dtf.format(now).equals("16")||dtf.format(now).equals("17")){ // 13 -> 17
            return qualities.get(rand.nextInt(rand.nextInt(5-4)+4));
        } else if(dtf.format(now).equals("18")||dtf.format(now).equals("19")){ // 17 -> 19
            return qualities.get(rand.nextInt(rand.nextInt(4-3)+3));
        } else if(dtf.format(now).equals("20")||dtf.format(now).equals("21")||dtf.format(now).equals("22")||dtf.format(now).equals("23")||dtf.format(now).equals("00")){ // 19 -> 00
            return qualities.get(rand.nextInt(2));
        } else if(dtf.format(now).equals("01")||dtf.format(now).equals("02")){ // 00 -> 3
            return qualities.get(1);
        }

        return qualities.get(rand.nextInt(qualities.size()));
    }


}
