package ui;

import main.GamePanel;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class DeathScreen extends UI{
    GamePanel panel;
    Graphics2D graphics2D;
    public DeathScreen(GamePanel panel) {
        super(panel);
        this.panel = panel;

    }

    public void draw(Graphics2D graphics2D){
        this.graphics2D = graphics2D;
        int x = (int) (panel.screenWidth / 2 - panel.tileSize * 3.5);
        int y = panel.screenHeight / 2 - panel.tileSize * 2;
        int resetY = y;
        String text = "";

        graphics2D.setFont(joystix_small);
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize * 7, panel.tileSize * 5, 30, 30));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 7, panel.tileSize * 5, 30, 30));

        text = "Try Again!";
        x = super.getCenteredX(text, graphics2D);
        y += panel.tileSize;

        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);

        text = "Continue";
        y += panel.tileSize * 3;
        x = super.getCenteredX(text, graphics2D);
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);

        graphics2D.setColor(Color.white);
        graphics2D.draw(new RoundRectangle2D.Float((int)(x - panel.tileSize * .2) , (int)(y - panel.tileSize * .8), (int)(panel.tileSize * 5.5), panel.tileSize, 10, 10));

    }
}
