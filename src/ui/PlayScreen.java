package ui;

import main.GamePanel;

import java.awt.*;

public class PlayScreen extends UI {

    Graphics2D graphics2D;
    GamePanel panel;

    public PlayScreen(GamePanel panel) {
        super(panel);
        this.panel = panel;
    }

    public void draw(Graphics2D graphics2D){
        this.graphics2D = graphics2D;
        graphics2D.setFont(press_start);
        int y = panel.tileSize;
        int x = panel.tileSize;
        boolean lastHeart = false;


        for(int i = 1; i <= panel.player.maxHealth/2; i++) {
            if(panel.player.currentHealth >= i * 2){
                graphics2D.drawImage(fullHeart, x, y, null);
            }else if(panel.player.currentHealth < i * 2 && !lastHeart){
                graphics2D.drawImage(halfHeart, x, y, null);
                lastHeart = true;
            }else{
                graphics2D.drawImage(emptyHeart, x, y, null);
            }

            x += panel.tileSize;
        }

        x = panel.tileSize;
        y += panel.tileSize;
        if(panel.items[4].inUse){
            graphics2D.drawImage(boot, x, y, null);
        }

        x += panel.tileSize;
        if(panel.items[3].inUse){
            graphics2D.drawImage(dumbbell, x, y, null);
            x+= panel.tileSize/2;
            y += panel.tileSize;
            String text = "x" + String.valueOf(panel.numOfFight);
            graphics2D.setColor(Color.black);
            graphics2D.drawString(text, x + 3, y + 3);
            graphics2D.setColor(Color.white);
            graphics2D.drawString(text, x, y);
        }
    }
}