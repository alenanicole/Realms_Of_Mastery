package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SuperTreasureManager {
    GamePanel panel;
    ScalingManager scalingManager = new ScalingManager();
    int idx;

    BufferedImage openChest;

    public SuperTreasureManager(GamePanel panel)
    {
        this.panel = panel;
        try {
            openChest = ImageIO.read(getClass().getResourceAsStream("/tutorial_objects/super_chest/open_chest_super.png"));
            openChest = scalingManager.toCompatibleImage(openChest, panel.tileSize, panel.tileSize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void startTreasureCollection(int idx){
        panel.inEncounter = true;
        panel.gameState = panel.superTreasureState;
        this.idx = idx;
    }

    public void endTreasureCollection(boolean correct){
        panel.inEncounter = false;
        panel.questionManager.setNumOfAttempts(0);
        if(correct) {
            panel.player.chestsOpened++;
            panel.obj[idx].image = openChest;
            panel.items[0].numHeld += panel.obj[idx].value;
            panel.obj[idx].opened = true;
            panel.obj[idx].collision = true;
        }
        panel.gameState = panel.centralMapState;
    }

    public void validateAns(){
       boolean correct = panel.questionManager.checkAns();
        addQuestionTotal(correct);
        if(correct) {
            panel.player.rightAnswers++;
            panel.player.rightAnswersInRow++;
            panel.questionManager.setNumOfAttempts(panel.questionManager.getNumOfAttempts() + 1);
            if(panel.questionManager.getNumOfAttempts() == 5){
                endTreasureCollection(true);
            }
        }else{
            panel.gameState = panel.wrongAnswerState;
            panel.player.rightAnswersInRow = 0;
//            endTreasureCollection(false);
        }

    }

    public void addQuestionTotal(boolean correct) {
        switch (panel.questionManager.currentCategory){
            case "multiplication":
                panel.player.totalMultiplicationQuestions++;
                if(correct){
                    panel.player.rightMultiplicationQuestions++;
                }
                panel.questionManager.percentCorrect[0] = (float)(panel.player.rightMultiplicationQuestions) / (float)(panel.player.totalMultiplicationQuestions);
            case "division":
                panel.player.totalDivisionQuestions++;
                if(correct){
                    panel.player.rightDivisionQuestions++;
                }
                panel.questionManager.percentCorrect[1] = (float)(panel.player.rightDivisionQuestions) / (float)(panel.player.totalDivisionQuestions);
            case "fraction":
                panel.player.totalFractionQuestions++;
                if(correct){
                    panel.player.rightFractionQuestions++;
                }
                panel.questionManager.percentCorrect[2] = (float)(panel.player.rightFractionQuestions) / (float)(panel.player.totalFractionQuestions);
            case "wordproblem":
                panel.player.totalWordProblemQuestions++;
                if(correct){
                    panel.player.rightWordProblemQuestions++;
                }
                panel.questionManager.percentCorrect[3] = (float)(panel.player.rightWordProblemQuestions) / (float)(panel.player.totalWordProblemQuestions);
        }
        float max = panel.questionManager.percentCorrect[0];
        int maxIdx = 0;
        int maxRightProblems = 0;

        for (int i = 1; i < panel.questionManager.percentCorrect.length; i++) {
            if(panel.questionManager.percentCorrect[i] > max){
                switch(i){
                    case 0:
                        if(panel.player.rightMultiplicationQuestions > maxRightProblems){
                            max = panel.questionManager.percentCorrect[i];
                            maxIdx = i;
                            maxRightProblems = panel.player.rightMultiplicationQuestions;
                        }
                        break;
                    case 1:
                        if(panel.player.rightDivisionQuestions > maxRightProblems){
                            max = panel.questionManager.percentCorrect[i];
                            maxIdx = i;
                            maxRightProblems = panel.player.rightDivisionQuestions;
                        }
                        break;
                    case 2:
                        if(panel.player.rightFractionQuestions > maxRightProblems){
                            max = panel.questionManager.percentCorrect[i];
                            maxIdx = i;
                            maxRightProblems = panel.player.rightFractionQuestions;
                        }
                        break;
                    case 3:
                        if(panel.player.rightWordProblemQuestions > maxRightProblems){
                            max = panel.questionManager.percentCorrect[i];
                            maxIdx = i;
                            maxRightProblems = panel.player.rightWordProblemQuestions;
                        }
                        break;
                }

            }
        }
        panel.player.bestCategory = panel.questionManager.questionTypes[maxIdx];

    }
}
