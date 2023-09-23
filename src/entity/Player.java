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

    public final int screenX;
    public final int screenY;
    public String hairColor;
    public String skinColor;
    public String shirtColor;
    public String gender;

    public int maxHealth;
    public int currentHealth;
    public volatile int tierOneDamage;
    public volatile int tierTwoDamage;
    public volatile int tierThreeDamage;

    public boolean successfulOpen;
    public boolean answered;

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
        currentHealth = 7;

        tierOneDamage = 3;
        tierTwoDamage = 5;
        tierThreeDamage = 7;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        worldX = panel.tileSize * 57;
        worldY = panel.tileSize * 105;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        ScalingManager scalingManager = new ScalingManager();
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

            up1 = scalingManager.scaleImage(up1, panel.tileSize, panel.tileSize);
            up2 = scalingManager.scaleImage(up2, panel.tileSize, panel.tileSize);
            down1 = scalingManager.scaleImage(down1, panel.tileSize, panel.tileSize);
            down2 = scalingManager.scaleImage(down2, panel.tileSize, panel.tileSize);
            left1 = scalingManager.scaleImage(left1, panel.tileSize, panel.tileSize);
            left2 = scalingManager.scaleImage(left2, panel.tileSize, panel.tileSize);
            right1 = scalingManager.scaleImage(right1, panel.tileSize, panel.tileSize);
            right2 = scalingManager.scaleImage(right2, panel.tileSize, panel.tileSize);

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

            if(worldX >= 80 * panel.tileSize && worldX <= 81 * panel.tileSize && worldY >= 37 * panel.tileSize && worldY <= 38 * panel.tileSize){
                worldX = 59 * panel.tileSize;
                worldY = 69 * panel.tileSize;
            }else if(worldX >= 59 * panel.tileSize && worldX <= 60 * panel.tileSize && worldY >= 70 * panel.tileSize && worldY <= 71 * panel.tileSize){
                worldX = 77 * panel.tileSize;
                worldY = 37 * panel.tileSize;
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
            System.out.print("Let's Fight");
            if(!panel.monster[idx].dead){
                panel.gameState = panel.fightState;
                panel.inEncounter = true;
                if(successfulOpen){
                    panel.monster[idx].dead = true;
                }
            }
        }
    }

    public void pickUpObject(int idx) {
        if(idx != 999){
            String objectName = panel.obj[idx].name;

            switch(objectName){
                case "chest":
                    try{
                        if(!panel.obj[idx].opened){
                          panel.inEncounter = true;
                          panel.gameState = panel.treasureState;
                          if(answered){
                              if(successfulOpen) {
                                  panel.obj[idx].image = ImageIO.read(getClass().getResourceAsStream("/objects/open_chest.png"));
                                  panel.obj[idx].opened = true;
                                  if (panel.ui.getDifficultyNum() == 0) {
                                      panel.items[0].numHeld += (int) Math.floor(Math.random() * (10 - 1 + 1) + 1);
                                  }else if(panel.ui.getDifficultyNum() == 1) {
                                      panel.items[0].numHeld += (int) Math.floor(Math.random() * (15 - 5 + 1) + 5);
                                  }else{
                                      panel.items[0].numHeld += (int) Math.floor(Math.random() * (20 - 10 + 1) + 10);
                                      panel.items[(int) Math.floor(Math.random() * (5 - 2 + 1) + 2)].numHeld++;
                                  }
                                  successfulOpen = false;
                              }else{
                                  panel.obj[idx].image = ImageIO.read(getClass().getResourceAsStream("/objects/locked_chest.png"));
                                  panel.obj[idx].opened = true;
                                  panel.obj[idx].collision = true;
                              }
                          }
                          answered = false;
                        }
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    break;
                case "door":
                    try{
                        if(panel.items[1].numHeld > 0 && !panel.obj[idx].opened){
                            panel.obj[idx].collision = false;
                            panel.obj[idx].image = ImageIO.read(getClass().getResourceAsStream("/objects/open_door.png"));
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
//                    ((SpeedPotion) panel.items[idx]).use();
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
