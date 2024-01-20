package outfit;

import main.GamePanel;

public class Ragtag extends SuperOutfit{

    public Ragtag(GamePanel panel) {
        super(panel);
        name = "ragtag";
        price = 100;
        getImage(name, panel.tileSize, panel.tileSize);
    }
}
