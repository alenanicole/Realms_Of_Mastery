package ui;

import main.GamePanel;
import main.ScalingManager;
import weapon.Weapon;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

public class FightScreen extends UI{
    Graphics2D graphics2D;
    GamePanel panel;
    BufferedImage tier1, tier2, tier3;
    int difficulty;
    Weapon equipped;


    ScalingManager scalingManager = new ScalingManager();
    public FightScreen(GamePanel panel) {
        super(panel);
        this.panel = panel;

        if(panel.weapons[0].equipped){
            equipped = panel.weapons[0];
        }else if(panel.weapons[1].equipped){
            equipped = panel.weapons[1];
        }else{
            equipped = panel.weapons[2];
        }

        tier1 = equipped.tier1;
        tier2 = equipped.tier2;
        tier3 = equipped.tier3;

    }

    public void draw(int idx){
        int y = panel.screenHeight - panel.tileSize * 2;
        int x = panel.screenWidth - panel.tileSize * 2;
        boolean lastHeart = false;


        for(int i = 1; i <= panel.monster[idx].maxHealth/2; i++) {
            if(panel.monster[idx].currentHealth == 0){
                lastHeart = true;
            }
            if(panel.monster[idx].currentHealth >= i * 2){
                graphics2D.drawImage(monstFullHeart, x, y, null);
                if(panel.monster[idx].currentHealth == i * 2){
                    lastHeart = true;
                }
            }else if(panel.monster[idx].currentHealth < i * 2 && !lastHeart){
                graphics2D.drawImage(monstHalfHeart, x, y, null);
                lastHeart = true;
            }else{
                graphics2D.drawImage(emptyHeart, x, y, null);
            }

            x -= panel.tileSize;
        }
    }

    public void drawDifficultySelection(Graphics2D graphics2D){
        this.graphics2D = graphics2D;
        draw(panel.ui.getMonsterIdx());

        graphics2D.setFont(joystix_small);
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setColor(background);
        graphics2D.fill(new RoundRectangle2D.Float((int)(panel.tileSize * 1.5), panel.tileSize * 2,
                (int)(panel.screenWidth - panel.tileSize * 3), panel.screenHeight - panel.tileSize * 4,
                30, 30));

        String text = "BATTLE!";
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
        draw(panel.ui.getMonsterIdx());
        graphics2D.setFont(joystix_smallest);
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setColor(background);
        graphics2D.fill(new RoundRectangle2D.Float((int)(panel.tileSize * 1.5), panel.tileSize * 2,
                (int)(panel.screenWidth - panel.tileSize * 3), panel.screenHeight - panel.tileSize * 4,
                30, 30));

        int x = panel.tileSize * 3;
        int y = panel.tileSize * 3;

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
