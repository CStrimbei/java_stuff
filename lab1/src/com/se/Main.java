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
        System.out.println(n);
    }
}
