package entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public GamePanel panel;
    public int worldX, worldY;
    public volatile int speed;

    public BufferedImage sprite_sheet, up1, up2, down1, down2, left1, left2, right1, right2;

    public BufferedImage up1Hair, up2Hair, down1Hair, down2Hair, left1Hair, left2Hair, right1Hair, right2Hair;

    public BufferedImage up1Skin, up2Skin, down1Skin, down2Skin, left1Skin, left2Skin, right1Skin, right2Skin;

    public BufferedImage up1Shirt, up2Shirt, down1Shirt, down2Shirt, left1Shirt, left2Shirt, right1Shirt, right2Shirt;

    public BufferedImage up1Hat, up2Hat, down1Hat, down2Hat, left1Hat, left2Hat, right1Hat, right2Hat;

    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle collisionArea;
    public int collisionAreaDefaultX, collisionAreaDefaultY;
    public boolean collision = false;
    public String name = "";
    public boolean dead = false;

    public int maxHealth;
    public int currentHealth;
    public int unlockAction = 0;

    public Entity(GamePanel panel){
        this.panel = panel;
    }

    public void setAction(){}
    public void update(int i){
    }

    public void draw(Graphics2D graphics2D, GamePanel panel){

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

        int screenX = worldX - panel.player.worldX + panel.player.screenX;
        int screenY = worldY - panel.player.worldY + panel.player.screenY;

        if(worldX > panel.player.worldX - panel.player.screenX - panel.tileSize &&
                worldX < panel.player.worldX + panel.player.screenX + panel.tileSize &&
                worldY > panel.player.worldY - panel.player.screenY - panel.tileSize &&
                worldY < panel.player.worldY + panel.player.screenY + panel.tileSize ){
            graphics2D.drawImage(image, screenX, screenY, null);
        }

    }
}
