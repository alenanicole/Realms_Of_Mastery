package ui.npc;

import main.GamePanel;
import ui.UI;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class BossRushStartScreen extends UI {

    Graphics2D graphics2D;
    GamePanel panel;

    public BossRushStartScreen(GamePanel panel) {
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
        String text = "BOSS RUSH";
        int x = getCenteredX(text, graphics2D);
        int y = panel.tileSize * 3;
        drawFloat(x, y, text, 5);

        graphics2D.setFont(press_start_small);
        text = "How Many Questions?";
        x = super.getCenteredX(text, graphics2D) - panel.tileSize;
        y += panel.tileSize;
        drawFloat(x, y, text, 3);
        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x + panel.tileSize * 5, (int)(y - panel.tileSize * .4), panel.tileSize, panel.tileSize/2, 5, 5));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x + panel.tileSize * 5, (int)(y - panel.tileSize * .4), panel.tileSize, panel.tileSize/2, 5, 5));
        if(panel.ui.getBossRushNum() == 6) {
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x + panel.tileSize * 5, (int)(y - panel.tileSize * .4), panel.tileSize, panel.tileSize/2, 5, 5));
        }

        x += (panel.tileSize * 5)+ 5;
        drawFloat(x, y, String.valueOf(panel.bossRushManager.getNumQuestions()), 3);


        graphics2D.setFont(joystix_small);
        text = "MULTIPLICATION";
        x = super.getCenteredX(text, graphics2D);
        y += panel.tileSize * 1.5;
        drawFloat(x, y, text, 5);
        if(panel.ui.getBossRushNum() == 0){
            drawFloat(x - panel.tileSize, y, ">", 5);
        }

        text = "DIVISION";
        x = super.getCenteredX(text, graphics2D);
        y += panel.tileSize * 1.5;
        drawFloat(x, y, text, 5);
        if(panel.ui.getBossRushNum() == 1){
            drawFloat(x - panel.tileSize, y, ">", 5);
        }

        text = "FRACTIONS";
        x = super.getCenteredX(text, graphics2D);
        y += panel.tileSize * 1.5;
        drawFloat(x, y, text, 5);
        if(panel.ui.getBossRushNum() == 2){
            drawFloat(x - panel.tileSize, y, ">", 5);
        }

        text = "WORD PROBLEMS";
        x = super.getCenteredX(text, graphics2D);
        y += panel.tileSize * 1.5;
        drawFloat(x, y, text, 5);
        if(panel.ui.getBossRushNum() == 3){
            drawFloat(x - panel.tileSize, y, ">", 5);
        }

        text = "CUSTOM (coming soon)";
        graphics2D.setComposite(composite);
        x = super.getCenteredX(text, graphics2D);
        y += panel.tileSize * 1.5;
        drawFloat(x, y, text, 5);
        graphics2D.setComposite(originalComposite);
        if(panel.ui.getBossRushNum() == 4){
            drawFloat(x - panel.tileSize, y, ">", 5);
        }

        graphics2D.setFont(joystix);
        x = panel.tileSize * 13;
        y += panel.tileSize * 1;
        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize * 4, panel.tileSize + 10, 5, 5));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 4, panel.tileSize + 10, 5, 5));
        if(panel.ui.getBossRushNum() == 5) {
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 4, panel.tileSize + 10, 5, 5));
        }

        y += panel.tileSize;
        x += 15;
        text = "Back";
        drawFloat(x, y, text, 5);

    }
}