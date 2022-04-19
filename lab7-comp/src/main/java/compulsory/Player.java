package compulsory;

import java.util.List;

public class Player {
    private String name;
    private Game game;
    private boolean running;

    public Player(String name) {
        this.name = name;
    }

    private boolean submitWord() {
        List<Tile> extracted = (List<Tile>) game.getBag();
        if (extracted.isEmpty()) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setGame(Game game) {
    }
}
