package com.se;

public class Main {

    public static int sumDig(int n) {
        int rezult = 0;
        while (n > 0) {
            rezult += n % 10;
            n /= 10;
        }
        return rezult;
    }



    public static void main(String[] args) {
        System.out.println("Hello world!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        String input0 = "10101";
        int i = Integer.parseInt(input0 , 2);
        String nrhex = "FF";
        int dec = Integer.parseInt(nrhex, 16);
        int finalRez = 0;
        int rezz = (n*3 + i + dec)*6;
        if(sumDig(rezz)>9){
            int auxVal = sumDig(rezz);
            finalRez = sumDig(auxVal);
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[finalRez]);
        //System.out.println("Willy-nilly, this semester I will learn " + languages[rez]);
    }
}
