package ui;

import main.GamePanel;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class PauseScreen extends UI {

    Graphics2D graphics2D;
    GamePanel panel;

    public PauseScreen(GamePanel panel) {
        super(panel);
        this.panel = panel;
    }

    public void draw(Graphics2D graphics2D){
        this.graphics2D = graphics2D;
        graphics2D.setFont(joystix);
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.setColor(background);
        graphics2D.fill(new RoundRectangle2D.Float(panel.tileSize * 2, panel.tileSize * 2, panel.screenWidth - panel.tileSize * 4, panel.screenHeight - panel.tileSize * 4, 30, 30));

        graphics2D.getFont().deriveFont(Font.BOLD);
        String text = "PAUSED";
        int x = getCenteredX(text, graphics2D);
        int y = panel.tileSize * 3;
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);

        text = "RESUME";
        x = super.getCenteredX(text, graphics2D);
        y += panel.tileSize * 4;
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);
        if(panel.ui.getPauseCommandNum() == 0){
            graphics2D.setColor(Color.black);
            graphics2D.drawString(">", x - panel.tileSize + 5, y + 5);
            graphics2D.setColor(Color.white);
            graphics2D.drawString(">", x - panel.tileSize, y);
        }

        text = "SAVE GAME";
        x = super.getCenteredX(text, graphics2D);
        y += panel.tileSize * 1.5;
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);
        if(panel.ui.getPauseCommandNum() == 1){
            graphics2D.setColor(Color.black);
            graphics2D.drawString(">", x - panel.tileSize + 5, y + 5);
            graphics2D.setColor(Color.white);
            graphics2D.drawString(">", x - panel.tileSize, y);
        }

        text = "QUIT TO TITLE";
        x = super.getCenteredX(text, graphics2D);
        y += panel.tileSize * 1.5;
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);
        if(panel.ui.getPauseCommandNum() == 2){
            graphics2D.setColor(Color.black);
            graphics2D.drawString(">", x - panel.tileSize + 5, y + 5);
            graphics2D.setColor(Color.white);
            graphics2D.drawString(">", x - panel.tileSize, y);
        }

        text = "QUIT TO DESKTOP";
        x = super.getCenteredX(text, graphics2D);
        y += panel.tileSize * 1.5;
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);
        if(panel.ui.getPauseCommandNum() == 3){
            graphics2D.setColor(Color.black);
            graphics2D.drawString(">", x - panel.tileSize + 5, y + 5);
            graphics2D.setColor(Color.white);
            graphics2D.drawString(">", x - panel.tileSize, y);
        }

    }
}