package outfit;

import main.GamePanel;

public class Hat extends SuperOutfit{

    public Hat(GamePanel panel) {
        super(panel);
        name = "hat";
        price = 100;
        available = true;
        getImage(name, panel.tileSize, panel.tileSize);
    }
}
