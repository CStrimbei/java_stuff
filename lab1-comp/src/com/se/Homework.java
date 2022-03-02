package com.se;
import java.util.Random;


public class Homework {

    public boolean isNeighbor() {
        boolean verify = true;



        return verify;
    }


    public static void main(String[] args) {
        int n = 0;
        int p = 0;
        if (args.length >= 3) {
            n = Integer.parseInt(args[0]);
            p = Integer.parseInt(args[1]);
            System.out.println("Numarul de argumente este valid!");
        } else if (args.length == 2) {
            System.out.println("Ai introdus doar primele 2 argumente!");
        } else if (args.length < 2) {
            System.out.println("Ai introdus prea putine argumente!");
        }
        char[] characters = new char[p]; int j = 0;
        for (int i = 2; i < args.length; i++){
            characters[j++]=args[i].charAt(0);
        }

        Random generate = new Random();


        String[] words = new String[n];
        for(int k = 0; k<n; k++){
            generate = new Random();

            String word="";

            for(int w=0; w<=p; w++) {

                int randomletter = generate.nextInt(characters.length - 1);
                char letter = characters[randomletter];
                /*
                while (word.contains(String.valueOf(letter))) {
                    randomletter = generate.nextInt(characters.length - 1);
                    letter = characters[randomletter];
                }*/
                word += letter;
            }


            words[k]=word;
        }

        for(String word : words)
            System.out.println(word);



        //System.out.println(randomletter);
    }

}
