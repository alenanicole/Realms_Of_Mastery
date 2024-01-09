package outfit;

import main.GamePanel;

public class Suit extends SuperOutfit{

    public Suit(GamePanel panel) {
        super(panel);
        name = "suit";
        price = 150;
        getImage(name, panel.tileSize, panel.tileSize);
    }
}
