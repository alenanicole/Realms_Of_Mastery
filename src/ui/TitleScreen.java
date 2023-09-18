package ui;

import main.GamePanel;

import java.awt.*;

public class TitleScreen extends UI{

    Graphics2D graphics2D;
    GamePanel panel;
    public TitleScreen(GamePanel panel) {
        super(panel);
        this.panel = panel;
    }


    public void draw(Graphics2D graphics2D){
        this.graphics2D = graphics2D;
        graphics2D.setFont(joystix);
        graphics2D.setColor(background);
        graphics2D.fillRect(0, 0, panel.screenWidth, panel.screenHeight);

        graphics2D.getFont().deriveFont(Font.BOLD, 96F);
        String text = "REALMS OF MASTERY";
        int x = super.getCenteredX(text, graphics2D);
        int y = panel.tileSize * 5;

        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);

        graphics2D.setColor(Color.white);

        graphics2D.drawString(text, x, y);

        graphics2D.getFont().deriveFont(Font.BOLD, 48F);
        text = "NEW GAME";
        x = super.getCenteredX(text, graphics2D);
        y = panel.tileSize * 11;
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);
        if(panel.ui.getTitleCommandNum() == 0){
            graphics2D.setColor(Color.black);
            graphics2D.drawString(">", x - panel.tileSize + 5, y + 5);
            graphics2D.setColor(Color.white);
            graphics2D.drawString(">", x - panel.tileSize, y);
        }

        text = "LOAD GAME";
        x = super.getCenteredX(text, graphics2D);
        y += panel.tileSize;
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);
        if(panel.ui.getTitleCommandNum() == 1){
            graphics2D.setColor(Color.black);
            graphics2D.drawString(">", x - panel.tileSize + 5, y + 5);
            graphics2D.setColor(Color.white);
            graphics2D.drawString(">", x - panel.tileSize, y);
        }

        text = "QUIT";
        x = super.getCenteredX(text, graphics2D);
        y += panel.tileSize;
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);
        if(panel.ui.getTitleCommandNum() == 2){
            graphics2D.setColor(Color.black);
            graphics2D.drawString(">", x - panel.tileSize + 5, y + 5);
            graphics2D.setColor(Color.white);
            graphics2D.drawString(">", x - panel.tileSize, y);
        }
    }
}
