package com.se;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n*=3;
        int i = (byte) 10101;
        n+=i;
        String nrhex = "FF";
        int dec = Integer.parseInt(nrhex, 16);
        n+=dec;
        n*=6;
        int finrez = 0;
        while(n>0)
        {
            int decc = n%10;
            finrez+=decc;
            n/=10;
        }
        int rez = 0;
        if (finrez>10){
            int decc = finrez%10;
            rez+=decc;
            finrez/=10;
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[rez]);
    }
}
