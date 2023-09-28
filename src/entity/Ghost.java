package entity;

import main.GamePanel;

public class Ghost extends Monster{

    GamePanel panel;

    public Ghost(GamePanel panel){
        super(panel);
        this.panel = panel;
        name = "ghost";
        getImage(name);
        setDefaultValues();
        maxHealth = 10;
        currentHealth = maxHealth;
    }
}