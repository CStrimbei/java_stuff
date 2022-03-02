package com.se;
import java.util.Arrays;
import java.util.Random;


public class Homework {

public static int stringsToChars(String words1, String words2){
    int returnedInt = 0;
    for(int k = 0; k<words1.length(); k++){
        for(int b = 0; b<words2.length(); b++){
            char c1 = words1.charAt(k);
            char c2 = words2.charAt(b);
            if(c1 == c2) {
                returnedInt = 1;
                break;
            }
        }
    }
    return returnedInt;
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

            for(int w=0; w<p; w++) {

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

        int boolmatrix[][] = new int[n][n];

        for(int i = 0; i<n; i++){
            for(int k=i+1; k<n; k++){
                boolmatrix[i][k] = stringsToChars(words[i], words[j]);
                boolmatrix[k][i] = stringsToChars(words[i], words[j]);
            }
        }

        for(int g = 0; g < boolmatrix.length; g++){
            for(int s = 0; s < boolmatrix.length; s++){
                System.out.print(boolmatrix[g][s] + " ");
            }
            System.out.println();
        }
    }

}
