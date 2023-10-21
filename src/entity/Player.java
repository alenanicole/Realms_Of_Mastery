package entity;

import main.GamePanel;
import main.KeyHandler;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel panel;
    KeyHandler keyHandler;
    ScalingManager scalingManager = new ScalingManager();
    public final int screenX;
    public final int screenY;
    public String hairColor;
    public String skinColor;
    public String shirtColor;
    public String gender;
    
    public volatile int tierOneDamage;
    public volatile int tierTwoDamage;
    public volatile int tierThreeDamage;

    public int monstersDefeated = 0;
    public int goldCollected = 0;
    public int chestsOpened = 0;
    public int potionsUsed = 0;
    public int bossesSlain = 0;
    public int rightAnswersInRow = 0;
    public int maxRightAnswersInRow = 0;
    public int rightAnswers = 0;
    public String bestCategory = "Not Available";

    public int rightFractionQuestions = 0;
    public int totalFractionQuestions = 0;
    public int rightMultiplicationQuestions = 0;
    public int totalMultiplicationQuestions = 0;
    public int rightDivisionQuestions = 0;
    public int totalDivisionQuestions = 0;
    public int rightWordProblemQuestions = 0;
    public int totalWordProblemQuestions = 0;

    public Player(GamePanel panel, KeyHandler keyHandler, String hairColor, String skinColor, String shirtColor, String gender){
        super(panel);
        this.panel = panel;
        this.keyHandler = keyHandler;

        screenX = panel.screenWidth/2 - (panel.tileSize/2);
        screenY = panel.screenHeight/2 - (panel.tileSize/2);
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.shirtColor = shirtColor;
        this.gender = gender;

        collisionArea = new Rectangle(8, 16, 20, 20);
        collisionAreaDefaultX = collisionArea.x;
        collisionAreaDefaultY = collisionArea.y;

        maxHealth = 10;
        currentHealth = 6;

        tierOneDamage = 3;
        tierTwoDamage = 5;
        tierThreeDamage = 7;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        worldX = panel.tileSize * 59;
        worldY = panel.tileSize * 59;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){

        try {
            sprite_sheet = ImageIO.read(getClass().getResourceAsStream("/player/" + gender + "/" + hairColor + "/" + skinColor + "/" + shirtColor + "/sprite_sheet.png"));

            down1 = sprite_sheet.getSubimage(0, 0, panel.originalTileSize, panel.originalTileSize);
            down2 = sprite_sheet.getSubimage(16, 0, panel.originalTileSize, panel.originalTileSize);
            left1 = sprite_sheet.getSubimage(32, 0, panel.originalTileSize, panel.originalTileSize);
            left2 = sprite_sheet.getSubimage(0, 16, panel.originalTileSize, panel.originalTileSize);
            right1 = sprite_sheet.getSubimage(16, 16, panel.originalTileSize, panel.originalTileSize);
            right2 = sprite_sheet.getSubimage(32, 16, panel.originalTileSize, panel.originalTileSize);
            up1 = sprite_sheet.getSubimage(0, 32, panel.originalTileSize, panel.originalTileSize);
            up2 = sprite_sheet.getSubimage(16, 32, panel.originalTileSize, panel.originalTileSize);

            up1 = scalingManager.toCompatibleImage(up1, panel.tileSize, panel.tileSize);
            up2 = scalingManager.toCompatibleImage(up2, panel.tileSize, panel.tileSize);
            down1 = scalingManager.toCompatibleImage(down1, panel.tileSize, panel.tileSize);
            down2 = scalingManager.toCompatibleImage(down2, panel.tileSize, panel.tileSize);
            left1 = scalingManager.toCompatibleImage(left1, panel.tileSize, panel.tileSize);
            left2 = scalingManager.toCompatibleImage(left2, panel.tileSize, panel.tileSize);
            right1 = scalingManager.toCompatibleImage(right1, panel.tileSize, panel.tileSize);
            right2 = scalingManager.toCompatibleImage(right2, panel.tileSize, panel.tileSize);

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update(int i){
        if(keyHandler.upPressed || keyHandler.downPressed || keyHandler.leftPressed || keyHandler.rightPressed){
            if(keyHandler.upPressed) {
                direction = "up";
            } else if (keyHandler.downPressed) {
                direction = "down";
            } else if (keyHandler.leftPressed) {
                direction = "left";
            } else if (keyHandler.rightPressed) {
                direction = "right";
            }

            collision = false;
            panel.collisionManager.checkTile(this);
            int objIdx = panel.collisionManager.checkObject(this, true);
            pickUpObject(objIdx);
            int itemIdx = panel.collisionManager.checkItem(this, true);
            pickUpItem(itemIdx);
            int monsterIdx = panel.collisionManager.checkEntity(this, panel.monster);
            fightMonster(monsterIdx);

            if(panel.gameState == panel.playState) {
                if (worldX >= 80 * panel.tileSize && worldX <= 81 * panel.tileSize && worldY >= 37 * panel.tileSize && worldY <= 38 * panel.tileSize) {
                    worldX = 59 * panel.tileSize;
                    worldY = 69 * panel.tileSize;
                } else if (worldX >= 59 * panel.tileSize && worldX <= 60 * panel.tileSize && worldY >= 70 * panel.tileSize && worldY <= 71 * panel.tileSize) {
                    worldX = 77 * panel.tileSize;
                    worldY = 37 * panel.tileSize;
                }
            }

            if(!collision){
                switch (direction) {
                    case "up" -> worldY -= speed;
                    case "down" -> worldY += speed;
                    case "left" -> worldX -= speed;
                    case "right" -> worldX += speed;
                }
            }

            spriteCounter++;
            if(spriteCounter > 15){
                if(spriteNum == 1){
                    spriteNum = 2;
                }else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

    }

    public void fightMonster(int idx) {
        if(idx != 999){
            if(!panel.monster[idx].dead){
                panel.fightManager.startFight(idx);
            }
        }
    }

    public void pickUpObject(int idx) {
        if(idx != 999){
            String objectName = panel.obj[idx].name;

            switch(objectName){
                case "chest":
                    if(!panel.obj[idx].opened){
                        panel.treasureManager.startTreasureCollection(idx);
                    }
                    break;
                case "door":
                    try{
                        if(panel.items[1].numHeld > 0 && !panel.obj[idx].opened){
                            panel.obj[idx].collision = false;
                            panel.obj[idx].image = ImageIO.read(getClass().getResourceAsStream("/objects/open_door.png"));
                            panel.obj[idx].image = scalingManager.toCompatibleImage(panel.obj[idx].image, panel.tileSize, panel.tileSize);
                            panel.obj[idx].opened = true;
                            panel.items[1].numHeld--;
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    public void pickUpItem(int idx) {
        if(idx != 999){
            String itemName = panel.items[idx].name;

            switch (itemName){
                case "coin":
                    panel.items[0].numHeld += 3;
                    panel.items[idx].found = true;
                    break;
                case "key":
                    panel.items[1].numHeld++;
                    panel.items[idx].found = true;
                    break;
                case "healthPotion":
                    panel.items[2].numHeld++;
                    panel.items[idx].found = true;
                    break;
                case "strengthPotion":
                    panel.items[3].numHeld++;
                    panel.items[idx].found = true;
                    break;
                case "speedPotion":
                    panel.items[4].numHeld++;
                    panel.items[idx].found = true;
                    break;
                case "rerollPotion":
                    panel.items[5].numHeld++;
                    panel.items[idx].found = true;
                    break;
            }

        }
    }

    public void draw(Graphics2D graphics2D){

        BufferedImage image = null;

        switch (direction) {
            case "up" -> {
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
            }
            case "down" -> {
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
            }
            case "left" -> {
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
            }
            case "right" -> {
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
            }
        }

        graphics2D.drawImage(image, screenX, screenY, null);

    }
}
