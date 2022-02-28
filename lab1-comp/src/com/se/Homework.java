package com.se;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Scanner;
public class Homework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        if(args.length>=3){
            int n = Integer.parseInt(args[0]);
            int p = Integer.parseInt(args[1]);
            System.out.println("Numarul de argumente este valid!");
        }
        else if(args.length == 2){
            System.out.println("Ai introdus doar primele 2 argumente!");
        } else if(args.length <2 ){
            System.out.println("Ai introdus prea putine argumente!");
        }

    }
}
