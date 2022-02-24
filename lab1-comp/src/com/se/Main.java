package com.se;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n*=3;
        String input0 = "10101";
        int i = Integer.parseInt(input0 , 2);
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
        while (finrez>9){
            int decc = finrez%10;
            rez+=decc;
            finrez/=10;
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[rez]);
    }
}
