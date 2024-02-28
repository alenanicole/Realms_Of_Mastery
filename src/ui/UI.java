package ui;

import main.GamePanel;
import main.ScalingManager;
import ui.npc.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class UI {

    GamePanel panel;
    Graphics2D graphics2D;
    ScalingManager scalingManager = new ScalingManager();
    public Font joystix;
    public Font joystix_small;
    public Font joystix_smallest;
    public Font press_start;
    public Font press_start_small;
    private int titleCommandNum = 0;
    private int selectNum = 0;
    private int pauseCommandNum = 0;
    private int inventoryNum = 0;
    private int useNum = 0;
    private int difficultyNum = 0;
    private int startRunNum = 0;
    private int weaponNum = 0;
    private int outfitterNum = 0;
    private int potionNum = 0;
    private int upgradeNum = 0;
    private int bossRushNum = 0;

    public Color background, button, border;
    public Color blonde, brownHair, black, redHair;
    public Color lightest, light, medium, dark, darkest;
    public Color blue, brownShirt, gray, green, orange, pink, purple, redShirt, teal, white, yellow, jacketColor, suitColor, checkerColor, ragtagColor;
    private Color selectedHair;
    private Color selectedSkin;

    private Color selectedShirt;

    public BufferedImage questionMark;
    BufferedImage frame;
    public BufferedImage fullHeart, halfHeart, emptyHeart;
    BufferedImage monstFullHeart, monstHalfHeart;
    public BufferedImage boot, dumbbell;
    BufferedImage hat, jacket, suit, checker, ragtag;

    BufferedImage whiteTrophy, bronzeTrophy, silverTrophy, goldTrophy;

    BufferedImage centralMap;

    float alpha = 0.3f;
    int type = AlphaComposite.SRC_OVER;
    public AlphaComposite composite =
            AlphaComposite.getInstance(type, alpha);
    public AlphaComposite originalComposite =
            AlphaComposite.getInstance(type, 1F);

    private int spriteNum = 1;
    private int spriteCounter = 0;

    private int monsterIdx;

    TitleScreen titleScreen;
    SelectScreen selectScreen;
    PauseScreen pauseScreen;
    TutorialScreen tutorialScreen;
    PlayScreen playScreen;
    UseScreen useScreen;
    InventoryScreen inventoryScreen;
    DeathScreen deathScreen;
    StartRunScreen startRunScreen;

    StatsScreen statsScreen;
    AchievementScreen achievementScreen;

    public TreasureScreen treasureScreen;
    public FightScreen fightScreen;
    WrongAnswerScreen answerScreen;
    public LoadingScreen loadingScreen;

    WeaponMasterStore weaponMasterStore;
    PurchaseWeaponScreen purchaseWeaponScreen;
    OutfitterStore outfitterStore;
    PurchaseOutfitScreen purchaseOutfitScreen;
    DoctorStore doctorStore;
    PurchasePotionScreen purchasePotionScreen;
    ArtificerStore artificerStore;
    PurchaseUpgradesScreen purchaseUpgradesScreen;

    SaveScreen saveScreen;
    WinScreen winScreen;
    MapScreen mapScreen;

    HelpScreen helpScreen;
    BossRushStartScreen bossRushStartScreen;
    BossRushScreen bossRushScreen;

    public UI (GamePanel panel){
        this.panel = panel;

        initializeFonts();
        initializePopups(panel);
        initializeColors();

        setSelectedHair(brownHair);
        setSelectedSkin(lightest);
        setSelectedShirt(green);

    }

    private void initializePopups(GamePanel panel) {
        try {
            questionMark = ImageIO.read(Objects.requireNonNull(getClass().getResource("/popups/questionmark.png")));
            questionMark = scalingManager.toCompatibleImage(questionMark, panel.tileSize, panel.tileSize);
            frame = ImageIO.read(Objects.requireNonNull(getClass().getResource("/popups/frame.png")));
            frame = scalingManager.toCompatibleImage(frame, panel.tileSize, panel.tileSize);
            fullHeart = ImageIO.read(Objects.requireNonNull(getClass().getResource("/popups/full_heart.png")));
            fullHeart = scalingManager.toCompatibleImage(fullHeart, panel.tileSize, panel.tileSize);
            halfHeart = ImageIO.read(Objects.requireNonNull(getClass().getResource("/popups/half_heart.png")));
            halfHeart = scalingManager.toCompatibleImage(halfHeart, panel.tileSize, panel.tileSize);
            monstFullHeart = ImageIO.read(Objects.requireNonNull(getClass().getResource("/popups/monst_full_heart.png")));
            monstFullHeart = scalingManager.toCompatibleImage(monstFullHeart, panel.tileSize, panel.tileSize);
            monstHalfHeart= ImageIO.read(Objects.requireNonNull(getClass().getResource("/popups/monst_half_heart.png")));
            monstHalfHeart = scalingManager.toCompatibleImage(monstHalfHeart, panel.tileSize, panel.tileSize);
            emptyHeart = ImageIO.read(Objects.requireNonNull(getClass().getResource("/popups/empty_heart.png")));
            emptyHeart = scalingManager.toCompatibleImage(emptyHeart, panel.tileSize, panel.tileSize);
            boot = ImageIO.read(Objects.requireNonNull(getClass().getResource("/popups/boot.png")));
            boot = scalingManager.toCompatibleImage(boot, panel.tileSize, panel.tileSize);
            dumbbell = ImageIO.read(Objects.requireNonNull(getClass().getResource("/popups/dumbbell.png")));
            dumbbell = scalingManager.toCompatibleImage(dumbbell, panel.tileSize, panel.tileSize);

            hat = ImageIO.read(Objects.requireNonNull(getClass().getResource("/outfit/hat/hat.png")));
            hat = scalingManager.toCompatibleImage(hat, panel.tileSize, panel.tileSize);
            jacket = ImageIO.read(Objects.requireNonNull(getClass().getResource("/outfit/jacket/jacketColor.png")));
            jacket = scalingManager.toCompatibleImage(jacket, panel.tileSize, panel.tileSize);
            suit = ImageIO.read(Objects.requireNonNull(getClass().getResource("/outfit/suit/suitColor.png")));
            suit = scalingManager.toCompatibleImage(suit, panel.tileSize, panel.tileSize);
            checker = ImageIO.read(Objects.requireNonNull(getClass().getResource("/outfit/checker/checkerColor.png")));
            checker = scalingManager.toCompatibleImage(checker, panel.tileSize, panel.tileSize);
            ragtag = ImageIO.read(Objects.requireNonNull(getClass().getResource("/outfit/ragtag/ragtagColor.png")));
            ragtag = scalingManager.toCompatibleImage(ragtag, panel.tileSize, panel.tileSize);


            whiteTrophy = ImageIO.read(Objects.requireNonNull(getClass().getResource("/popups/white_trophy.png")));
            whiteTrophy = scalingManager.toCompatibleImage(whiteTrophy, panel.tileSize, panel.tileSize);
            bronzeTrophy = ImageIO.read(Objects.requireNonNull(getClass().getResource("/popups/bronze_trophy.png")));
            bronzeTrophy = scalingManager.toCompatibleImage(bronzeTrophy, panel.tileSize, panel.tileSize);
            silverTrophy = ImageIO.read(Objects.requireNonNull(getClass().getResource("/popups/silver_trophy.png")));
            silverTrophy = scalingManager.toCompatibleImage(silverTrophy, panel.tileSize, panel.tileSize);
            goldTrophy = ImageIO.read(Objects.requireNonNull(getClass().getResource("/popups/gold_trophy.png")));
            goldTrophy = scalingManager.toCompatibleImage(goldTrophy, panel.tileSize, panel.tileSize);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initializeColors() {
        background = new Color(70, 120, 80);
        button = new Color(39, 53, 54);
        border = new Color(21, 30, 21);
        blonde = new Color(218,181,69);
        brownHair = new Color(56,34,20);
        black = new Color(9,15,27);
        redHair = new Color(119, 31, 10);
        lightest = new Color(249, 209, 172);
        light = new Color(215,175,140);
        medium = new Color(206,172,127);
        dark = new Color(154,112,80);
        darkest = new Color(64,41,32);
        blue = new Color(30,58,112);
        brownShirt = new Color(124,98,72);
        gray = new Color(80,77,74);
        green = new Color(45,68,25);
        orange = new Color(234,120,49);
        pink = new Color(162,42,128);
        purple = new Color(103, 38, 188);
        redShirt = new Color(138,25,19);
        teal = new Color(120,239,192);
        white = new Color(255, 255, 255);
        yellow = new Color(236,224,87);
        jacketColor = new Color(72, 5, 5);
        suitColor = new Color(42, 42, 53);
        checkerColor = new Color(111, 143, 136);
        ragtagColor = new Color(9, 61, 21);
    }

    private void initializeFonts() {
        try {
            InputStream stream = getClass().getResourceAsStream("/fonts/joystix/joystix_monospace.otf");
            joystix = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(48F);
            stream = getClass().getResourceAsStream("/fonts/joystix/joystix_monospace.otf");
            joystix_small = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(36F);
            stream = getClass().getResourceAsStream("/fonts/joystix/joystix_monospace.otf");
            joystix_smallest = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(30F);
            stream = getClass().getResourceAsStream("/fonts/press-start/prstart.ttf");
            press_start = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(16F);
            stream = getClass().getResourceAsStream("/fonts/press-start/prstart.ttf");
            press_start_small = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(12F);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initializeScreens(){
        selectScreen = new SelectScreen(panel);
        pauseScreen = new PauseScreen(panel);
        playScreen = new PlayScreen(panel);
        useScreen = new UseScreen(panel);
        inventoryScreen = new InventoryScreen(panel);
        treasureScreen = new TreasureScreen(panel);
        fightScreen = new FightScreen(panel);
        tutorialScreen = new TutorialScreen(panel);
        deathScreen = new DeathScreen(panel);
        startRunScreen = new StartRunScreen(panel);
        statsScreen = new StatsScreen(panel);
        achievementScreen = new AchievementScreen(panel);
        answerScreen = new WrongAnswerScreen(panel);
        loadingScreen = new LoadingScreen(panel, graphics2D);
        saveScreen = new SaveScreen(panel);
        winScreen = new WinScreen(panel);
        helpScreen = new HelpScreen(panel);
        mapScreen = new MapScreen(panel);
        bossRushStartScreen = new BossRushStartScreen(panel);
        bossRushScreen = new BossRushScreen(panel);

        weaponMasterStore = new WeaponMasterStore(panel);
        purchaseWeaponScreen = new PurchaseWeaponScreen(panel);
        outfitterStore = new OutfitterStore(panel);
        purchaseOutfitScreen = new PurchaseOutfitScreen(panel);
        doctorStore = new DoctorStore(panel);
        purchasePotionScreen = new PurchasePotionScreen(panel);
        artificerStore = new ArtificerStore(panel);
        purchaseUpgradesScreen = new PurchaseUpgradesScreen(panel);


    }

    public void draw(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
        graphics2D.setFont(joystix);
        graphics2D.setColor(Color.white);


        if (panel.gameState == panel.titleState) {
            titleScreen = new TitleScreen(panel);
            titleScreen.draw(graphics2D);
        }
        if (panel.gameState == panel.selectState) {
            selectScreen.draw(graphics2D);
        }
        if(panel.gameState == panel.tutorialState){
            playScreen.draw(graphics2D);
            tutorialScreen.draw(graphics2D);
        }
        if(panel.gameState == panel.helpState){
            playScreen.draw(graphics2D);
            helpScreen.draw(graphics2D);
        }
        if(panel.gameState == panel.mapState){
            playScreen.draw(graphics2D);
            mapScreen.draw(graphics2D);
        }
        if (panel.gameState == panel.playState) {
            playScreen.draw(graphics2D);
        }
        if (panel.gameState == panel.pauseState) {
            playScreen.draw(graphics2D);
            pauseScreen.draw(graphics2D);
        }
        if(panel.gameState == panel.saveState){
            playScreen.draw(graphics2D);
            pauseScreen.draw(graphics2D);
            saveScreen.draw(graphics2D);
        }
        if (panel.gameState == panel.inventoryState) {
            playScreen.draw(graphics2D);
            inventoryScreen.draw(graphics2D);
        }
        if (panel.gameState == panel.useState) {
            playScreen.draw(graphics2D);
            inventoryScreen.draw(graphics2D);
            useScreen.draw(graphics2D);
        }
        if (panel.gameState == panel.treasureState) {
            playScreen.draw(graphics2D);
            treasureScreen.drawDifficultySelection(graphics2D);
            if (panel.questionManager.isDifficultyChosen()) {
                treasureScreen.drawQuestion();
            }
            if(!panel.questionManager.isCorrect()){
                answerScreen.draw(graphics2D);
            }
        }
        if(panel.gameState == panel.fightState){
            playScreen.draw(graphics2D);
            fightScreen.drawDifficultySelection(graphics2D);
            if (panel.questionManager.isDifficultyChosen()) {
                fightScreen.drawQuestion();
            }
            if(!panel.questionManager.isCorrect()){
                answerScreen.draw(graphics2D);
            }
        }
        if(panel.gameState == panel.deathState){
            playScreen.draw(graphics2D);
            deathScreen.draw(graphics2D);
        }
        if(panel.gameState == panel.startRunState){
            playScreen.draw(graphics2D);
            startRunScreen.draw(graphics2D);
        }
        if(panel.gameState == panel.bossRushStartState){
            playScreen.draw(graphics2D);
            bossRushStartScreen.draw(graphics2D);
        }
        if(panel.gameState == panel.bossRushState){
            playScreen.draw(graphics2D);
            bossRushScreen.draw(graphics2D);
        }
        if(panel.gameState == panel.wrongAnswerState){
            playScreen.draw(graphics2D);
            bossRushScreen.draw(graphics2D);
            answerScreen.draw(graphics2D);
        }
        if(panel.gameState == panel.statsState){
            playScreen.draw(graphics2D);
            statsScreen.draw(graphics2D);
        }
        if(panel.gameState == panel.achievementState){
            playScreen.draw(graphics2D);
            achievementScreen.draw(graphics2D);
        }
        if(panel.gameState == panel.loadingState){
            loadingScreen.draw(graphics2D);
        }

        if(panel.gameState == panel.weaponStoreState){
            playScreen.draw(graphics2D);
            weaponMasterStore.draw(graphics2D);
        }
        if(panel.gameState == panel.purchaseWeaponState){
            playScreen.draw(graphics2D);
            weaponMasterStore.draw(graphics2D);
            purchaseWeaponScreen.draw(graphics2D);
        }
        if(panel.gameState == panel.outfitterStoreState){
            playScreen.draw(graphics2D);
            outfitterStore.draw(graphics2D);
        }
        if(panel.gameState == panel.purchaseOutfitState){
            playScreen.draw(graphics2D);
            outfitterStore.draw(graphics2D);
            purchaseOutfitScreen.draw(graphics2D);
        }
        if(panel.gameState == panel.doctorStoreState){
            playScreen.draw(graphics2D);
            doctorStore.draw(graphics2D);
        }
        if(panel.gameState == panel.purchasePotionState){
            playScreen.draw(graphics2D);
            doctorStore.draw(graphics2D);
            purchasePotionScreen.draw(graphics2D);
        }
        if(panel.gameState == panel.artificerStoreState){
            playScreen.draw(graphics2D);
            artificerStore.draw(graphics2D);
        }
        if(panel.gameState == panel.purchaseUpgradesState){
            playScreen.draw(graphics2D);
            artificerStore.draw(graphics2D);
            purchaseUpgradesScreen.draw(graphics2D);
        }
        if(panel.gameState == panel.winState){
            playScreen.draw(graphics2D);
            winScreen.draw(graphics2D);
        }
    }

    public int getCenteredX(String text, Graphics2D graphics2D){
        int length = (int) graphics2D.getFontMetrics().getStringBounds(text, graphics2D).getWidth();
        return panel.screenWidth/2 - length/2;
    }

    public int getTitleCommandNum() {
        return titleCommandNum;
    }

    public void setTitleCommandNum(int titleCommandNum) {
        this.titleCommandNum = titleCommandNum;
    }

    public int getSelectNum() {
        return selectNum;
    }

    public void setSelectNum(int selectNum) {
        this.selectNum = selectNum;
    }

    public Color getSelectedHair() {
        return selectedHair;
    }

    public void setSelectedHair(Color selectedHair) {
        this.selectedHair = selectedHair;
    }

    public Color getSelectedSkin() {
        return selectedSkin;
    }

    public void setSelectedSkin(Color selectedSkin) {
        this.selectedSkin = selectedSkin;
    }

    public Color getSelectedShirt() {
        return selectedShirt;
    }

    public void setSelectedShirt(Color selectedShirt) {
        this.selectedShirt = selectedShirt;
    }

    public int getSpriteNum() {
        return spriteNum;
    }

    public void setSpriteNum(int spriteNum) {
        this.spriteNum = spriteNum;
    }

    public int getSpriteCounter() {
        return spriteCounter;
    }

    public void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }

    public int getPauseCommandNum() {
        return pauseCommandNum;
    }

    public void setPauseCommandNum(int pauseCommandNum) {
        this.pauseCommandNum = pauseCommandNum;
    }

    public int getUseNum() {
        return useNum;
    }

    public void setUseNum(int useNum) {
        this.useNum = useNum;
    }

    public int getInventoryNum() {
        return inventoryNum;
    }

    public void setInventoryNum(int inventoryNum) {
        this.inventoryNum = inventoryNum;
    }

    public int getDifficultyNum() {
        return difficultyNum;
    }

    public void setDifficultyNum(int difficultyNum) {
        this.difficultyNum = difficultyNum;
    }

    public int getStartRunNum() {
        return startRunNum;
    }

    public void setStartRunNum(int startRunNum) {
        this.startRunNum = startRunNum;
    }

    public int getMonsterIdx() {
        return monsterIdx;
    }

    public void setMonsterIdx(int monsterIdx) {
        this.monsterIdx = monsterIdx;
    }

    public int getWeaponNum() {
        return weaponNum;
    }

    public void setWeaponNum(int weaponNum) {
        this.weaponNum = weaponNum;
    }

    public int getOutfitterNum() {
        return outfitterNum;
    }

    public void setOutfitterNum(int outfitterNum) {
        this.outfitterNum = outfitterNum;
    }

    public int getPotionNum() {
        return potionNum;
    }

    public void setPotionNum(int potionNum) {
        this.potionNum = potionNum;
    }

    public int getUpgradeNum() {
        return upgradeNum;
    }

    public void setUpgradeNum(int upgradeNum) {
        this.upgradeNum = upgradeNum;
    }

    public int getBossRushNum() {
        return bossRushNum;
    }

    public void setBossRushNum(int bossRushNum) {
        this.bossRushNum = bossRushNum;
    }
}
