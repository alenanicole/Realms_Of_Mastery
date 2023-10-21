package entity;

import main.GamePanel;

public class OutfitterNPC extends NPC{
    GamePanel panel;
    public OutfitterNPC(GamePanel panel) {
        super(panel);
        this.panel = panel;
        name = "outfitter";
        getImage(name);
        setDefaultValues();
    }
}
