package main;

import javax.imageio.ImageIO;
import java.io.IOException;

public class TreasureManager {
    GamePanel panel;
    ScalingManager scalingManager = new ScalingManager();
    int idx;

    public TreasureManager(GamePanel panel)
    {
        this.panel = panel;
    }

    public void startTreasureCollection(int idx){
        panel.inEncounter = true;
        panel.gameState = panel.treasureState;
        this.idx = idx;
    }

    public void endTreasureCollection(boolean correct){
        panel.inEncounter = false;
        panel.questionManager.setNumOfAttempts(0);
        if(correct) {
            try {
                panel.obj[idx].image = ImageIO.read(getClass().getResourceAsStream("/objects/open_chest.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            try {
                panel.obj[idx].image = ImageIO.read(getClass().getResourceAsStream("/objects/locked_chest.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        panel.obj[idx].image = scalingManager.toCompatibleImage(panel.obj[idx].image, panel.tileSize, panel.tileSize);
        panel.obj[idx].opened = true;
        panel.obj[idx].collision = true;
        panel.gameState = panel.playState;
    }

    public void validateAns(){
       boolean correct = panel.questionManager.checkAns();
        if(correct) {
            if (panel.ui.getDifficultyNum() == 0) {
                panel.items[0].numHeld += panel.randGen.getRandomInteger(5, 1);
            }else if(panel.ui.getDifficultyNum() == 1) {
                panel.items[0].numHeld += panel.randGen.getRandomInteger(10, 5);
            }else{
                panel.items[0].numHeld += panel.randGen.getRandomInteger(15, 5);
                panel.items[panel.randGen.getRandomInteger(5, 2)].numHeld++;
            }
            endTreasureCollection(correct);
        }else{
            panel.questionManager.setNumOfAttempts(panel.questionManager.getNumOfAttempts() + 1);
            if(panel.questionManager.getNumOfAttempts() == 3){
                endTreasureCollection(correct);
            }
        }

    }
}
