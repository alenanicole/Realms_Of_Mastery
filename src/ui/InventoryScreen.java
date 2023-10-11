package ui;

import main.GamePanel;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class InventoryScreen extends UI{
    GamePanel panel;
    Graphics2D graphics2D;
    public InventoryScreen(GamePanel panel) {
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
        String text = "Inventory";
        int x = getCenteredX(text, graphics2D);
        int y = panel.tileSize * 3;
        int resetY = y;
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);

        text = "Welcome to the inventory! Hover over a item to get more info!";
        graphics2D.setFont(press_start_small);
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, getCenteredX(text, graphics2D) + 2, y + panel.tileSize/2 + 2);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, getCenteredX(text, graphics2D), y + panel.tileSize/2);
        graphics2D.setFont(joystix);

        x = panel.tileSize * 3;
        y += panel.tileSize;

        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize + 10, panel.tileSize + 10, 5, 5));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize + 10 , panel.tileSize + 10, 5, 5));
        graphics2D.drawImage(panel.items[0].image, x + 5, y + 5, panel.tileSize, panel.tileSize, null);
        if(panel.ui.getInventoryNum() == 0){
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize + 10 , panel.tileSize + 10, 5, 5));
        }


        x += panel.tileSize * 2;
        y += panel.tileSize;
        text = String.valueOf(panel.items[0].numHeld);
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);

        x += panel.tileSize * 3;
        y -= panel.tileSize;

        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize + 10, panel.tileSize + 10, 5, 5));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize + 10 , panel.tileSize + 10, 5, 5));
        graphics2D.drawImage(panel.items[1].image, x + 5, y + 5, panel.tileSize, panel.tileSize, null);
        if(panel.ui.getInventoryNum() == 1){
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize + 10 , panel.tileSize + 10, 5, 5));
        }


        x += panel.tileSize * 2;
        y += panel.tileSize;
        text = String.valueOf(panel.items[1].numHeld);
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);


        graphics2D.setFont(press_start);

        x -= panel.tileSize * 7;
        y += panel.tileSize * 2;

        for(int i = 2; i <= 5; i++) {
            if(panel.items[i] != null) {
                graphics2D.setComposite(originalComposite);
                graphics2D.setColor(button);
                graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize + 10, panel.tileSize + 10, 5, 5));
                graphics2D.setColor(border);
                graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize + 10, panel.tileSize + 10, 5, 5));

                if(panel.ui.getInventoryNum() == i){
                    graphics2D.setColor(Color.white);
                    graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize + 10, panel.tileSize + 10, 5, 5));
                }

                if(panel.items[i].numHeld == 0){
                    graphics2D.setComposite(composite);
                }

                graphics2D.drawImage(panel.items[i].image, x + 5, y + 5, null);
                int textX = x + panel.tileSize / 2;
                int textY = y + panel.tileSize;
                text = "x" + String.valueOf(panel.items[i].numHeld);
                graphics2D.setColor(Color.black);
                graphics2D.drawString(text, textX + 3, textY + 3);
                graphics2D.setColor(Color.white);
                graphics2D.drawString(text, textX, textY);

                x += panel.tileSize * 2;


            }
        }

        y += panel.tileSize * 2;
        x -= panel.tileSize * 8 - 5;
        graphics2D.setComposite(originalComposite);
        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize * 7, panel.tileSize * 4, 10, 10));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 7, panel.tileSize * 4, 10, 10));


        graphics2D.setColor(Color.white);
        graphics2D.setFont(press_start_small);

        switch (panel.ui.getInventoryNum()){
            case 0:
                text = "Visit some shops\nto spend your gold!";
                break;
            case 1:
                text = "Ooo shiny";
                break;
            case 2:
                text = "HEALTH POTION:\nUse anytime.\nHeal for 1 heart!";
                break;
            case 3:
                text = "STRENGTH POTION:\nUse anytime.\nIncrease strength for\n3 fights!";
                break;
            case 4:
                text = "SPEED POTION:\nCan't be used in an\nencounter.\nGet around faster!";
                break;
            case 5:
                text = "REROLL POTION:\nOnly used in a encounter.\nNext question please!";
                break;
            case 6:
                if(panel.weapons[0].available) {
                    text = "SWORD:\nEQUIPPED > " + (panel.weapons[0].equipped ? "yes" : "no") + "\nHit `em hard!";
                }else{
                    text = "???:\nEQUIPPED > " + (panel.weapons[0].equipped ? "yes" : "no") + "\n???????";
                }
                break;
            case 7:
                if(panel.weapons[1].available) {
                    text = "STAFF:\nEQUIPPED > " + (panel.weapons[1].equipped ? "yes" : "no") + "\n`Yer a wizard!";
                }else{
                    text = "???:\nEQUIPPED > " + (panel.weapons[1].equipped ? "yes" : "no") + "\n???????";
                }
                break;
            case 8:
                if(panel.weapons[2].available) {
                    text = "BOW:\nEQUIPPED > " + (panel.weapons[2].equipped ? "yes" : "no") + "\nShoot straight!";
                }else{
                    text = "???:\nEQUIPPED > " + (panel.weapons[2].equipped ? "yes" : "no") + "\n???????";
                }
                break;
            case 9:
                text = "Leaving so soon?";
        }
        y += panel.tileSize/2;

        for(String line : text.split("\n")){
            graphics2D.drawString(line, x + 10, y);
            y += panel.tileSize;
        }

        graphics2D.setFont(joystix);

        y = resetY + panel.tileSize * 2;
        x += panel.tileSize * 10;

        graphics2D.setColor(Color.white);
        graphics2D.fill(new RoundRectangle2D.Float(x - panel.tileSize, y - panel.tileSize, panel.tileSize * 5, panel.tileSize * 5, 10, 10));
        graphics2D.drawImage(frame,x-panel.tileSize, y-panel.tileSize, panel.tileSize *5, panel.tileSize*5, null);

        for(int i = 0; i < panel.weapons.length; i++){
            if(panel.weapons[i].equipped){
                graphics2D.drawImage(panel.weapons[i].image, x, y, panel.tileSize * 3, panel.tileSize * 3, null);
            }
        }

        y += panel.tileSize * 5;
        x -= panel.tileSize + 5;

        for(int i = 0; i < panel.weapons.length; i++) {
            if(panel.items[i] != null) {
                graphics2D.setComposite(originalComposite);
                graphics2D.setColor(button);
                graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize + 10, panel.tileSize + 10, 5, 5));
                graphics2D.setColor(border);
                graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize + 10, panel.tileSize + 10, 5, 5));

                if(panel.ui.getInventoryNum() == i + 6){
                    graphics2D.setColor(Color.white);
                    graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize + 10, panel.tileSize + 10, 5, 5));
                }

                if(!panel.weapons[i].equipped && panel.weapons[i].available){
                    graphics2D.setComposite(composite);
                    graphics2D.drawImage(panel.weapons[i].image, x + 5, y + 5, null);
                }else if(!panel.weapons[i].available){
                    graphics2D.setComposite(composite);
                    graphics2D.drawImage(questionMark, x + 5, y + 5, null);
                }else{
                    graphics2D.drawImage(panel.weapons[i].image, x + 5, y + 5, null);
                }


                x += panel.tileSize * 2;
            }
        }

        x -= panel.tileSize * 4.8;
        y += panel.tileSize * 2.5;

        graphics2D.setComposite(originalComposite);
        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize * 4, panel.tileSize + 10, 5, 5));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 4, panel.tileSize + 10, 5, 5));

        if(panel.ui.getInventoryNum() == 9){
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 4, panel.tileSize + 10, 5, 5));
        }

        y += panel.tileSize;
        x += 15;
        text = "Back";
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);

    }

}
