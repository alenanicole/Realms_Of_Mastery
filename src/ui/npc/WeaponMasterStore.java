package ui.npc;

import main.GamePanel;
import ui.*;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class WeaponMasterStore extends UI{
    GamePanel panel;
    Graphics2D graphics2D;

    public WeaponMasterStore(GamePanel panel) {
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
        String text = "Weapons Store";
        int x = getCenteredX(text, graphics2D);
        int y = panel.tileSize * 3;
        drawFloat(x, y, text, 5);

        graphics2D.setFont(press_start_small);
        text = "Hello, I'm the Weapons Master! Take a look at what I sell!";
        x = getCenteredX(text, graphics2D);
        y += panel.tileSize/2;
        drawFloat(x, y, text, 3);

        graphics2D.setFont(joystix);

        x = (int) (panel.tileSize * 3.5);
        y += panel.tileSize * 2;
        int resetY = y;

        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize * 3 + 10, panel.tileSize * 3 + 10, 5, 5));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 3 + 10 , panel.tileSize * 3 + 10, 5, 5));
        graphics2D.drawImage(panel.weapons[0].image, x + 5, y + 5, panel.tileSize * 3, panel.tileSize * 3, null);
        if(panel.ui.getWeaponNum() == 0){
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 3 + 10 , panel.tileSize * 3 + 10, 5, 5));
        }

        if(!panel.weapons[0].available){
            y += panel.tileSize * 4;
            graphics2D.drawImage(panel.items[0].image, x, y + 5, panel.tileSize, panel.tileSize, null);
            x += panel.tileSize;
            y += panel.tileSize;
            text = String.valueOf(panel.weapons[0].price);
            drawFloat(x, y, text, 5);

            y = resetY;
            x += panel.tileSize * 4;
        }else{
            x += panel.tileSize * 5;
        }


        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize * 3 + 10, panel.tileSize * 3 + 10, 5, 5));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 3 + 10 , panel.tileSize * 3 + 10, 5, 5));
        graphics2D.drawImage(panel.weapons[1].image, x + 5, y + 5, panel.tileSize * 3, panel.tileSize * 3, null);
        if(panel.ui.getWeaponNum() == 1){
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 3 + 10 , panel.tileSize * 3 + 10, 5, 5));
        }

        if(!panel.weapons[1].available) {
            y += panel.tileSize * 4;
            graphics2D.drawImage(panel.items[0].image, x, y + 5, panel.tileSize, panel.tileSize, null);
            x += panel.tileSize;
            y += panel.tileSize;
            text = String.valueOf(panel.weapons[1].price);
            drawFloat(x, y, text, 5);

            y = resetY;
            x += panel.tileSize * 4;
        }else{
            x += panel.tileSize * 5;
        }

        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize * 3 + 10, panel.tileSize * 3 + 10, 5, 5));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 3 + 10 , panel.tileSize * 3 + 10, 5, 5));
        graphics2D.drawImage(panel.weapons[2].image, x + 5, y + 5, panel.tileSize * 3, panel.tileSize * 3, null);
        if(panel.ui.getWeaponNum() == 2){
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 3 + 10 , panel.tileSize * 3 + 10, 5, 5));
        }

        y += panel.tileSize * 4;
        if(!panel.weapons[2].available) {
            graphics2D.drawImage(panel.items[0].image, x, y + 5, panel.tileSize, panel.tileSize, null);
            x += panel.tileSize;
            y += panel.tileSize;
            text = String.valueOf(panel.weapons[2].price);
            drawFloat(x, y, text, 5);
            x -= panel.tileSize;
        }

        y += panel.tileSize;
        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize * 4, panel.tileSize + 10, 5, 5));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 4, panel.tileSize + 10, 5, 5));

        if(panel.ui.getWeaponNum() == 3){
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize * 4, panel.tileSize + 10, 5, 5));
        }

        y += panel.tileSize;
        x += 15;
        text = "Back";
        drawFloat(x, y, text, 5);


    }
}
