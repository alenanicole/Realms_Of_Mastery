package ui;

import main.GamePanel;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class TutorialScreen extends UI{

    Graphics2D graphics2D;
    GamePanel panel;

    public TutorialScreen(GamePanel panel) {
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
        graphics2D.fill(new RoundRectangle2D.Float(panel.tileSize * 2, panel.tileSize * 2, panel.screenWidth - panel.tileSize * 4, panel.screenHeight - panel.tileSize * 4, 30, 30));

        graphics2D.getFont().deriveFont(Font.BOLD);
        String text = "TUTORIAL";
        int x = getCenteredX(text, graphics2D);
        int y = panel.tileSize * 3;
        drawFloat(x, y, text, 5);

        graphics2D.setFont(joystix_smallest);
        text = "Welcome to Realms of Mastery!";
        x = getCenteredX(text, graphics2D);
        y += panel.tileSize;
        drawFloat(x, y, text, 3);

        y += panel.tileSize;
        graphics2D.setFont(press_start);
        x = (int)(panel.tileSize * 2.5);
        text = "Here you will run through dungeons, find\ntreasure, fight monsters, and slay bosses!" +
                "\n\nBe sure to visit the shops to buy supplies,\nupgrades, and unlockables!" +
                "\nYou have enough gold for a sword, go to\nthe Weapon Master to buy one" +
                " and then equip it\nin your inventory (I)!\n\n" +
                "Head to the golden portal room to start a run!\n" +
                "Or head to the red portal room to start a\nboss rush!";


        for(String line : text.split("\n")){
            y += panel.tileSize * .7;
            drawFloat(x, y, line, 3);

        }

        graphics2D.setFont(joystix_small);
        x += panel.tileSize * 14;
        y -= panel.tileSize * .7;
        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize + 10, 5, 5));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize + 10, 5, 5));
        graphics2D.setColor(Color.white);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize , panel.tileSize + 10, 5, 5));

        y += panel.tileSize * .9;
        x += 10;
        text = ">";
        drawFloat(x, y, text, 3);
    }
}
