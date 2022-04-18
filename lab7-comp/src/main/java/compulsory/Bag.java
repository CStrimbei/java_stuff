package compulsory;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private final List<Character> tiles=new ArrayList<Character>();

    public Bag(){
        for(char c='a';c<'z';c++) {
            tiles.add(c);
        }
    }
}
