package outfit;

import main.GamePanel;

public class Hat extends SuperOutfit{

    public Hat(GamePanel panel) {
        super(panel);
        name = "hat";
        price = 50;
        getImage(name, panel.tileSize, panel.tileSize);
    }
}
