package entity;

import main.GamePanel;

import java.awt.*;

public class Boss extends Monster{
    GamePanel panel;

    public void setDefaultValues(){
        speed = 1;
        direction = "down";
        collisionArea = new Rectangle(8, 16, 152, 136);
        collisionAreaDefaultX = collisionArea.x;
        collisionAreaDefaultY = collisionArea.y;
    }

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
