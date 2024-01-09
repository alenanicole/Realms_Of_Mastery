package outfit;

import main.GamePanel;

public class Checker extends SuperOutfit{

    public Checker(GamePanel panel) {
        super(panel);
        name = "checker";
        price = 150;
        getImage(name, panel.tileSize, panel.tileSize);
    }
}
