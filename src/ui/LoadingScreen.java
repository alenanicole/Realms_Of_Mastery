package ui;

import main.GamePanel;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class LoadingScreen extends UI{

    Graphics2D graphics2D;
    GamePanel panel;
    public LoadingScreen(GamePanel panel, Graphics2D graphics2D) {
        super(panel);
        this.panel = panel;
        this.graphics2D = graphics2D;
    }


    public void draw(){
        graphics2D.setFont(joystix);
        graphics2D.setColor(background);
        graphics2D.fillRect(0, 0, panel.screenWidth, panel.screenHeight);

        graphics2D.getFont().deriveFont(Font.BOLD, 96F);
        String text = "LOADING";
        int x = getCenteredX(text, graphics2D);
        int y = panel.screenHeight - panel.tileSize;

        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);

        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 4, panel.tileSize, 5, 5));

        // Waiting for a minute to load
        long start = System.currentTimeMillis();
        long end = start + 60000;

        panel.gameState = panel.playState;
    }
}
