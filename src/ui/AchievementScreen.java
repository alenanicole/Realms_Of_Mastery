package ui;

import main.GamePanel;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class AchievementScreen extends UI{
    Graphics2D graphics2D;
    GamePanel panel;

    public AchievementScreen(GamePanel panel) {
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
        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(panel.screenWidth - panel.tileSize * 6, (int)(panel.tileSize * 1.4), panel.tileSize * 2, panel.tileSize, 10, 10));
        graphics2D.setColor(background);
        graphics2D.fill(new RoundRectangle2D.Float(panel.screenWidth - panel.tileSize * 4, (int)(panel.tileSize * 1.4), panel.tileSize * 2, panel.tileSize, 10, 10));
        graphics2D.setColor(background);
        graphics2D.fill(new RoundRectangle2D.Float(panel.tileSize * 2, panel.tileSize * 2, panel.screenWidth - panel.tileSize * 4, panel.screenHeight - panel.tileSize * 4, 30, 30));

        String text = "ACHIEVEMENTS";
        int x = getCenteredX(text, graphics2D);
        int y = panel.tileSize * 3;
        drawFloat(x, y, text, 5);

        graphics2D.setFont(press_start);
        y += panel.tileSize;
        x = panel.tileSize * 3;
        text = "------------------------------------------";
        drawFloat(x,y, text, 3);


        y += panel.tileSize;
        text = "------------------------------------------";
        drawFloat(x,y, text, 3);

        y += panel.tileSize;
        text = "------------------------------------------";
        drawFloat(x,y, text, 3);
    }
}
