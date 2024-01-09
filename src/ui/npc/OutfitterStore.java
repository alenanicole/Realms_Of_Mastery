package ui.npc;

import main.GamePanel;
import ui.UI;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class OutfitterStore extends UI{
    GamePanel panel;
    Graphics2D graphics2D;

    public OutfitterStore(GamePanel panel) {
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
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setColor(background);
        graphics2D.fill(new RoundRectangle2D.Float(panel.tileSize * 2, panel.tileSize * 2, panel.screenWidth - panel.tileSize * 4, panel.screenHeight - panel.tileSize * 4, 30, 30));

        graphics2D.getFont().deriveFont(Font.BOLD);
        String text = "Outfitter's Store";
        int x = getCenteredX(text, graphics2D);
        int y = panel.tileSize * 3;
        drawFloat(x, y, text, 5);

        graphics2D.setFont(press_start_small);
        text = "Hello, I'm the Outfitter! Take a look at what I sell!";
        x = getCenteredX(text, graphics2D);
        y += panel.tileSize/2;
        drawFloat(x, y, text, 3);

        graphics2D.setFont(joystix);

        x = (int)(panel.tileSize * 4.5);
        y += panel.tileSize;
        int resetY = y;

        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize * 2 + 10, panel.tileSize * 2 + 10, 5, 5));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 2 + 10 , panel.tileSize * 2 + 10, 5, 5));
        graphics2D.drawImage(panel.outfits[0].image, x + 5, y + 5, panel.tileSize * 2, panel.tileSize * 2, null);
        if(panel.ui.getOutfitterNum() == 0){
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 2 + 10 , panel.tileSize * 2 + 10, 5, 5));
        }

        if(!panel.outfits[0].available){
            y += panel.tileSize * 3;
            graphics2D.drawImage(panel.items[0].image, x, y + 5, panel.tileSize, panel.tileSize, null);
            x += panel.tileSize;
            y += panel.tileSize;
            text = String.valueOf(panel.outfits[0].price);
            drawFloat(x, y, text, 5);

            y = resetY;
            x += panel.tileSize * 3;
        }else{
            x += panel.tileSize * 4;
        }


        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize * 2 + 10, panel.tileSize * 2 + 10, 5, 5));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 2 + 10 , panel.tileSize * 2 + 10, 5, 5));
        graphics2D.drawImage(panel.outfits[1].image, x + 5, y + 5, panel.tileSize * 2, panel.tileSize * 2, null);
        if(panel.ui.getOutfitterNum() == 1){
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 2 + 10 , panel.tileSize * 2 + 10, 5, 5));
        }

        if(!panel.outfits[1].available) {
            y += panel.tileSize * 3;
            graphics2D.drawImage(panel.items[0].image, x, y + 5, panel.tileSize, panel.tileSize, null);
            x += panel.tileSize;
            y += panel.tileSize;
            text = String.valueOf(panel.outfits[1].price);
            drawFloat(x, y, text, 5);

            y = resetY;
            x += panel.tileSize * 3;
        }else{
            x += panel.tileSize * 4;
        }

        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize * 2 + 10, panel.tileSize * 2 + 10, 5, 5));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 2 + 10 , panel.tileSize * 2 + 10, 5, 5));
        graphics2D.drawImage(panel.outfits[2].image, x + 5, y + 5, panel.tileSize * 2, panel.tileSize * 2, null);
        if(panel.ui.getOutfitterNum() == 2){
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 2 + 10 , panel.tileSize * 2 + 10, 5, 5));
        }

        y += panel.tileSize * 3;
        if(!panel.outfits[2].available) {
            graphics2D.drawImage(panel.items[0].image, x, y + 5, panel.tileSize, panel.tileSize, null);
            x += panel.tileSize;
            y += panel.tileSize;
            text = String.valueOf(panel.outfits[2].price);
            drawFloat(x, y, text, 5);
            x -= panel.tileSize;
        }

        y += panel.tileSize;
        x = (int) (panel.tileSize * 4.5);
        resetY = y;

        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize * 2 + 10, panel.tileSize * 2 + 10, 5, 5));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 2 + 10 , panel.tileSize * 2 + 10, 5, 5));
        graphics2D.drawImage(panel.outfits[3].image, x + 5, y + 5, panel.tileSize * 2, panel.tileSize * 2, null);
        if(panel.ui.getOutfitterNum() == 3){
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 2 + 10 , panel.tileSize * 2 + 10, 5, 5));
        }

        if(!panel.outfits[3].available){
            y += panel.tileSize * 3;
            graphics2D.drawImage(panel.items[0].image, x, y + 5, panel.tileSize, panel.tileSize, null);
            x += panel.tileSize;
            y += panel.tileSize;
            text = String.valueOf(panel.outfits[3].price);
            drawFloat(x, y, text, 5);

            y = resetY;
            x += panel.tileSize * 3;
        }else{
            x += panel.tileSize * 4;
        }

        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize * 2 + 10, panel.tileSize * 2 + 10, 5, 5));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 2 + 10 , panel.tileSize * 2 + 10, 5, 5));
        graphics2D.drawImage(panel.outfits[4].image, x + 5, y + 5, panel.tileSize * 2, panel.tileSize * 2, null);
        if(panel.ui.getOutfitterNum() == 4){
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 2 + 10 , panel.tileSize * 2 + 10, 5, 5));
        }

        if(!panel.outfits[4].available){
            y += panel.tileSize * 3;
            graphics2D.drawImage(panel.items[0].image, x, y + 5, panel.tileSize, panel.tileSize, null);
            x += panel.tileSize;
            y += panel.tileSize;
            text = String.valueOf(panel.outfits[4].price);
            drawFloat(x, y, text, 5);

            y = resetY;
            x -= panel.tileSize;
        }


        y += panel.tileSize * .5;
        x += panel.tileSize * 3.5;

        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, (int)(panel.tileSize * 5.5), panel.tileSize + 10, 5, 5));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, (int)(panel.tileSize * 5.5), panel.tileSize + 10, 5, 5));

        if(panel.ui.getOutfitterNum() == 5){
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, (int)(panel.tileSize * 5.5), panel.tileSize + 10, 5, 5));
        }

        y += panel.tileSize;
        x += 15;
        text = "Closet";
        drawFloat(x, y, text, 5);
        x -= 15;


        y += panel.tileSize;
        x += panel.tileSize * 1.5;
        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize * 4, panel.tileSize + 10, 5, 5));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 4, panel.tileSize + 10, 5, 5));

        if(panel.ui.getOutfitterNum() == 6){
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 4, panel.tileSize + 10, 5, 5));
        }

        y += panel.tileSize;
        x += 15;
        text = "Back";
        drawFloat(x, y, text, 5);


    }
}
