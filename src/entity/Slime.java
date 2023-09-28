package entity;

import main.GamePanel;

public class Slime extends Monster{

    GamePanel panel;

    public Slime(GamePanel panel){
        super(panel);
        this.panel = panel;
        name = "slime";
        getImage(name);
        setDefaultValues();
        maxHealth = 10;
        currentHealth = maxHealth;
    }
}
