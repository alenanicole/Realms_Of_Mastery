package ui;

import main.GamePanel;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class StatsScreen extends UI{
    Graphics2D graphics2D;
    GamePanel panel;

    public StatsScreen(GamePanel panel) {
        super(panel);
        this.panel = panel;
    }

    public void drawFloat(int x, int y, String text, int offset){
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + offset, y + offset);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);
    }

    public void draw(Graphics2D graphics2D){
        this.graphics2D = graphics2D;
        graphics2D.setFont(joystix);
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.setColor(background);
        graphics2D.fill(new RoundRectangle2D.Float(panel.screenWidth - panel.tileSize * 6, (int)(panel.tileSize * 1.4), panel.tileSize * 2, panel.tileSize, 10, 10));
        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(panel.screenWidth - panel.tileSize * 4, (int)(panel.tileSize * 1.4), panel.tileSize * 2, panel.tileSize, 10, 10));
        graphics2D.setColor(background);
        graphics2D.fill(new RoundRectangle2D.Float(panel.tileSize * 2, panel.tileSize * 2, panel.screenWidth - panel.tileSize * 4, panel.screenHeight - panel.tileSize * 4, 30, 30));


        graphics2D.getFont().deriveFont(Font.BOLD);
        String text = "STATS";
        int x = getCenteredX(text, graphics2D);
        int y = panel.tileSize * 3;
        drawFloat(x, y, text, 5);

        x = panel.tileSize * 3;
        y += panel.tileSize;
        int resetY = y;

        graphics2D.setFont(press_start);
        text = "Tier One Damage: " + panel.player.tierOneDamage;
        drawFloat(x, y, text, 3);
        y += panel.tileSize;
        text = "Tier Two Damage: " + panel.player.tierTwoDamage;
        drawFloat(x, y, text, 3);
        y += panel.tileSize;
        text = "Tier Three Damage: " + panel.player.tierThreeDamage;
        drawFloat(x, y, text, 3);

        x += panel.tileSize * 8;
        y = resetY;
        text = "Max Health: " + panel.player.maxHealth;
        drawFloat(x, y, text, 3);
        y+= panel.tileSize;
        text = "Current Health: " + panel.player.currentHealth;
        drawFloat(x, y, text, 3);
        y+= panel.tileSize;
        text = "Speed: " + panel.player.currentSpeed;
        drawFloat(x,y,text, 3);

        x = panel.tileSize * 3;
        y += panel.tileSize;
        text = "------------------------------------------";
        drawFloat(x,y, text, 3);

        y+= panel.tileSize;
        resetY = y;
        text = "Monsters Defeated: " + panel.player.monstersDefeated;
        drawFloat(x, y, text, 3);
        y+= panel.tileSize;
        text = "Gold Collected: " + panel.player.goldCollected;
        drawFloat(x, y, text, 3);
        y+= panel.tileSize;
        text = "Chests Opened: " + panel.player.chestsOpened;
        drawFloat(x, y, text, 3);
        y+= panel.tileSize;
        text = "# of Right Answers: " + panel.player.rightAnswers;
        drawFloat(x, y, text, 3);
        y+= panel.tileSize;
        text = "Most Correct in a Row: " + panel.player.maxRightAnswersInRow;
        drawFloat(x, y, text, 3);
        y+= panel.tileSize;
        text = "Best Category: " + panel.player.bestCategory;
        drawFloat(x, y, text, 3);


        y = resetY;
        x += panel.tileSize * 8;
        text = "Bosses Slain: " + panel.player.bossesSlain;
        drawFloat(x, y, text, 3);
        y+= panel.tileSize;
        text = "Potions Used: " + panel.player.potionsUsed;
        drawFloat(x, y, text, 3);


        graphics2D.setFont(joystix_small);
        y += panel.tileSize * 4.8;
        x = (int) (panel.tileSize * 2.2);
        text = "<";
        drawFloat(x, y, text, 3);
        x += panel.tileSize * 15;
        text = ">";
        drawFloat(x, y, text, 3);


    }
}
