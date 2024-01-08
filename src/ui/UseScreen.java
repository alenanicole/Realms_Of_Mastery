package ui;

import main.GamePanel;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class UseScreen extends UI{
    Graphics2D graphics2D;
    GamePanel panel;
    boolean cannotUse = false;
    public UseScreen(GamePanel panel) {
        super(panel);
        this.panel = panel;
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

        if(panel.ui.getInventoryNum() == 0){
            text = "Find a shop to use\nthis item";
            cannotUse = true;
        }

        if(panel.ui.getInventoryNum() == 1){
            text = "Find a door to use\nthis item";
            cannotUse = true;
        }

        if (panel.ui.getInventoryNum() >= 2 && panel.ui.getInventoryNum() <= 5) {
            if (!panel.inEncounter && panel.items[panel.ui.getInventoryNum()].encounterOnly) {
                text = "This item can't be\nused outside of an\nencounter";
                cannotUse = true;
            } else if (panel.inEncounter && panel.items[panel.ui.getInventoryNum()].adventureOnly) {
                text = "This item can't be\nused in an\nencounter";
                cannotUse = true;
            } else if(panel.items[panel.ui.getInventoryNum()].numHeld <= 0 ) {
                text = "Get more of this\nitem to use it";
                cannotUse = true;
            }else{
                text = "Would you like to\nuse this item?";
                cannotUse = false;
            }
        }

        if(panel.ui.getInventoryNum() > 5){
            if(panel.weapons[panel.ui.getInventoryNum() - 6].available){
                text = "Would you like to\nequip this weapon?";
                cannotUse = false;
            } else{
                text = "Visit the Weapon\nMaster to get this\nweapon";
                cannotUse = true;
            }
        }

        y += panel.tileSize;
        x += 10;

        for (String line : text.split("\n")) {
            graphics2D.setColor(Color.black);
            graphics2D.drawString(line, x + 5, y + 5);
            graphics2D.setColor(Color.white);
            graphics2D.drawString(line, x, y);
            y += panel.tileSize;
        }

        y = (int) (resetY + panel.tileSize * 3.5);
        x += panel.tileSize/2 - 10;

        if(cannotUse){ graphics2D.setComposite(composite);}

        if (panel.ui.getUseNum() == 0) {
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, (float) (panel.tileSize * 1.5), panel.tileSize, 5, 5));
        }

        y += panel.tileSize * .6;

        int textX = x + 10;
        text = "Use";
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, textX + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, textX, y);

        y -= panel.tileSize * .6;
        x += panel.tileSize * 4;
        graphics2D.setComposite(originalComposite);

        if (panel.ui.getUseNum() == 1) {
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, (float) (panel.tileSize * 1.8), panel.tileSize, 5, 5));
        }

        y += panel.tileSize * .6;
        textX = x + 10;
        text = "Back";
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, textX + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, textX, y);
    }
}
