package ui;

import main.GamePanel;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

public class AchievementScreen extends UI{
    Graphics2D graphics2D;
    GamePanel panel;
    BufferedImage image;
    boolean achieved = false;

    public AchievementScreen(GamePanel panel) {
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
        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(panel.screenWidth - panel.tileSize * 6, (int)(panel.tileSize * 1.4), panel.tileSize * 2, panel.tileSize, 10, 10));
        graphics2D.setColor(background);
        graphics2D.fill(new RoundRectangle2D.Float(panel.screenWidth - panel.tileSize * 4, (int)(panel.tileSize * 1.4), panel.tileSize * 2, panel.tileSize, 10, 10));
        graphics2D.setColor(background);
        graphics2D.fill(new RoundRectangle2D.Float(panel.tileSize * 2, panel.tileSize * 2, panel.screenWidth - panel.tileSize * 4, panel.screenHeight - panel.tileSize * 4, 30, 30));

        String text = "ACHIEVEMENTS";
        int x = getCenteredX(text, graphics2D);
        int y = panel.tileSize * 3;
        drawFloat(x, y, text, 5);

        x = panel.tileSize * 3;
        y += panel.tileSize;
        graphics2D.setFont(press_start);
        text = "------------------------------------------";
        drawFloat(x,y, text, 3);
        y += panel.tileSize * .5;
        text = "Monsters Defeated";
        x = getCenteredX(text, graphics2D);
        drawFloat(x,y, text, 3);

        x = panel.tileSize * 5;
        y += panel.tileSize * .5;

        for(int i = 0; i < 4; i++){
            switch (i) {
                case 0 -> {
                    image = whiteTrophy;
                    achieved = panel.player.monstersDefeated >= 5;
                    if(achieved){
                        text = "5/5";
                    }else{
                        text = panel.player.monstersDefeated + "/5";
                    }
                }
                case 1 -> {
                    image = bronzeTrophy;
                    achieved = panel.player.monstersDefeated >= 10;
                    if(achieved){
                        text = "10/10";
                    }else{
                        text = panel.player.monstersDefeated + "/10";
                    }
                }
                case 2 -> {
                    image = silverTrophy;
                    achieved = panel.player.monstersDefeated >= 25;
                    if(achieved){
                        text = "25/25";
                    }else{
                        text = panel.player.monstersDefeated + "/25";
                    }
                }
                case 3 -> {
                    image = goldTrophy;
                    achieved = panel.player.monstersDefeated >= 50;
                    if(achieved){
                        text = "50/50";
                    }else{
                        text = panel.player.monstersDefeated + "/50";
                    }
                }
            }

            if(!achieved){
                graphics2D.setComposite(composite);
            }else{
                graphics2D.setComposite(originalComposite);
            }

            graphics2D.drawImage(image, x, y, null);

            graphics2D.setComposite(originalComposite);
            y += panel.tileSize * 1.5;
            drawFloat(x,y, text, 3);

            x += panel.tileSize * 3;
            y -= panel.tileSize * 1.5;
        }

        y += panel.tileSize * 2;
        x = panel.tileSize * 3;
        text = "------------------------------------------";
        drawFloat(x,y, text, 3);
        y += panel.tileSize * .5;
        text = "Chests Opened";
        x = getCenteredX(text, graphics2D);
        drawFloat(x,y, text, 3);

        x = panel.tileSize * 5;
        y += panel.tileSize * .5;

        for(int i = 0; i < 4; i++){
            switch (i) {
                case 0 -> {
                    image = whiteTrophy;
                    achieved = panel.player.chestsOpened >= 1;
                    if(achieved){
                        text = "1/1";
                    }else{
                        text = panel.player.chestsOpened + "/1";
                    }
                }
                case 1 -> {
                    image = bronzeTrophy;
                    achieved = panel.player.chestsOpened >= 5;
                    if(achieved){
                        text = "5/5";
                    }else{
                        text = panel.player.chestsOpened + "/5";
                    }
                }
                case 2 -> {
                    image = silverTrophy;
                    achieved = panel.player.chestsOpened >= 10;
                    if(achieved){
                        text = "10/10";
                    }else{
                        text = panel.player.chestsOpened + "/10";
                    }
                }
                case 3 -> {
                    image = goldTrophy;
                    achieved = panel.player.chestsOpened >= 25;
                    if(achieved){
                        text = "25/25";
                    }else{
                        text = panel.player.chestsOpened + "/25";
                    }
                }
            }

            if(!achieved){
                graphics2D.setComposite(composite);
            }else{
                graphics2D.setComposite(originalComposite);
            }

            graphics2D.drawImage(image, x, y, null);

            graphics2D.setComposite(originalComposite);
            y += panel.tileSize * 1.5;
            drawFloat(x,y, text, 3);

            x += panel.tileSize * 3;
            y -= panel.tileSize * 1.5;
        }
        
        x = panel.tileSize * 3;
        y += panel.tileSize * 2;
        text = "------------------------------------------";
        drawFloat(x,y, text, 3);
        y += panel.tileSize * .5;
        text = "# of Right Answers";
        x = getCenteredX(text, graphics2D);
        drawFloat(x,y, text, 3);

        x = panel.tileSize * 5;
        y += panel.tileSize * .5;

        for(int i = 0; i < 4; i++){
            switch (i) {
                case 0 -> {
                    image = whiteTrophy;
                    achieved = panel.player.rightAnswers >= 10;
                    if(achieved){
                        text = "10/10";
                    }else{
                        text = panel.player.rightAnswers + "/10";
                    }
                }
                case 1 -> {
                    image = bronzeTrophy;
                    achieved = panel.player.rightAnswers >= 25;
                    if(achieved){
                        text = "25/25";
                    }else{
                        text = panel.player.rightAnswers + "/25";
                    }
                }
                case 2 -> {
                    image = silverTrophy;
                    achieved = panel.player.rightAnswers >= 50;
                    if(achieved){
                        text = "50/50";
                    }else{
                        text = panel.player.rightAnswers + "/50";
                    }
                }
                case 3 -> {
                    image = goldTrophy;
                    achieved = panel.player.rightAnswers >= 100;
                    if(achieved){
                        text = "100/100";
                    }else{
                        text = panel.player.rightAnswers + "/100";
                    }
                }
            }

            if(!achieved){
                graphics2D.setComposite(composite);
            }else{
                graphics2D.setComposite(originalComposite);
            }

            graphics2D.drawImage(image, x, y, null);

            graphics2D.setComposite(originalComposite);
            y += panel.tileSize * 1.5;
            drawFloat(x,y, text, 3);

            x += panel.tileSize * 3;
            y -= panel.tileSize * 1.5;
        }
        x = panel.tileSize * 3;
        y += panel.tileSize * 2;
        text = "------------------------------------------";
        drawFloat(x,y, text, 3);

        graphics2D.setFont(joystix_small);
        y += panel.tileSize * .8;
        x = (int) (panel.tileSize * 2.2);
        text = "<";
        drawFloat(x, y, text, 3);
        x += panel.tileSize * 15;
        text = ">";
        drawFloat(x, y, text, 3);
    }
}
