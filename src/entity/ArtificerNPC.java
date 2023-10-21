package entity;

import main.GamePanel;

public class ArtificerNPC extends NPC{
    GamePanel panel;
    public ArtificerNPC(GamePanel panel) {
        super(panel);
        this.panel = panel;
        name = "artificer";
        getImage(name);
        setDefaultValues();
    }
}
