package main;

import javax.imageio.ImageIO;
import java.io.IOException;

public class FightManager {
    GamePanel panel;
    ScalingManager scalingManager = new ScalingManager();
    int idx;

    public FightManager(GamePanel panel)
    {
        this.panel = panel;
    }

    public void startFight(int idx){
        panel.inEncounter = true;
        panel.gameState = panel.fightState;
        this.idx = idx;
    }

    public void endFight(boolean correct){
        panel.inEncounter = false;
        if(idx == 0){
            panel.gameState = panel.tutorialState;
//            panel.gameState = panel.winState;
            panel.reset();
            return;
        }
        if(correct) {
            panel.items[0].numHeld += panel.randGen.getRandomInteger(5, 1);
            int rand = panel.randGen.getRandomInteger(100, 1);
            if(rand >= 1 && rand <= 10){
                panel.items[1].numHeld++;
            }
            panel.monster[idx].dead = true;
            panel.gameState = panel.playState;
            return;
        }else{
            panel.gameState = panel.deathState;
            panel.reset();
        }
    }

    public void validateAns(){
        boolean correct = panel.questionManager.checkAns();
        if(correct) {
            if(panel.ui.getDifficultyNum() == 1) {
                panel.monster[idx].currentHealth -= panel.player.tierOneDamage;
            }else if(panel.ui.getDifficultyNum() == 2){
                panel.monster[idx].currentHealth -= panel.player.tierTwoDamage;
            }else{
                panel.monster[idx].currentHealth -= panel.player.tierThreeDamage;
            }
            if(panel.monster[idx].currentHealth <= 0){
                endFight(correct);
            }
        }else{
            if(panel.ui.getDifficultyNum() == 0) {
                panel.player.currentHealth -= 1;
            }else if(panel.ui.getDifficultyNum() == 1){
                panel.player.currentHealth -= 2;
            }else{
                panel.player.currentHealth -= 3;
            }

            if(panel.player.currentHealth <= 0){
                endFight(correct);
            }
        }

    }
}
