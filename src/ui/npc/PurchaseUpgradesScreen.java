package ui.npc;

import main.GamePanel;
import ui.UI;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class PurchaseUpgradesScreen extends UI {
    Graphics2D graphics2D;
    GamePanel panel;
    boolean cannotPurchase = false;
    public PurchaseUpgradesScreen(GamePanel panel) {
        super(panel);
        this.panel = panel;
    }

    public void drawFloat(int x, int y, String text, int offset){
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + offset, y + offset);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);
    }

    public void draw(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
        int x = panel.screenWidth / 2 - panel.tileSize * 4;
        int y = panel.screenHeight / 2 - panel.tileSize * 2;
        int resetY = y;
        String text = "";

        graphics2D.setFont(press_start);
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize * 7, panel.tileSize * 5, 30, 30));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 7, panel.tileSize * 5, 30, 30));

        switch (panel.ui.getUpgradeNum()){
            case 0:
                if(panel.upgrades[0].canPurchase && panel.items[0].numHeld >= panel.upgrades[0].price){
                    text = "Would you like to\npurchase health?\n(" + panel.upgrades[0].numAvailable + " left)";
                    cannotPurchase = false;
                }else if (!panel.upgrades[0].canPurchase){
                    text = "Fully upgraded!";
                    cannotPurchase = true;
                }else {
                    text = "You don't have\nenough gold!";
                    cannotPurchase = true;
                }
                break;
            case 1:
                if(panel.upgrades[1].canPurchase && panel.items[0].numHeld >= panel.upgrades[1].price){
                    text = "Would you like to\npurchase strength?\n(" + panel.upgrades[1].numAvailable + " left)";
                    cannotPurchase = false;
                }else if (!panel.upgrades[1].canPurchase){
                    text = "Fully upgraded!";
                    cannotPurchase = true;
                }else {
                    text = "You don't have\nenough gold!";
                    cannotPurchase = true;
                }
                break;
            case 2:
                if(panel.upgrades[2].canPurchase && panel.items[0].numHeld >= panel.upgrades[2].price){
                    text = "Would you like to\npurchase speed?\n(" + panel.upgrades[2].numAvailable + " left)";
                    cannotPurchase = false;
                }else if (!panel.upgrades[2].canPurchase){
                    text = "Fully upgraded!";
                    cannotPurchase = true;
                }else {
                    text = "You don't have\nenough gold!";
                    cannotPurchase = true;
                }
                break;
        }

        y += panel.tileSize;
        x += 10;

        for (String line : text.split("\n")) {
            drawFloat(x, y, line, 3);
            y += panel.tileSize;
        }

        if(cannotPurchase){ graphics2D.setComposite(composite);}

        y = (int) (resetY + panel.tileSize * 3.5);
        x += panel.tileSize/2 - 10;

        if (panel.ui.getUseNum() == 0) {
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, (float) (panel.tileSize * 3), panel.tileSize, 5, 5));
        }

        y += panel.tileSize * .6;

        int textX = x + 10;
        text = "Purchase";
        drawFloat(textX, y, text, 3);

        graphics2D.setComposite(originalComposite);
        y -= panel.tileSize * .6;
        x += panel.tileSize * 4;
        if (panel.ui.getUseNum() == 1) {
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, (float) (panel.tileSize * 1.8), panel.tileSize, 5, 5));
        }

        y += panel.tileSize * .6;
        textX = x + 10;
        text = "Back";
        drawFloat(textX, y, text, 3);
    }
}
