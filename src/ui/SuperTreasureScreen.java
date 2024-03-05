package ui;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SuperTreasureScreen extends UI{
    Graphics2D graphics2D;
    GamePanel panel;
    BufferedImage grayCheck, greenCheck;

    int difficulty;
    ScalingManager scalingManager = new ScalingManager();

    public SuperTreasureScreen(GamePanel panel) {
        super(panel);
        this.panel = panel;
        try {
            grayCheck = ImageIO.read(getClass().getResourceAsStream("/popups/gray_check.png"));
            grayCheck = scalingManager.toCompatibleImage(grayCheck, panel.tileSize, panel.tileSize);
            greenCheck = ImageIO.read(getClass().getResourceAsStream("/popups/green_check.png"));
            greenCheck = scalingManager.toCompatibleImage(greenCheck, panel.tileSize, panel.tileSize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void drawFloat(int x, int y, String text, int offset){
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + offset, y + offset);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);
    }

    public void draw(Graphics2D graphics2D){
        this.graphics2D = graphics2D;
        graphics2D.setFont(joystix_smallest);
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setColor(background);
        graphics2D.fill(new RoundRectangle2D.Float((int)(panel.tileSize * 1.5), panel.tileSize * 2,
                (int)(panel.screenWidth - panel.tileSize * 3), panel.screenHeight - panel.tileSize * 4,
                30, 30));

        int x = panel.tileSize * 3;
        int y = panel.tileSize * 3;

        for(int i = 0; i < 5; i++){
            if(i >= panel.questionManager.getNumOfAttempts()) {
                graphics2D.setComposite(composite);
                graphics2D.drawImage(grayCheck, x, y, null);
            }else{
                graphics2D.setComposite(originalComposite);
                graphics2D.drawImage(greenCheck, x, y, null);
            }
            x += panel.tileSize * 1.5;
        }

        graphics2D.setComposite(originalComposite);


        panel.questionManager.drawTierThree();

        String text = panel.questionManager.getQuestion();
        y = panel.tileSize * 5;

        if(panel.questionManager.currentCategory.equals("wordproblem")){
            String line;
            int last_space = 0;
            int begin = 0;
            int current_char_num = 0;
            for(int i = 0; i < text.length(); i++){
                if (text.charAt(i) == ' '){
                    last_space = i;
                }
                if(i > 0 && i % 30 == 0 || i == text.length() - 1) {
                    if(last_space == i) {
                        line = text.substring(begin, current_char_num + 1);
                        begin = current_char_num + 1;
                    }else if(i == text.length() - 1){
                        line = text.substring(begin);
                    }else{
                        line = text.substring(begin, last_space);
                        begin = last_space + 1;
                    }
                    x = super.getCenteredX(line, graphics2D);
                    drawFloat(x, y, line, 3);
                    y += panel.tileSize;
                    current_char_num = begin - 1;
                }
                current_char_num++;
            }
        }else{
            for(String line : text.split("-")){
                x = super.getCenteredX(line, graphics2D);
                drawFloat(x, y, line, 3);
                y += panel.tileSize;
            }
        }

        x = panel.screenWidth/ 2 - panel.tileSize * 3;

        graphics2D.setComposite(composite);
        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y,
                panel.tileSize * 6, panel.tileSize,
                10, 10));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y,
                panel.tileSize * 6, panel.tileSize,
                10, 10));

        graphics2D.setComposite(originalComposite);

        x += 5;
        y += panel.tileSize;
        drawFloat(x, y - 5, panel.questionManager.getGivenAns(), 3);

    }

}
