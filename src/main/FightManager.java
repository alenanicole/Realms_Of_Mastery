package main;

public class FightManager {
    GamePanel panel;
    ScalingManager scalingManager = new ScalingManager();
    int idx;
    int numCoins;

    public FightManager(GamePanel panel)
    {
        this.panel = panel;
    }

    public void startFight(int idx){
        panel.inEncounter = true;
        panel.gameState = panel.fightState;
        panel.ui.setMonsterIdx(idx);
        this.idx = idx;
    }

    public void endFight(boolean correct){
        panel.inEncounter = false;
        panel.numOfFight--;
        if(idx == 0){
            if(correct){
                panel.player.bossesSlain++;
            }
            panel.gameState = panel.winState;
            panel.reset();
            return;
        }
        if(correct) {
            numCoins = panel.randGen.getRandomInteger(10, 5);
            panel.items[0].numHeld += numCoins;
            panel.player.goldCollected += numCoins;
            int rand = panel.randGen.getRandomInteger(100, 1);
            if(rand >= 1 && rand <= 10){
                panel.items[1].numHeld++;
            }

            panel.monster[idx].dead = true;
            panel.gameState = panel.keyHandler.previousState;
            panel.player.monstersDefeated++;
        }else{
            panel.gameState = panel.deathState;
            panel.reset();
        }
    }

    public void validateAns(){
        boolean correct = panel.questionManager.checkAns();
        addQuestionTotal(correct);
        if(correct) {
            panel.player.rightAnswers++;
            panel.player.rightAnswersInRow++;
            if(panel.player.maxRightAnswersInRow < panel.player.rightAnswersInRow){
                panel.player.maxRightAnswersInRow = panel.player.rightAnswersInRow;
            }
            if(panel.ui.getDifficultyNum() == 0) {
                panel.monster[idx].currentHealth -= panel.player.tierOneDamage;
            }else if(panel.ui.getDifficultyNum() == 1){
                panel.monster[idx].currentHealth -= panel.player.tierTwoDamage;
            }else{
                panel.monster[idx].currentHealth -= panel.player.tierThreeDamage;
            }
            if(panel.monster[idx].currentHealth <= 0){
                endFight(correct);
            }
        }else{
            panel.player.rightAnswersInRow = 0;
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
