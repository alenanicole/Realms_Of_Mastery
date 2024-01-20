package ui;

import main.GamePanel;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class SaveScreen extends UI{
    GamePanel panel;
    Graphics2D graphics2D;
    public SaveScreen(GamePanel panel) {
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
        int x = (int) (panel.screenWidth / 2 - panel.tileSize * 4);
        int y = panel.screenHeight / 2 - panel.tileSize * 2;
        int resetY = y;
        String text = "";

        graphics2D.setFont(joystix_smallest);
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize * 8, panel.tileSize * 6, 30, 30));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 8, panel.tileSize * 6, 30, 30));

        if(panel.keyHandler.previousState != panel.tutorialState){
            text = "Can't save\nright now!";
        }else if(panel.saveAndLoad.isSuccessful()) {
            text = "Save\nSuccessful!";
        }else{
            text = "Unsuccessful\nSave";
        }

        y += panel.tileSize;


        for (String line : text.split("\n")) {
            x = getCenteredX(line, graphics2D);
            drawFloat(x, y, line, 3);
            y += panel.tileSize;
        }

        text = "Continue";
        y += panel.tileSize * 2;
        x = getCenteredX(text, graphics2D);
        drawFloat(x, y, text, 3);

        graphics2D.setColor(Color.white);
        graphics2D.draw(new RoundRectangle2D.Float((int)(x - panel.tileSize * .2) , (int)(y - panel.tileSize * .8), (int)(panel.tileSize * 4.5), panel.tileSize, 10, 10));

    }
}
