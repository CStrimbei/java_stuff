package compulsory;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final List<String> words=new ArrayList<String>();
    public static void addWord(Player player, String word){
        words.add(word);
        System.out.println(player.getName()+" : " + word);
    }

    @Override
    public String toString() {
        return "Board{" +
                "words=" + words +
                '}';
    }
}
