package ui;

import main.GamePanel;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class HelpScreen extends UI{

    Graphics2D graphics2D;
    GamePanel panel;

    public HelpScreen(GamePanel panel) {
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
        String text = "HELP";
        int x = getCenteredX(text, graphics2D);
        int y = panel.tileSize * 3;
        drawFloat(x, y, text, 5);

        graphics2D.setFont(press_start);
        x = panel.tileSize * 3;
        text = "Keybinds";
        y += panel.tileSize;
        drawFloat(x, y, text, 3);
        text = "------------------------------------";
        y += panel.tileSize;
        drawFloat(x, y, text, 3);
        text = "W, A, S, D - Move up, left, down, right";
        y += panel.tileSize;
        drawFloat(x, y, text, 3);
        text = "Enter - Select";
        y += panel.tileSize;
        drawFloat(x, y, text, 3);
        text = "Esc - Back";
        y += panel.tileSize;
        drawFloat(x, y, text, 3);
        text = "P - Pause";
        y += panel.tileSize;
        drawFloat(x, y, text, 3);
        text = "I - Inventory";
        y += panel.tileSize;
        drawFloat(x, y, text, 3);
        text = "H - Help";
        y += panel.tileSize;
        drawFloat(x, y, text, 3);
        text = "O - Achievements and Stats";
        y += panel.tileSize;
        drawFloat(x, y, text, 3);


        graphics2D.setFont(joystix);
        x += panel.tileSize * 10.5;
        y += panel.tileSize * .5;
        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize * 4, panel.tileSize + 10, 5, 5));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 4, panel.tileSize + 10, 5, 5));
        graphics2D.setColor(Color.white);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 4, panel.tileSize + 10, 5, 5));

        y += panel.tileSize;
        x += 15;
        text = "Back";
        drawFloat(x, y, text, 5);
    }
}
