package entity;

import main.GamePanel;

public class Outfitter extends NPC{
    GamePanel panel;
    public Outfitter(GamePanel panel) {
        super(panel);
        this.panel = panel;
        name = "outfitter";
        getImage(name);
        setDefaultValues();
    }
}
