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
    }

    public void setDefaultValues(){
        worldX = panel.tileSize * 59;
        worldY = panel.tileSize * 59;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        try {
            // OUTLINE
            sprite_sheet = ImageIO.read(getClass().getResourceAsStream("/player/outline/" + gender + ".png"));

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

            // HAIR
            sprite_sheet = ImageIO.read(getClass().getResourceAsStream("/player/hair/" + gender + "/" + hairColor + ".png"));

            down1Hair = sprite_sheet.getSubimage(0, 0, panel.originalTileSize, panel.originalTileSize);
            down2Hair = sprite_sheet.getSubimage(16, 0, panel.originalTileSize, panel.originalTileSize);
            left1Hair = sprite_sheet.getSubimage(32, 0, panel.originalTileSize, panel.originalTileSize);
            left2Hair = sprite_sheet.getSubimage(0, 16, panel.originalTileSize, panel.originalTileSize);
            right1Hair = sprite_sheet.getSubimage(16, 16, panel.originalTileSize, panel.originalTileSize);
            right2Hair = sprite_sheet.getSubimage(32, 16, panel.originalTileSize, panel.originalTileSize);
            up1Hair = sprite_sheet.getSubimage(0, 32, panel.originalTileSize, panel.originalTileSize);
            up2Hair = sprite_sheet.getSubimage(16, 32, panel.originalTileSize, panel.originalTileSize);

            up1Hair = scalingManager.toCompatibleImage(up1Hair, panel.tileSize, panel.tileSize);
            up2Hair = scalingManager.toCompatibleImage(up2Hair, panel.tileSize, panel.tileSize);
            down1Hair = scalingManager.toCompatibleImage(down1Hair, panel.tileSize, panel.tileSize);
            down2Hair = scalingManager.toCompatibleImage(down2Hair, panel.tileSize, panel.tileSize);
            left1Hair = scalingManager.toCompatibleImage(left1Hair, panel.tileSize, panel.tileSize);
            left2Hair = scalingManager.toCompatibleImage(left2Hair, panel.tileSize, panel.tileSize);
            right1Hair = scalingManager.toCompatibleImage(right1Hair, panel.tileSize, panel.tileSize);
            right2Hair = scalingManager.toCompatibleImage(right2Hair, panel.tileSize, panel.tileSize);

            //SKIN
            sprite_sheet = ImageIO.read(getClass().getResourceAsStream("/player/skin/" + gender + "/" + skinColor + ".png"));

            down1Skin = sprite_sheet.getSubimage(0, 0, panel.originalTileSize, panel.originalTileSize);
            down2Skin = sprite_sheet.getSubimage(16, 0, panel.originalTileSize, panel.originalTileSize);
            left1Skin = sprite_sheet.getSubimage(32, 0, panel.originalTileSize, panel.originalTileSize);
            left2Skin = sprite_sheet.getSubimage(0, 16, panel.originalTileSize, panel.originalTileSize);
            right1Skin = sprite_sheet.getSubimage(16, 16, panel.originalTileSize, panel.originalTileSize);
            right2Skin = sprite_sheet.getSubimage(32, 16, panel.originalTileSize, panel.originalTileSize);
            up1Skin = sprite_sheet.getSubimage(0, 32, panel.originalTileSize, panel.originalTileSize);
            up2Skin = sprite_sheet.getSubimage(16, 32, panel.originalTileSize, panel.originalTileSize);

            up1Skin = scalingManager.toCompatibleImage(up1Skin, panel.tileSize, panel.tileSize);
            up2Skin = scalingManager.toCompatibleImage(up2Skin, panel.tileSize, panel.tileSize);
            down1Skin = scalingManager.toCompatibleImage(down1Skin, panel.tileSize, panel.tileSize);
            down2Skin = scalingManager.toCompatibleImage(down2Skin, panel.tileSize, panel.tileSize);
            left1Skin = scalingManager.toCompatibleImage(left1Skin, panel.tileSize, panel.tileSize);
            left2Skin = scalingManager.toCompatibleImage(left2Skin, panel.tileSize, panel.tileSize);
            right1Skin = scalingManager.toCompatibleImage(right1Skin, panel.tileSize, panel.tileSize);
            right2Skin = scalingManager.toCompatibleImage(right2Skin, panel.tileSize, panel.tileSize);

            //SHIRT
            sprite_sheet = ImageIO.read(getClass().getResourceAsStream("/player/shirt/" + shirtColor + ".png"));

            down1Shirt = sprite_sheet.getSubimage(0, 0, panel.originalTileSize, panel.originalTileSize);
            down2Shirt = sprite_sheet.getSubimage(16, 0, panel.originalTileSize, panel.originalTileSize);
            left1Shirt = sprite_sheet.getSubimage(32, 0, panel.originalTileSize, panel.originalTileSize);
            left2Shirt = sprite_sheet.getSubimage(0, 16, panel.originalTileSize, panel.originalTileSize);
            right1Shirt = sprite_sheet.getSubimage(16, 16, panel.originalTileSize, panel.originalTileSize);
            right2Shirt = sprite_sheet.getSubimage(32, 16, panel.originalTileSize, panel.originalTileSize);
            up1Shirt = sprite_sheet.getSubimage(0, 32, panel.originalTileSize, panel.originalTileSize);
            up2Shirt = sprite_sheet.getSubimage(16, 32, panel.originalTileSize, panel.originalTileSize);

            up1Shirt = scalingManager.toCompatibleImage(up1Shirt, panel.tileSize, panel.tileSize);
            up2Shirt = scalingManager.toCompatibleImage(up2Shirt, panel.tileSize, panel.tileSize);
            down1Shirt = scalingManager.toCompatibleImage(down1Shirt, panel.tileSize, panel.tileSize);
            down2Shirt = scalingManager.toCompatibleImage(down2Shirt, panel.tileSize, panel.tileSize);
            left1Shirt = scalingManager.toCompatibleImage(left1Shirt, panel.tileSize, panel.tileSize);
            left2Shirt = scalingManager.toCompatibleImage(left2Shirt, panel.tileSize, panel.tileSize);
            right1Shirt = scalingManager.toCompatibleImage(right1Shirt, panel.tileSize, panel.tileSize);
            right2Shirt = scalingManager.toCompatibleImage(right2Shirt, panel.tileSize, panel.tileSize);


            // OVERLAY ALL
            up1 = overlayImages(up1Skin,  up1);
            up2 = overlayImages(up2Skin,  up2);
            down1 = overlayImages(down1Skin,  down1);
            down2 = overlayImages(down2Skin,  down2);
            left1 = overlayImages(left1Skin,  left1);
            left2 = overlayImages(left2Skin,  left2);
            right1 = overlayImages(right1Skin,  right1);
            right2 = overlayImages(right2Skin,  right2);

            up1 = overlayImages(up1Shirt,  up1);
            up2 = overlayImages(up2Shirt,  up2);
            down1 = overlayImages(down1Shirt,  down1);
            down2 = overlayImages(down2Shirt,  down2);
            left1 = overlayImages(left1Shirt,  left1);
            left2 = overlayImages(left2Shirt,  left2);
            right1 = overlayImages(right1Shirt,  right1);
            right2 = overlayImages(right2Shirt,  right2);

            up1 = overlayImages(up1Hair,  up1);
            up2 = overlayImages(up2Hair,  up2);
            down1 = overlayImages(down1Hair,  down1);
            down2 = overlayImages(down2Hair,  down2);
            left1 = overlayImages(left1Hair,  left1);
            left2 = overlayImages(left2Hair,  left2);
            right1 = overlayImages(right1Hair,  right1);
            right2 = overlayImages(right2Hair,  right2);

            //Make copy to add hat
            up1Hat = copyImage(up1);
            up2Hat = copyImage(up2);
            down1Hat = copyImage(down1);
            down2Hat = copyImage(down2);
            left1Hat = copyImage(left1);
            left2Hat = copyImage(left2);
            right1Hat = copyImage(right1);
            right2Hat = copyImage(right2);

            up1Hat = overlayImages(panel.outfits[0].up1,  up1Hat);
            up2Hat = overlayImages(panel.outfits[0].up2,  up2Hat);
            down1Hat = overlayImages(panel.outfits[0].down1,  down1Hat);
            down2Hat = overlayImages(panel.outfits[0].down2,  down2Hat);
            left1Hat = overlayImages(panel.outfits[0].left1,  left1Hat);
            left2Hat = overlayImages(panel.outfits[0].left2,  left2Hat);
            right1Hat = overlayImages(panel.outfits[0].right1,  right1Hat);
            right2Hat = overlayImages(panel.outfits[0].right2,  right2Hat);

            if(panel.outfits[0].equipped) {
                up1 = up1Hat;
                up2 = up2Hat;
                down1 = down1Hat;
                down2 = down2Hat;
                left1 = left1Hat;
                left2 = left2Hat;
                right1 = right1Hat;
                right2 = right2Hat;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static BufferedImage copyImage(BufferedImage source){
        BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        Graphics g = b.getGraphics();
        g.drawImage(source, 0, 0, null);
        g.dispose();
        return b;
    }

    public static BufferedImage overlayImages(BufferedImage fgImage, BufferedImage bgImage) {
        Graphics2D g = bgImage.createGraphics();

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g.drawImage(bgImage, 0, 0, null);

        g.drawImage(fgImage, 0, 0, null);
        g.dispose();
        return bgImage;
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
            objectInteract(objIdx);
            int itemIdx = panel.collisionManager.checkItem(this, true);
            pickUpItem(itemIdx);
            int monsterIdx = panel.collisionManager.checkEntity(this, panel.monster);
            fightMonster(monsterIdx);
            int NPCIdx = panel.collisionManager.checkEntity(this, panel.npcs);
            visitShop(NPCIdx);

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

    private void visitShop(int idx) {
        if(idx != 999){
            switch (idx) {
                case 1:
                    panel.gameState = panel.weaponStoreState;


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

    public void objectInteract(int idx) {
        if(idx != 999){
            String objectName = panel.obj[idx].name;

            switch(objectName){
                case "portal":
                    panel.gameState = panel.startRunState;
                    break;
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
