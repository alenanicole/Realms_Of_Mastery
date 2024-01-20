package main;

import item.HealthPotion;
import item.RerollPotion;
import item.SpeedPotion;
import item.StrengthPotion;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    public int previousState;

    GamePanel panel;

    public KeyHandler(GamePanel panel){
        this.panel = panel;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
//        System.out.println(code);

        if(panel.gameState == panel.titleState) {
            titleStateKeyHandler(code);
        }else if(panel.gameState == panel.selectState){
            selectionStateKeyHandler(code);
        }else if(panel.gameState == panel.tutorialState){
            tutorialStateKeyHandler(code);
        }else if(panel.gameState == panel.playState){
            playStateKeyHandler(code);
        }else if(panel.gameState == panel.pauseState) {
            pauseStateKeyHandler(code);
        }else if(panel.gameState == panel.saveState){
            saveStateKeyHandler(code);
        }else if(panel.gameState == panel.inventoryState){
            inventoryStateKeyHandler(code);
        }else if(panel.gameState == panel.useState){
            useStateKeyHandler(code);
        }else if(panel.gameState == panel.treasureState){
            treasureStateKeyHandler(code);
        }else if(panel.gameState == panel.fightState) {
            fightStateKeyHandler(code);
        }else if(panel.gameState == panel.deathState){
            deathStateKeyHandler(code);
        }else if(panel.gameState == panel.statsState || panel.gameState == panel.achievementState){
            statsAndAchievementKeyHandler(code);
        }else if(panel.gameState == panel.weaponStoreState){
            weaponStoreStateKeyHandler(code);
        }else if(panel.gameState == panel.outfitterStoreState){
            outfitterStoreStateKeyHandler(code);
        }else if(panel.gameState == panel.doctorStoreState){
            doctorStoreStateKeyHandler(code);
        }else if(panel.gameState == panel.purchaseWeaponState || panel.gameState == panel.purchaseOutfitState || panel.gameState == panel.purchasePotionState){
            purchaseStateKeyHandler(code);
        }
    }



    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = false;
        }

        if(code == KeyEvent.VK_S){
            downPressed = false;
        }

        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }

        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
    }

    public void tutorialStateKeyHandler(int code) {
        if(code == KeyEvent.VK_W){
            upPressed = true;
        }

        if(code == KeyEvent.VK_S){
            downPressed = true;
        }

        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }

        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
        if(code == KeyEvent.VK_P){
            panel.gameState = panel.pauseState;
            previousState = panel.tutorialState;
        }

        if(code == KeyEvent.VK_I){
            panel.gameState = panel.inventoryState;
            previousState = panel.tutorialState;
        }

        if(code == KeyEvent.VK_O){
            panel.gameState = panel.statsState;
            previousState = panel.tutorialState;
        }

        if(code == KeyEvent.VK_H){
            panel.gameState = panel.loadingState;


            LoadingThread lt = new LoadingThread(panel);
            lt.run(0);
            try {
                synchronized(panel.gameThread){
                    panel.gameThread.wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void playStateKeyHandler(int code){
        if(code == KeyEvent.VK_W){
            upPressed = true;
        }

        if(code == KeyEvent.VK_S){
            downPressed = true;
        }

        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }

        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
        if(code == KeyEvent.VK_P){
            panel.gameState = panel.pauseState;
            previousState = panel.playState;
        }

        if(code == KeyEvent.VK_I){
            panel.gameState = panel.inventoryState;
            previousState = panel.playState;
        }

        if(code == KeyEvent.VK_O){
            panel.gameState = panel.statsState;
            previousState = panel.playState;
        }
    }
    public void pauseStateKeyHandler(int code){
        if(code == KeyEvent.VK_P || code == KeyEvent.VK_ESCAPE) {
            panel.gameState = previousState;
        }

        if (code == KeyEvent.VK_W) {
            panel.ui.setPauseCommandNum(panel.ui.getPauseCommandNum() - 1);
            if (panel.ui.getPauseCommandNum() < 0) {
                panel.ui.setPauseCommandNum(3);
            }
        }

        if (code == KeyEvent.VK_S) {
            panel.ui.setPauseCommandNum(panel.ui.getPauseCommandNum() + 1);
            if (panel.ui.getPauseCommandNum() > 3) {
                panel.ui.setPauseCommandNum(0);
            }
        }

        if (code == KeyEvent.VK_ENTER) {
            switch (panel.ui.getPauseCommandNum()) {
                case 0 -> panel.gameState = previousState;
                case 1 -> {
                    if(previousState == panel.tutorialState){
                        panel.saveAndLoad.save();
                    }
                    panel.gameState = panel.saveState;
                }
                case 2 -> panel.gameState = panel.titleState;
                case 3 -> System.exit(0);
            }
        }
    }

    public void saveStateKeyHandler(int code){
        if(code == KeyEvent.VK_ENTER || code == KeyEvent.VK_ESCAPE){
            panel.gameState = panel.pauseState;
        }
    }

    public void inventoryStateKeyHandler(int code){
        if(code == KeyEvent.VK_I || code == KeyEvent.VK_ESCAPE){
            panel.gameState = previousState;
        }

        if (code == KeyEvent.VK_A) {
            panel.ui.setInventoryNum(panel.ui.getInventoryNum() - 1);
            if (panel.ui.getInventoryNum() < 0) {
                panel.ui.setInventoryNum(9);
            }
        }

        if (code == KeyEvent.VK_D) {
            panel.ui.setInventoryNum(panel.ui.getInventoryNum() + 1);
            if (panel.ui.getInventoryNum() > 9) {
                panel.ui.setInventoryNum(0);
            }
        }

        if (code == KeyEvent.VK_W) {
            if (panel.ui.getInventoryNum() == 0 || panel.ui.getInventoryNum() == 1) {
                panel.ui.setInventoryNum(9);
            }else if(panel.ui.getInventoryNum() > 5 && panel.ui.getInventoryNum() < 9){
                panel.ui.setInventoryNum(2);
            }else if(panel.ui.getInventoryNum() > 1 && panel.ui.getInventoryNum() < 6){
                panel.ui.setInventoryNum(0);
            }else{
                panel.ui.setInventoryNum(6);
            }
        }

        if (code == KeyEvent.VK_S) {
            if (panel.ui.getInventoryNum() == 0 || panel.ui.getInventoryNum() == 1) {
                panel.ui.setInventoryNum(2);
            }else if(panel.ui.getInventoryNum() > 1 && panel.ui.getInventoryNum() < 6){
                panel.ui.setInventoryNum(6);
            }else if(panel.ui.getInventoryNum() > 5 && panel.ui.getInventoryNum() < 9){
                panel.ui.setInventoryNum(9);
            }else{
                panel.ui.setInventoryNum(0);
            }
        }

        if(code == KeyEvent.VK_ENTER){
            if(panel.ui.getInventoryNum() == 9){
                    panel.gameState = previousState;
            }else{
                    panel.gameState = panel.useState;
            }
        }
    }
    public void titleStateKeyHandler(int code){
        if (code == KeyEvent.VK_W) {
            panel.ui.setTitleCommandNum(panel.ui.getTitleCommandNum() - 1);
            if (panel.ui.getTitleCommandNum() < 0) {
                panel.ui.setTitleCommandNum(2);
            }
        }

        if (code == KeyEvent.VK_S) {
            panel.ui.setTitleCommandNum(panel.ui.getTitleCommandNum() + 1);
            if (panel.ui.getTitleCommandNum() > 2) {
                panel.ui.setTitleCommandNum(0);
            }
        }

        if (code == KeyEvent.VK_ENTER) {
            switch (panel.ui.getTitleCommandNum()) {
                case 0 -> {
                    panel.gameState = panel.selectState;
                    previousState = panel.titleState;
                }
                case 1 -> {
                    panel.saveAndLoad.load();
                    panel.gameState = panel.tutorialState;
                }
                case 2 -> System.exit(0);
            }
        }
    }

    public void selectionStateKeyHandler(int code){
        if (code == KeyEvent.VK_A) {
            panel.ui.setSelectNum(panel.ui.getSelectNum() - 1);
            if (panel.ui.getSelectNum() < 0) {
                panel.ui.setSelectNum(28);
            }
        }

        if (code == KeyEvent.VK_D) {
            panel.ui.setSelectNum(panel.ui.getSelectNum() + 1);
            if (panel.ui.getSelectNum() > 28) {
                panel.ui.setSelectNum(0);
            }
        }

        if (code == KeyEvent.VK_W) {
            if(panel.ui.getSelectNum() == 0 || panel.ui.getSelectNum() == 1){
                panel.ui.setSelectNum(27);
            }else if(panel.ui.getSelectNum() == 27 || panel.ui.getSelectNum() == 28){
                panel.ui.setSelectNum(22);
            }else if(panel.ui.getSelectNum() <= 6){
                panel.ui.setSelectNum(0);
            }else {
                panel.ui.setSelectNum(panel.ui.getSelectNum() - 5);
            }

        }

        if (code == KeyEvent.VK_S) {
            if(panel.ui.getSelectNum() == 0 || panel.ui.getSelectNum() == 1){
                panel.ui.setSelectNum(2);
            }else if(panel.ui.getSelectNum() == 27 || panel.ui.getSelectNum() == 28){
                panel.ui.setSelectNum(0);
            }else if(panel.ui.getSelectNum() >= 22){
                panel.ui.setSelectNum(27);
            }else {
                panel.ui.setSelectNum(panel.ui.getSelectNum() + 5);
            }
        }

        if (code == KeyEvent.VK_ENTER) {
            switch (panel.ui.getSelectNum()) {
                case 0 -> panel.player.gender = "boy";
                case 1 -> panel.player.gender = "girl";
                case 2 -> {
                    panel.player.hairColor = "blonde";
                    panel.ui.setSelectedHair(panel.ui.blonde);
                }
                case 3 -> {
                    panel.player.hairColor = "brown";
                    panel.ui.setSelectedHair(panel.ui.brownHair);
                }
                case 4 -> {
                    panel.player.hairColor = "black";
                    panel.ui.setSelectedHair(panel.ui.black);
                }
                case 5 -> {
                    panel.player.hairColor = "red";
                    panel.ui.setSelectedHair(panel.ui.redHair);
                }
                case 6 -> {
                    if(panel.outfits[0].available) {
                        if (panel.outfits[0].equipped) {
                            panel.outfits[0].equipped = false;
                        } else {
                            panel.outfits[0].equipped = true;
                        }
                    }
                }
                case 7 -> {
                    panel.player.skinColor = "lightest";
                    panel.ui.setSelectedSkin(panel.ui.lightest);
                }
                case 8 -> {
                    panel.player.skinColor = "light";
                    panel.ui.setSelectedSkin(panel.ui.light);
                }
                case 9 -> {
                    panel.player.skinColor = "medium";
                    panel.ui.setSelectedSkin(panel.ui.medium);
                }
                case 10 -> {
                    panel.player.skinColor = "dark";
                    panel.ui.setSelectedSkin(panel.ui.dark);
                }
                case 11 -> {
                    panel.player.skinColor = "darkest";
                    panel.ui.setSelectedSkin(panel.ui.darkest);
                }
                case 12 -> {
                    panel.player.shirtColor = "blue";
                    panel.ui.setSelectedShirt(panel.ui.blue);
                }
                case 13 -> {
                    panel.player.shirtColor = "brown";
                    panel.ui.setSelectedShirt(panel.ui.brownShirt);
                }
                case 14 -> {
                    panel.player.shirtColor = "gray";
                    panel.ui.setSelectedShirt(panel.ui.gray);
                }
                case 15 -> {
                    panel.player.shirtColor = "green";
                    panel.ui.setSelectedShirt(panel.ui.green);
                }
                case 16 -> {
                    panel.player.shirtColor = "orange";
                    panel.ui.setSelectedShirt(panel.ui.orange);
                }
                case 17 -> {
                    panel.player.shirtColor = "pink";
                    panel.ui.setSelectedShirt(panel.ui.pink);
                }
                case 18 -> {
                    panel.player.shirtColor = "purple";
                    panel.ui.setSelectedShirt(panel.ui.purple);
                }
                case 19 -> {
                    panel.player.shirtColor = "red";
                    panel.ui.setSelectedShirt(panel.ui.redShirt);
                }
                case 20 -> {
                    panel.player.shirtColor = "teal";
                    panel.ui.setSelectedShirt(panel.ui.teal);
                }
                case 21 -> {
                    panel.player.shirtColor = "white";
                    panel.ui.setSelectedShirt(panel.ui.white);
                }
                case 22 -> {
                    panel.player.shirtColor = "yellow";
                    panel.ui.setSelectedShirt(panel.ui.yellow);
                }
                case 23 -> {
                    if(panel.outfits[1].available) {
                        panel.player.shirtColor = "jacket";
                        panel.ui.setSelectedShirt(panel.ui.jacketColor);
                    }
                }
                case 24 -> {
                    if(panel.outfits[2].available) {
                        panel.player.shirtColor = "suit";
                        panel.ui.setSelectedShirt(panel.ui.suitColor);
                    }
                }
                case 25 -> {
                    if(panel.outfits[3].available) {
                        panel.player.shirtColor = "checker";
                        panel.ui.setSelectedShirt(panel.ui.checkerColor);
                    }
                }
                case 26 -> {
                    if(panel.outfits[4].available) {
                        panel.player.shirtColor = "ragtag";
                        panel.ui.setSelectedShirt(panel.ui.ragtagColor);
                    }
                }
                case 27 -> panel.gameState = previousState;
                case 28 -> {
                        if(previousState == panel.titleState){
                            panel.gameState = panel.tutorialState;
                        }else{
                            panel.gameState = previousState;
                        }
                }
            }
        }
    }

    public void useStateKeyHandler(int code){
        if(code == KeyEvent.VK_D){
            if(panel.ui.getUseNum() == 0){
                panel.ui.setUseNum(1);
            }else{
                panel.ui.setUseNum(0);
            }
        }

        if(code == KeyEvent.VK_A){
            if(panel.ui.getUseNum() == 0){
                panel.ui.setUseNum(1);
            }else{
                panel.ui.setUseNum(0);
            }
        }

        if(code == KeyEvent.VK_ENTER){
            switch (panel.ui.getUseNum()){
                case 0:
                    switch (panel.ui.getInventoryNum()){
                        case 0:
                            break;
                        case 1:
                            break;
                        case 2:
                            if(panel.items[2].numHeld > 0) {
                                ((HealthPotion) panel.items[2]).use();
                                panel.items[2].numHeld--;
                            }
                            break;
                        case 3:
                            if(panel.items[3].numHeld > 0 && !panel.items[3].inUse) {
                                ((StrengthPotion) panel.items[3]).use();
                                panel.items[3].numHeld--;
                            }
                            break;
                        case 4:
                            if(panel.items[4].numHeld > 0 && !panel.inEncounter && !panel.items[4].inUse) {
                                ((SpeedPotion) panel.items[4]).use();
                                panel.items[4].numHeld--;
                            }
                            break;
                        case 5:
                            if(panel.items[5].numHeld > 0 && panel.inEncounter) {
                                ((RerollPotion) panel.items[5]).use();
                                panel.items[5].numHeld--;
                            }
                            break;
                        case 6:
                            if(panel.weapons[0].available) {
                                panel.weapons[0].equipped = true;
                                panel.weapons[1].equipped = false;
                                panel.weapons[2].equipped = false;
                            }
                            break;
                        case 7:
                            if(panel.weapons[1].available) {
                                panel.weapons[0].equipped = false;
                                panel.weapons[1].equipped = true;
                                panel.weapons[2].equipped = false;
                            }
                            break;
                        case 8:
                            if(panel.weapons[2].available) {
                                panel.weapons[0].equipped = false;
                                panel.weapons[1].equipped = false;
                                panel.weapons[2].equipped = true;
                            }
                            break;
                    }
                    panel.gameState = panel.inventoryState;
                    break;
                case 1:
                    panel.gameState = panel.inventoryState;
                    panel.ui.setUseNum(0);
                    break;
            }
        }
    }

    private void treasureStateKeyHandler(int code) {

        if(code == KeyEvent.VK_I){
            panel.gameState = panel.inventoryState;
            previousState = panel.treasureState;
        }

        if(code == KeyEvent.VK_P){
            panel.gameState = panel.pauseState;
            previousState = panel.treasureState;
        }

        if(code == KeyEvent.VK_O){
            panel.gameState = panel.statsState;
            previousState = panel.treasureState;
        }


        if (code == KeyEvent.VK_A  && !panel.questionManager.isDifficultyChosen()) {
            panel.ui.setDifficultyNum(panel.ui.getDifficultyNum() - 1);
            if (panel.ui.getDifficultyNum() < 0) {
                panel.ui.setDifficultyNum(2);
            }
        }

        if (code == KeyEvent.VK_D && !panel.questionManager.isDifficultyChosen()) {
            panel.ui.setDifficultyNum(panel.ui.getDifficultyNum() + 1);
            if (panel.ui.getDifficultyNum() > 2) {
                panel.ui.setDifficultyNum(0);
            }
        }

        if(code == KeyEvent.VK_ENTER && panel.questionManager.isDifficultyChosen() && panel.questionManager.getGivenAns() != ""){
            panel.treasureManager.validateAns();
        }else if(code == KeyEvent.VK_ENTER && !panel.questionManager.isDifficultyChosen() && panel.questionManager.isCorrect()){
            panel.questionManager.setDifficultyChosen(true);
        }else if(code == KeyEvent.VK_ENTER && !panel.questionManager.isCorrect()){
            panel.questionManager.setCorrect(true);
            panel.update();
        }

        if(panel.questionManager.isDifficultyChosen()){
            switch (code){
                case KeyEvent.VK_0, KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3, KeyEvent.VK_4, KeyEvent.VK_5,
                        KeyEvent.VK_6, KeyEvent.VK_7, KeyEvent.VK_8, KeyEvent.VK_9, KeyEvent.VK_R, KeyEvent.VK_F, KeyEvent.VK_T, KeyEvent.VK_SLASH, KeyEvent.VK_MINUS-> {
                    if (panel.questionManager.getGivenAns().length() <= 7) {
                        panel.questionManager.setGivenAns(panel.questionManager.getGivenAns() + (char)(code));
                    }
                }
                case KeyEvent.VK_BACK_SPACE -> {
                    if(panel.questionManager.getGivenAns() != ""){
                        panel.questionManager.setGivenAns(panel.questionManager.getGivenAns().substring(0, panel.questionManager.getGivenAns().length() - 1));
                    }else{
                        panel.questionManager.setGivenAns("");
                    }
                }

            }
        }
    }

    private void fightStateKeyHandler(int code) {
        if(code == KeyEvent.VK_I){
            panel.gameState = panel.inventoryState;
            previousState = panel.fightState;
        }

        if(code == KeyEvent.VK_P){
            panel.gameState = panel.pauseState;
            previousState = panel.fightState;
        }

        if(code == KeyEvent.VK_O){
            panel.gameState = panel.statsState;
            previousState = panel.fightState;
        }


        if (code == KeyEvent.VK_A  && !panel.questionManager.isDifficultyChosen()) {
            panel.ui.setDifficultyNum(panel.ui.getDifficultyNum() - 1);
            if (panel.ui.getDifficultyNum() < 0) {
                panel.ui.setDifficultyNum(2);
            }
        }

        if (code == KeyEvent.VK_D && !panel.questionManager.isDifficultyChosen()) {
            panel.ui.setDifficultyNum(panel.ui.getDifficultyNum() + 1);
            if (panel.ui.getDifficultyNum() > 2) {
                panel.ui.setDifficultyNum(0);
            }
        }

        if(code == KeyEvent.VK_ENTER && panel.questionManager.isDifficultyChosen() && panel.questionManager.getGivenAns() != ""){
            panel.fightManager.validateAns();
        }else if(code == KeyEvent.VK_ENTER && !panel.questionManager.isDifficultyChosen() && panel.questionManager.isCorrect()){
            panel.questionManager.setDifficultyChosen(true);
        }else if(code == KeyEvent.VK_ENTER && !panel.questionManager.isCorrect()){
            panel.questionManager.setCorrect(true);
            panel.update();
        }

        if(panel.questionManager.isDifficultyChosen()){
            switch (code){
                case KeyEvent.VK_0, KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3, KeyEvent.VK_4, KeyEvent.VK_5,
                        KeyEvent.VK_6, KeyEvent.VK_7, KeyEvent.VK_8, KeyEvent.VK_9, KeyEvent.VK_R, KeyEvent.VK_F, KeyEvent.VK_T, KeyEvent.VK_SLASH, KeyEvent.VK_MINUS -> {
                    if (panel.questionManager.getGivenAns().length() <= 7) {
                        panel.questionManager.setGivenAns(panel.questionManager.getGivenAns() + (char)(code));
                    }
                }
                case KeyEvent.VK_BACK_SPACE -> {
                    if(panel.questionManager.getGivenAns() != ""){
                        panel.questionManager.setGivenAns(panel.questionManager.getGivenAns().substring(0, panel.questionManager.getGivenAns().length() - 1));
                    }else{
                        panel.questionManager.setGivenAns("");
                    }
                }

            }
        }
    }

    public void deathStateKeyHandler(int code) {
        if(code == KeyEvent.VK_ENTER){
            panel.gameState = panel.tutorialState;
        }
    }

    public void statsAndAchievementKeyHandler(int code) {
        if(code == KeyEvent.VK_O || code == KeyEvent.VK_ESCAPE) {
            panel.gameState = previousState;
        }

        if(code == KeyEvent.VK_D){
            if(panel.gameState == panel.statsState){
                panel.gameState = panel.achievementState;
            }else{
                panel.gameState = panel.statsState;
            }
        }

        if(code == KeyEvent.VK_A){
            if(panel.gameState == panel.statsState){
                panel.gameState = panel.achievementState;
            }else{
                panel.gameState = panel.statsState;
            }
        }
    }


    public void weaponStoreStateKeyHandler(int code){
        if(code == KeyEvent.VK_ESCAPE){
            panel.gameState = panel.tutorialState;
        }

        if(code == KeyEvent.VK_I){
            panel.gameState = panel.inventoryState;
            previousState = panel.weaponStoreState;
        }

        if (code == KeyEvent.VK_A) {
            panel.ui.setWeaponNum(panel.ui.getWeaponNum() - 1);
            if (panel.ui.getWeaponNum() < 0) {
                panel.ui.setWeaponNum(3);
            }
        }

        if (code == KeyEvent.VK_D) {
            panel.ui.setWeaponNum(panel.ui.getWeaponNum() + 1);
            if (panel.ui.getWeaponNum() > 3) {
                panel.ui.setWeaponNum(0);
            }
        }

        if (code == KeyEvent.VK_W) {
            if(panel.ui.getWeaponNum() < 3) {
                panel.ui.setWeaponNum(3);
            }else{
                panel.ui.setWeaponNum(0);
            }
        }

        if (code == KeyEvent.VK_S) {
            if(panel.ui.getWeaponNum() < 3) {
                panel.ui.setWeaponNum(3);
            }else{
                panel.ui.setWeaponNum(0);
            }
        }

        if(code == KeyEvent.VK_ENTER){
            if(panel.ui.getWeaponNum() == 3){
                panel.gameState = panel.tutorialState;
            }else{
                panel.gameState = panel.purchaseWeaponState;
                previousState = panel.weaponStoreState;
            }
        }
    }

    public void outfitterStoreStateKeyHandler(int code){
        if(code == KeyEvent.VK_ESCAPE){
            panel.gameState = panel.tutorialState;
        }

        if(code == KeyEvent.VK_I){
            panel.gameState = panel.inventoryState;
            previousState = panel.outfitterStoreState;
        }

        if (code == KeyEvent.VK_A) {
            panel.ui.setOutfitterNum(panel.ui.getOutfitterNum() - 1);
            if (panel.ui.getOutfitterNum() < 0) {
                panel.ui.setOutfitterNum(6);
            }
        }

        if (code == KeyEvent.VK_D) {
            panel.ui.setOutfitterNum(panel.ui.getOutfitterNum() + 1);
            if (panel.ui.getOutfitterNum() > 6) {
                panel.ui.setOutfitterNum(0);
            }
        }

        if (code == KeyEvent.VK_W) {
            if(panel.ui.getOutfitterNum() < 3) {
                panel.ui.setOutfitterNum(6);
            }else if(panel.ui.getOutfitterNum() == 6){
                panel.ui.setOutfitterNum(5);
            }else if(panel.ui.getOutfitterNum() == 5){
                panel.ui.setOutfitterNum(3);
            }else{
                panel.ui.setOutfitterNum(0);
            }
        }

        if (code == KeyEvent.VK_S) {
            if(panel.ui.getOutfitterNum() < 3) {
                panel.ui.setOutfitterNum(3);
            }else if(panel.ui.getOutfitterNum() == 6){
                panel.ui.setOutfitterNum(0);
            }else if(panel.ui.getOutfitterNum() == 5){
                panel.ui.setOutfitterNum(6);
            }else{
                panel.ui.setOutfitterNum(5);
            }
        }

        if(code == KeyEvent.VK_ENTER){
            if(panel.ui.getOutfitterNum() == 6) {
                panel.gameState = panel.tutorialState;
            }else if(panel.ui.getOutfitterNum() == 5){
                panel.gameState = panel.selectState;
                previousState = panel.outfitterStoreState;
            }else{
                panel.gameState = panel.purchaseOutfitState;
                previousState = panel.outfitterStoreState;
            }
        }
    }

    public void doctorStoreStateKeyHandler(int code){
        if(code == KeyEvent.VK_ESCAPE){
            panel.gameState = panel.tutorialState;
        }

        if(code == KeyEvent.VK_I){
            panel.gameState = panel.inventoryState;
            previousState = panel.doctorStoreState;
        }

        if (code == KeyEvent.VK_A) {
            panel.ui.setPotionNum(panel.ui.getPotionNum() - 1);
            if (panel.ui.getPotionNum() < 0) {
                panel.ui.setPotionNum(4);
            }
        }

        if (code == KeyEvent.VK_D) {
            panel.ui.setPotionNum(panel.ui.getPotionNum() + 1);
            if (panel.ui.getPotionNum() > 4) {
                panel.ui.setPotionNum(0);
            }
        }

        if (code == KeyEvent.VK_W) {
            if(panel.ui.getPotionNum() < 4) {
                panel.ui.setPotionNum(4);
            }else{
                panel.ui.setPotionNum(0);
            }
        }

        if (code == KeyEvent.VK_S) {
            if(panel.ui.getPotionNum() < 4) {
                panel.ui.setPotionNum(4);
            }else{
                panel.ui.setPotionNum(0);
            }
        }

        if(code == KeyEvent.VK_ENTER){
            if(panel.ui.getPotionNum() == 4){
                panel.gameState = panel.tutorialState;
            }else{
                panel.gameState = panel.purchasePotionState;
                previousState = panel.doctorStoreState;
            }
        }
    }

    public void purchaseStateKeyHandler(int code){
        if(code == KeyEvent.VK_D){
            if(panel.ui.getUseNum() == 0){
                panel.ui.setUseNum(1);
            }else{
                panel.ui.setUseNum(0);
            }
        }

        if(code == KeyEvent.VK_A){
            if(panel.ui.getUseNum() == 0){
                panel.ui.setUseNum(1);
            }else{
                panel.ui.setUseNum(0);
            }
        }

        if(code == KeyEvent.VK_ENTER){
            if(previousState == panel.weaponStoreState){
                switch (panel.ui.getUseNum()){
                    case 0:
                        switch (panel.ui.getWeaponNum()) {
                            case 0:
                                if (!panel.weapons[0].available && panel.items[0].numHeld >= panel.weapons[0].price) {
                                    panel.weapons[0].available = true;
                                    panel.items[0].numHeld -= panel.weapons[0].price;
                                    panel.gameState = previousState;
                                }
                                break;
                            case 1:
                                if (!panel.weapons[1].available && panel.items[0].numHeld >= panel.weapons[1].price) {
                                    panel.weapons[1].available = true;
                                    panel.items[0].numHeld -= panel.weapons[1].price;
                                    panel.gameState = previousState;
                                }
                                break;
                            case 2:
                                if (!panel.weapons[2].available && panel.items[0].numHeld >= panel.weapons[2].price){
                                    panel.weapons[2].available = true;
                                    panel.items[0].numHeld -= panel.weapons[2].price;
                                    panel.gameState = previousState;
                                }
                                break;
                        }
                        break;
                    case 1:
                        panel.gameState = previousState;
                        panel.ui.setUseNum(0);
                        break;
                }
            }
            if(previousState == panel.doctorStoreState){
                switch (panel.ui.getUseNum()){
                    case 0:
                        switch (panel.ui.getPotionNum()) {
                            case 0:
                                if (panel.items[0].numHeld >= panel.items[2].price) {
                                    panel.items[0].numHeld -= panel.items[2].price;
                                    panel.items[2].numHeld++;
                                    panel.gameState = previousState;
                                }
                                break;
                            case 1:
                                if (panel.items[0].numHeld >= panel.items[3].price) {
                                    panel.items[0].numHeld -= panel.items[3].price;
                                    panel.items[3].numHeld++;
                                    panel.gameState = previousState;
                                }
                                break;
                            case 2:
                                if (panel.items[0].numHeld >= panel.items[4].price){
                                    panel.items[0].numHeld -= panel.items[4].price;
                                    panel.items[4].numHeld++;
                                    panel.gameState = previousState;
                                }
                                break;
                            case 3:
                                if (panel.items[0].numHeld >= panel.items[5].price){
                                    panel.items[0].numHeld -= panel.items[5].price;
                                    panel.items[5].numHeld++;
                                    panel.gameState = previousState;
                                }
                                break;
                        }
                        break;
                    case 1:
                        panel.gameState = previousState;
                        panel.ui.setUseNum(0);
                        break;
                }
            }
            if(previousState == panel.outfitterStoreState) {
                switch (panel.ui.getUseNum()) {
                    case 0:
                        switch (panel.ui.getOutfitterNum()) {
                            case 0:
                                if (!panel.outfits[0].available && panel.items[0].numHeld >= panel.outfits[0].price) {
                                    panel.outfits[0].available = true;
                                    panel.items[0].numHeld -= panel.outfits[0].price;
                                    panel.gameState = previousState;
                                }
                                break;
                            case 1:
                                if (!panel.outfits[1].available && panel.items[0].numHeld >= panel.outfits[1].price) {
                                    panel.outfits[1].available = true;
                                    panel.items[0].numHeld -= panel.outfits[1].price;
                                    panel.gameState = previousState;
                                }
                                break;
                            case 2:
                                if (!panel.outfits[2].available && panel.items[0].numHeld >= panel.outfits[2].price) {
                                    panel.outfits[2].available = true;
                                    panel.items[0].numHeld -= panel.outfits[2].price;
                                    panel.gameState = previousState;
                                }
                                break;
                            case 3:
                                if (!panel.outfits[3].available && panel.items[0].numHeld >= panel.outfits[3].price) {
                                    panel.outfits[3].available = true;
                                    panel.items[0].numHeld -= panel.outfits[3].price;
                                    panel.gameState = previousState;
                                }
                                break;
                            case 4:
                                if (!panel.outfits[4].available && panel.items[0].numHeld >= panel.outfits[4].price) {
                                    panel.outfits[4].available = true;
                                    panel.items[0].numHeld -= panel.outfits[4].price;
                                    panel.gameState = previousState;
                                }
                                break;


                        }
                        break;
                    case 1:
                        panel.gameState = previousState;
                        panel.ui.setUseNum(0);
                        break;
                }
            }
        }
    }

}
