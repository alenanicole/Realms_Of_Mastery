package ui;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BossRushScreen extends UI{
    Graphics2D graphics2D;
    GamePanel panel;
    String category ="";
    public BossRushScreen(GamePanel panel) {
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
        graphics2D.setFont(joystix_smallest);
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setColor(background);
        graphics2D.fill(new RoundRectangle2D.Float((int)(panel.tileSize * 1.5), panel.tileSize * 2,
                (int)(panel.screenWidth - panel.tileSize * 3), panel.screenHeight - panel.tileSize * 4,
                30, 30));

        int x = panel.tileSize * 3;
        int y = panel.tileSize * 3;

        String text = String.valueOf(panel.bossRushManager.getNumAttempts() + 1) + "/" + panel.bossRushManager.getNumQuestions();
        drawFloat(x, y, text, 3);

        x += panel.tileSize * 12;

        text = String.valueOf(panel.bossRushManager.getNumCorrect() );
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 3, y + 3);
        graphics2D.setColor(Color.green);
        graphics2D.drawString(text, x, y);

        x += panel.tileSize;
        text = String.valueOf(panel.bossRushManager.getNumIncorrect() );
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + 3, y + 3);
        graphics2D.setColor(Color.red);
        graphics2D.drawString(text, x, y);


        category = panel.bossRushManager.getCategory();

        int randSelector = panel.randGen.getRandomInteger(100, 1);
        if(randSelector > 0  && randSelector <= 34) {
           panel.questionManager.drawTierOne(category);
        }else if(randSelector > 34 && randSelector <= 67){
            panel.questionManager.drawTierTwo(category);
        }else{
            panel.questionManager.drawTierThree(category);
        }

        text = panel.questionManager.getQuestion();
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
                if(i > 0 && i % 27 == 0 || i == text.length() - 1) {
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
