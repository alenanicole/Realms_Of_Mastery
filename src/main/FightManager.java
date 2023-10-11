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
        if(idx == 0){
            if(correct){
                panel.player.bossesSlain++;
            }
            panel.gameState = panel.tutorialState;
//            panel.gameState = panel.winState;
            panel.reset();
            return;
        }
        if(correct) {
            if(panel.ui.getDifficultyNum() == 0) {
                numCoins = panel.randGen.getRandomInteger(5, 1);
                panel.items[0].numHeld += numCoins;
                panel.player.goldCollected += numCoins;
            }else if(panel.ui.getDifficultyNum() == 1){
                numCoins = panel.randGen.getRandomInteger(10, 1);
                panel.items[0].numHeld += numCoins;
                panel.player.goldCollected += numCoins;
            }else{
                numCoins = panel.randGen.getRandomInteger(15, 5);
                panel.items[0].numHeld += numCoins;
                panel.player.goldCollected += numCoins;
                int rand = panel.randGen.getRandomInteger(100, 1);
                if(rand >= 1 && rand <= 10){
                    panel.items[1].numHeld++;
                }
            }

            panel.monster[idx].dead = true;
            panel.gameState = panel.playState;
            panel.player.monstersDefeated++;
        }else{
            panel.gameState = panel.deathState;
            panel.reset();
        }
    }

    public void validateAns(){
        boolean correct = panel.questionManager.checkAns();
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
}
