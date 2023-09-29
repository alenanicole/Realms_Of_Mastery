package entity;

import main.GamePanel;

public class Boss extends Monster{
    GamePanel panel;

    public Boss(GamePanel panel){
        super(panel);
        this.panel = panel;
        name = "boss";
        getImage(name, panel.tileSize * 4, panel.tileSize * 4);
        setDefaultValues();
        maxHealth = 30;
        currentHealth = maxHealth;
    }
}
