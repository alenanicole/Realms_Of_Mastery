package data;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class DataStorage implements Serializable {

    // Player Info
    public int worldX, worldY;
    public String direction;
    public int spriteCounter;
    public int spriteNum;

    public String hairColor;
    public String skinColor;
    public String shirtColor;
    public String gender;

    // Player Stats

    public int maxHealth;
    public int currentHealth;
    public int tierOneDamage;
    public int tierTwoDamage;
    public int tierThreeDamage;
    public int speed;


    // Stats and Achievements
    public int monstersDefeated;
    public int goldCollected;
    public int chestsOpened;
    public int potionsUsed;
    public int bossesSlain;
    public int rightAnswersInRow;
    public int maxRightAnswersInRow;
    public int rightAnswers;
    public String bestCategory;

    // Calculate best category stats
    public int rightFractionQuestions;
    public int totalFractionQuestions;
    public int rightMultiplicationQuestions;
    public int totalMultiplicationQuestions;
    public int rightDivisionQuestions;
    public int totalDivisionQuestions;
    public int rightWordProblemQuestions;
    public int totalWordProblemQuestions;


    // Items, Weapons, outfits
    public int coinsHeld;
    public boolean swordAvailable;
    public boolean staffAvailable;
    public boolean bowAvailable;

    public boolean swordEquipped;
    public boolean staffEquipped;
    public boolean bowEquipped;

    // Upgrades and Outfits
    public boolean healthUpgradeCanPurchase;
    public boolean strengthUpgradeCanPurchase;
    public boolean speedUpgradeCanPurchase;
    public int healthUpgradeNumAvailable;
    public int strengthUpgradeNumAvailable;
    public int speedUpgradeNumAvailable;
    public boolean hatAvailable;
    public boolean hatEquipped;
    public boolean jacketAvailable;
    public boolean checkerAvailable;
    public boolean suitAvailable;
    public boolean ragtagAvailable;


}
