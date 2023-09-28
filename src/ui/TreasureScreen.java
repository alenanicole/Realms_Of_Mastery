package ui;

import main.GamePanel;
import main.ScalingManager;
import questions.math.Multiplication;
import questions.math.WordProblem;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TreasureScreen extends UI{
    Graphics2D graphics2D;
    GamePanel panel;
    BufferedImage tier1, tier2, tier3;
    BufferedImage grayX, redX;
    int difficulty;
    ScalingManager scalingManager = new ScalingManager();

    public TreasureScreen(GamePanel panel) {
        super(panel);
        this.panel = panel;
        try {
            tier1 = ImageIO.read(getClass().getResourceAsStream("/popups/key_one.png"));
            tier1 = scalingManager.toCompatibleImage(tier1, panel.tileSize * 2, panel.tileSize * 2);
            tier2 = ImageIO.read(getClass().getResourceAsStream("/popups/key_two.png"));
            tier2 = scalingManager.toCompatibleImage(tier2, panel.tileSize * 2, panel.tileSize * 2);
            tier3 = ImageIO.read(getClass().getResourceAsStream("/popups/key_three.png"));
            tier3 = scalingManager.toCompatibleImage(tier3, panel.tileSize * 2, panel.tileSize * 2);
            grayX = ImageIO.read(getClass().getResourceAsStream("/popups/gray_x.png"));
            grayX = scalingManager.toCompatibleImage(grayX, panel.tileSize, panel.tileSize);
            redX = ImageIO.read(getClass().getResourceAsStream("/popups/red_x.png"));
            redX = scalingManager.toCompatibleImage(redX, panel.tileSize, panel.tileSize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void drawDifficultySelection(Graphics2D graphics2D){
        this.graphics2D = graphics2D;

        graphics2D.setFont(joystix_small);
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setColor(background);
        graphics2D.fill(new RoundRectangle2D.Float((int)(panel.tileSize * 1.5), panel.tileSize * 2,
                (int)(panel.screenWidth - panel.tileSize * 3), panel.screenHeight - panel.tileSize * 4,
                30, 30));

        String text = "You've found treasure!";
        int x = getCenteredX(text, graphics2D);
        int y = panel.tileSize * 3;
        drawFloat(x, y, text, 5);

        text = "Choose your difficulty:";
        y += panel.tileSize * 2;
        x = getCenteredX(text, graphics2D);
        drawFloat(x, y, text, 5);

        x = panel.screenWidth/2 - panel.tileSize * 6;
        y += panel.tileSize * 2;
        int resetX = x;

        graphics2D.drawImage(tier1, x, y, null);
        if(panel.ui.getDifficultyNum() == 0){
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x - 5, y -5, panel.tileSize * 2 + 10, panel.tileSize * 2 + 10, 5, 5));
        }

        x += panel.tileSize * 5;
        graphics2D.drawImage(tier2, x, y, null);
        if(panel.ui.getDifficultyNum() == 1){
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x - 5, y -5, panel.tileSize * 2 + 10, panel.tileSize * 2 + 10, 5, 5));
        }

        x += panel.tileSize * 5;
        graphics2D.drawImage(tier3, x, y, null);
        if(panel.ui.getDifficultyNum() == 2){
            graphics2D.setColor(Color.white);
            graphics2D.draw(new RoundRectangle2D.Float(x -5, y - 5, panel.tileSize * 2 + 10, panel.tileSize * 2 + 10, 5, 5));
        }

        x = resetX - panel.tileSize + 10;

        y += panel.tileSize * 4;
        text = "TIER 1";
        drawFloat(x, y, text, 5);
        x += panel.tileSize * 5;
        text = "TIER 2";
        drawFloat(x, y, text, 5);
        x += panel.tileSize * 5;
        text = "TIER 3";
        drawFloat(x, y, text, 5);

    }

    public void drawFloat(int x, int y, String text, int offset){
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + offset, y + offset);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);
    }

    public void drawQuestion(){
//        if(panel.questionManager.getNumOfAttempts() > 2){
//            panel.gameState = panel.playState;
//            panel.questionManager.setNumOfAttempts(0);
//            panel.questionManager.setDifficultyChosen(false);
//            panel.player.answered = true;
//            panel.inEncounter = false;
//            return;
//        }
        graphics2D.setFont(joystix_smallest);
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setColor(background);
        graphics2D.fill(new RoundRectangle2D.Float((int)(panel.tileSize * 1.5), panel.tileSize * 2,
                (int)(panel.screenWidth - panel.tileSize * 3), panel.screenHeight - panel.tileSize * 4,
                30, 30));

        int x = panel.tileSize * 3;
        int y = panel.tileSize * 3;

        for(int i = 0; i < 3; i++){
            if(i >= panel.questionManager.getNumOfAttempts()) {
                graphics2D.setComposite(composite);
                graphics2D.drawImage(grayX, x, y, null);
            }else{
                graphics2D.setComposite(originalComposite);
                graphics2D.drawImage(redX, x, y, null);
            }
            x += panel.tileSize * 1.5;
        }

        graphics2D.setComposite(originalComposite);

        difficulty = panel.ui.getDifficultyNum();

        if(difficulty == 0) {
           panel.questionManager.drawTierOne();
        }else if(difficulty == 1){
            panel.questionManager.drawTierTwo();
        }else{
            panel.questionManager.drawTierThree();
        }

            String text = panel.questionManager.getQuestion();
            y = panel.tileSize * 5;
            for(String line : text.split("-")){
                x = super.getCenteredX(line, graphics2D);
                drawFloat(x, y, line, 3);
                y += panel.tileSize;
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
