package entity;

import main.GamePanel;

public class BossRushNPC extends NPC{
    GamePanel panel;
    public BossRushNPC(GamePanel panel) {
        super(panel);
        this.panel = panel;
        name = "bossrush";
        getImage(name);
        setDefaultValues();
    }
}
