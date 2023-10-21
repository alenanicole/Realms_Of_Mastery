package data;

import main.GamePanel;

import java.awt.image.BufferedImage;
import java.io.*;

public class SaveAndLoad {

    GamePanel panel;

    public SaveAndLoad(GamePanel panel){
        this.panel = panel;
    }

    public void save(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
            DataStorage dataStorage = new DataStorage();

            // Player Info
            dataStorage.worldX = panel.player.worldX;
            dataStorage.worldY = panel.player.worldY;
            dataStorage.direction = panel.player.direction;
            dataStorage.spriteCounter = panel.player.spriteCounter;
            dataStorage.spriteNum = panel.player.spriteNum;

            dataStorage.hairColor = panel.player.hairColor;
            dataStorage.skinColor = panel.player.skinColor;
            dataStorage.shirtColor = panel.player.shirtColor;
            dataStorage.gender = panel.player.gender;

            //Player Stats
            dataStorage.maxHealth = panel.player.maxHealth;
            dataStorage.currentHealth = panel.player.currentHealth;
            dataStorage.tierOneDamage = panel.player.tierOneDamage;
            dataStorage.tierTwoDamage = panel.player.tierTwoDamage;
            dataStorage.tierThreeDamage = panel.player.tierThreeDamage;
            dataStorage.speed = panel.player.speed;

            // Stats and Achievements
            dataStorage.monstersDefeated = panel.player.monstersDefeated;
            dataStorage.goldCollected = panel.player.goldCollected;
            dataStorage.chestsOpened = panel.player.chestsOpened;
            dataStorage.potionsUsed = panel.player.potionsUsed;
            dataStorage.bossesSlain = panel.player.bossesSlain;
            dataStorage.rightAnswersInRow = panel.player.rightAnswersInRow;
            dataStorage.maxRightAnswersInRow = panel.player.maxRightAnswersInRow;
            dataStorage.rightAnswers = panel.player.rightAnswers;
            dataStorage.bestCategory = panel.player.bestCategory;

            // Calculate best category stats
            dataStorage.rightFractionQuestions = panel.player.rightFractionQuestions;
            dataStorage.totalFractionQuestions = panel.player.totalFractionQuestions;
            dataStorage.rightMultiplicationQuestions = panel.player.rightMultiplicationQuestions;
            dataStorage.totalMultiplicationQuestions = panel.player.totalMultiplicationQuestions;
            dataStorage.rightDivisionQuestions = panel.player.rightDivisionQuestions;
            dataStorage.totalDivisionQuestions = panel.player.totalDivisionQuestions;
            dataStorage.rightWordProblemQuestions = panel.player.rightWordProblemQuestions;
            dataStorage.totalWordProblemQuestions = panel.player.totalWordProblemQuestions;


            // Items, Weapons, outfits
            dataStorage.coinsHeld = panel.items[0].numHeld;
            dataStorage.swordAvailable = panel.weapons[0].available;
            dataStorage.staffAvailable = panel.weapons[1].available;
            dataStorage.bowAvailable = panel.weapons[2].available;

            dataStorage.swordEquipped = panel.weapons[0].equipped;
            dataStorage.staffEquipped = panel.weapons[1].equipped;
            dataStorage.bowEquipped = panel.weapons[2].equipped;

            oos.writeObject(dataStorage);
        } catch (IOException e) {
            System.out.println("Could not save!");
            e.printStackTrace();
        }

    }

    public void load(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));
            DataStorage dataStorage = (DataStorage)(ois.readObject());

            // Player Info
            panel.player.worldX = dataStorage.worldX;
            panel.player.worldY = dataStorage.worldY;
            panel.player.direction = dataStorage.direction;
            panel.player.spriteCounter = dataStorage.spriteCounter;
            panel.player.spriteNum = dataStorage.spriteNum;

            panel.player.hairColor = dataStorage.hairColor;
            panel.player.skinColor = dataStorage.skinColor;
            panel.player.shirtColor = dataStorage.shirtColor;
            panel.player.gender = dataStorage.gender;

            panel.player.getPlayerImage();

            //Player Stats
            panel.player.maxHealth = dataStorage.maxHealth;
            panel.player.currentHealth = dataStorage.currentHealth;
            panel.player.tierOneDamage = dataStorage.tierOneDamage;
            panel.player.tierTwoDamage = dataStorage.tierTwoDamage;
            panel.player.tierThreeDamage = dataStorage.tierThreeDamage;
            panel.player.speed = dataStorage.speed;

            // Stats and Achievements
            panel.player.monstersDefeated = dataStorage.monstersDefeated;
            panel.player.goldCollected = dataStorage.goldCollected;
            panel.player.chestsOpened = dataStorage.chestsOpened;
            panel.player.potionsUsed = dataStorage.potionsUsed;
            panel.player.bossesSlain = dataStorage.bossesSlain;
            panel.player.rightAnswersInRow = dataStorage.rightAnswersInRow;
            panel.player.maxRightAnswersInRow = dataStorage.maxRightAnswersInRow;
            panel.player.rightAnswers = dataStorage.rightAnswers;
            panel.player.bestCategory = dataStorage.bestCategory;

            // Calculate best category stats
            panel.player.rightFractionQuestions = dataStorage.rightFractionQuestions;
            panel.player.totalFractionQuestions = dataStorage.totalFractionQuestions;
            panel.player.rightMultiplicationQuestions = dataStorage.rightMultiplicationQuestions;
            panel.player.totalMultiplicationQuestions = dataStorage.totalMultiplicationQuestions;
            panel.player.rightDivisionQuestions = dataStorage.rightDivisionQuestions;
            panel.player.totalDivisionQuestions = dataStorage.totalDivisionQuestions;
            panel.player.rightWordProblemQuestions = dataStorage.rightWordProblemQuestions;
            panel.player.totalWordProblemQuestions = dataStorage.totalWordProblemQuestions;


            // Items, Weapons, outfits
            panel.items[0].numHeld = dataStorage.coinsHeld;
            panel.weapons[0].available = dataStorage.swordAvailable;
            panel.weapons[1].available = dataStorage.staffAvailable;
            panel.weapons[2].available = dataStorage.bowAvailable;

            panel.weapons[0].equipped = dataStorage.swordEquipped;
            panel.weapons[1].equipped = dataStorage.staffEquipped;
            panel.weapons[2].equipped = dataStorage.bowEquipped;
        } catch (Exception e) {
            System.out.println("Could not load!");
            e.printStackTrace();
        }


    }
}
