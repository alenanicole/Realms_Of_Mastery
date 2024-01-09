package outfit;

import main.GamePanel;

public class Jacket extends SuperOutfit{

    public Jacket(GamePanel panel) {
        super(panel);
        name = "jacket";
        price = 150;
        getImage(name, panel.tileSize, panel.tileSize);
    }
}
