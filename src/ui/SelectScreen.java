package ui;

import main.GamePanel;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class SelectScreen extends UI{
    Graphics2D graphics2D;
    GamePanel panel;
    public SelectScreen(GamePanel panel) {
        super(panel);
        this.panel = panel;
    }

    public void draw(Graphics2D graphics2D){
        this.graphics2D = graphics2D;
        
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setColor(background);
        graphics2D.fillRect(0, 0, panel.screenWidth, panel.screenHeight);

        graphics2D.getFont().deriveFont(Font.BOLD);
        String text = "Choose your character!";
        int x = getCenteredX(text, graphics2D);
        int y = panel.tileSize;
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);

        panel.player.getPlayerImage();
        x = panel.tileSize * 2;
        y += panel.tileSize * 4;
        graphics2D.fill(new RoundRectangle2D.Float(x - panel.tileSize, y - panel.tileSize, panel.tileSize * 7, panel.tileSize * 7, 10, 10));

        panel.ui.setSpriteCounter(panel.ui.getSpriteCounter() + 1);
        if(panel.ui.getSpriteCounter() > 15){
            if(panel.ui.getSpriteNum() == 1){
                panel.ui.setSpriteNum(2);
            }else if(panel.ui.getSpriteNum() == 2){
                panel.ui.setSpriteNum(1);
            }
            panel.ui.setSpriteCounter(0);
        }

        if(panel.ui.getSpriteNum() == 1) {
            graphics2D.drawImage(panel.player.down1, x, y, panel.tileSize * 5, panel.tileSize * 5, null);
        }else if(panel.ui.getSpriteNum() == 2){
            graphics2D.drawImage(panel.player.down2, x, y, panel.tileSize * 5, panel.tileSize * 5, null);
        }

        int resetX = x + panel.tileSize * 7;

        y += panel.tileSize * 7;
        graphics2D.setColor(panel.ui.getSelectedHair());
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        graphics2D.setColor(Color.black);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        x += panel.tileSize * 2;
        graphics2D.setColor(panel.ui.getSelectedSkin());
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        graphics2D.setColor(Color.black);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        x += panel.tileSize * 2;
        graphics2D.setColor(panel.ui.getSelectedShirt());
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        graphics2D.setColor(Color.black);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));


        x = resetX + panel.tileSize * 2;
        y = (int) (panel.tileSize * 2.5);
        text = "Boy";
        graphics2D.getFont().deriveFont(Font.PLAIN, 10F);
        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x - 10, y - panel.tileSize + 8, 135, 48, 5, 5));
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);
        if(panel.ui.getSelectNum() == 0){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x - 10, y - panel.tileSize + 8, 135, 48, 5, 5));
        }

        x += panel.tileSize * 4;
        text = "Girl";
        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x - 10, y - panel.tileSize + 8, 175, 48, 5, 5));
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);
        if(panel.ui.getSelectNum() == 1){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x - 10, y - panel.tileSize + 8, 175, 48, 5, 5));
        }

        x = resetX;
        y += panel.tileSize * 1.5;
        text = "Hair";
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);

        x += panel.tileSize;
        y += panel.tileSize / 2;
        graphics2D.setColor(blonde);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        if(panel.ui.getSelectNum() == 2){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        x += panel.tileSize * 2;
        graphics2D.setColor(brownHair);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        if(panel.ui.getSelectNum() == 3){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        x += panel.tileSize * 2;
        graphics2D.setColor(black);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        if(panel.ui.getSelectNum() == 4){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        x += panel.tileSize * 2;
//        graphics2D.setColor(button);
//        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        graphics2D.drawImage(questionMark, x, y, null);
        if(panel.ui.getSelectNum() == 5){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }


        x += panel.tileSize * 2;
        if(!panel.outfits[0].available) {
            graphics2D.drawImage(questionMark, x, y, null);
        }else{
            graphics2D.drawImage(hat, x, y, null);
        }
        if(panel.outfits[0].equipped){
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }
        if(panel.ui.getSelectNum() == 6){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }



        x = resetX;
        y += panel.tileSize * 2;
        text = "Skin";
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.getFont().deriveFont(Font.PLAIN, 16F);
        graphics2D.drawString(text, x, y);

        x += panel.tileSize;
        y += panel.tileSize / 2;
        graphics2D.setColor(lightest);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        if(panel.ui.getSelectNum() == 7){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        x += panel.tileSize * 2;
        graphics2D.setColor(light);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        if(panel.ui.getSelectNum() == 8){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        x += panel.tileSize * 2;
        graphics2D.setColor(medium);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        if(panel.ui.getSelectNum() == 9){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        x += panel.tileSize * 2;
        graphics2D.setColor(dark);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        if(panel.ui.getSelectNum() == 10){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        x += panel.tileSize * 2;
        graphics2D.setColor(darkest);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        if(panel.ui.getSelectNum() == 11){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        x = resetX;
        y += panel.tileSize * 2;
        text = "Shirt";
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.getFont().deriveFont(Font.PLAIN, 16F);
        graphics2D.drawString(text, x, y);

        x += panel.tileSize;
        y += panel.tileSize / 2;
        graphics2D.setColor(blue);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        if(panel.ui.getSelectNum() == 12){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        x += panel.tileSize * 2;
        graphics2D.setColor(brownShirt);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        if(panel.ui.getSelectNum() == 13){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        x += panel.tileSize * 2;
        graphics2D.setColor(gray);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        if(panel.ui.getSelectNum() == 14){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        x += panel.tileSize * 2;
        graphics2D.setColor(green);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        if(panel.ui.getSelectNum() == 15){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        x += panel.tileSize * 2;
        graphics2D.setColor(orange);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        if(panel.ui.getSelectNum() == 16){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        x = resetX + panel.tileSize;
        y += panel.tileSize * 1.5;
        graphics2D.setColor(pink);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        if(panel.ui.getSelectNum() == 17){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        x += panel.tileSize * 2;
        graphics2D.setColor(purple);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        if(panel.ui.getSelectNum() == 18){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        x += panel.tileSize * 2;
        graphics2D.setColor(red);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        if(panel.ui.getSelectNum() == 19){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        x += panel.tileSize * 2;
        graphics2D.setColor(teal);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        if(panel.ui.getSelectNum() == 20){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        x += panel.tileSize * 2;
        graphics2D.setColor(white);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        if(panel.ui.getSelectNum() == 21){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        x = resetX + panel.tileSize;
        y += panel.tileSize * 1.5;
        graphics2D.setColor(yellow);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        if(panel.ui.getSelectNum() == 22){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        x += panel.tileSize * 2;
        graphics2D.setColor(new Color(255, 255, 255));
//        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        graphics2D.drawImage(questionMark, x, y, null);
        if(panel.ui.getSelectNum() == 23){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        x += panel.tileSize * 2;
        graphics2D.setColor(new Color(255, 255, 255));
//        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        graphics2D.drawImage(questionMark, x, y, null);
        if(panel.ui.getSelectNum() == 24){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }
        x += panel.tileSize * 2;
        graphics2D.setColor(new Color(255, 255, 255));
//        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        graphics2D.drawImage(questionMark, x, y, null);
        if(panel.ui.getSelectNum() == 25){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }
        x += panel.tileSize * 2;
        graphics2D.setColor(new Color(255, 255, 255));
//        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        graphics2D.drawImage(questionMark, x, y, null);
        if(panel.ui.getSelectNum() == 26){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize, 5, 5));
        }

        y += panel.tileSize * 2.5;
        x = (int) (resetX + panel.tileSize * 1.5);
        text = "Back";
        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x - 10, y - panel.tileSize + 8, 175, 48, 5, 5));
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);
        if(panel.ui.getSelectNum() == 27){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x - 10, y - panel.tileSize + 8, 175, 48, 5, 5));
        }

        x += panel.tileSize * 4.5;
        text = "OK!";
        int textX = (int)( x + panel.tileSize * .8);
        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x - 10, y - panel.tileSize + 8, 210, 48, 5, 5));
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, textX + 5, y + 5);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, textX, y);
        if(panel.ui.getSelectNum() == 28){
            graphics2D.setColor(Color.black);
            graphics2D.draw(new RoundRectangle2D.Float(x - 10, y - panel.tileSize + 8, 210, 48, 5, 5));
        }

    }
}
