package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BossRushManager {
    GamePanel panel;
    private String numQuestions = "15";
    private int numAttempts = 0;
    private int numCorrect = 0;
    private int numIncorrect = 0;
    int numCoins = 0;
    private String category = "multiplication";

    public BossRushManager(GamePanel panel)
    {
        this.panel = panel;
    }

    public void startBossRush(String _category){
        panel.gameState = panel.bossRushState;
        setCategory(_category);
    }

    public void endBossRush(){
        setNumAttempts(0);

        numCoins = numCorrect * 2;
        panel.items[0].numHeld += numCoins;
        panel.player.goldCollected += numCoins;
        panel.gameState = panel.endBossRushState;
    }

    public void validateAns(){
        setNumAttempts(getNumAttempts() + 1);
        boolean correct = panel.questionManager.checkAns();
        if(correct) {
            numCorrect++;
        }else{
            panel.gameState = panel.wrongAnswerState;
            numIncorrect++;
        }
        if(getNumAttempts() == Integer.parseInt(getNumQuestions())){
            endBossRush();
        }

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNumQuestions() {
        return numQuestions;
    }

    public void setNumQuestions(String numQuestions) {
        this.numQuestions = numQuestions;
    }

    public int getNumAttempts() {
        return numAttempts;
    }

    public void setNumAttempts(int numAttempts) {
        this.numAttempts = numAttempts;
    }

    public int getNumCorrect() {
        return numCorrect;
    }

    public void setNumCorrect(int numCorrect) {
        this.numCorrect = numCorrect;
    }

    public int getNumIncorrect() {
        return numIncorrect;
    }

    public void setNumIncorrect(int numIncorrect) {
        this.numIncorrect = numIncorrect;
    }
}
