package entity;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

import static java.lang.Math.floor;
import static java.lang.Math.random;

public class Monster extends Entity{
    GamePanel panel;
    public Monster(GamePanel panel) {
        super(panel);
        this.panel = panel;
    }

    public void setDefaultValues(){
        speed = 2;
        direction = "down";
        collisionArea = new Rectangle(8, 16, 20, 20);
        collisionAreaDefaultX = collisionArea.x;
        collisionAreaDefaultY = collisionArea.y;
    }

    public void getImage(String name) {
        getImage(name, panel.tileSize, panel.tileSize);
    }

    public void getImage(String name, int width, int height){
        ScalingManager scalingManager = new ScalingManager();
        try {
            sprite_sheet = ImageIO.read(getClass().getResourceAsStream("/entity/" + name + "/sprite_sheet.png"));

            down1 = sprite_sheet.getSubimage(0, 0, panel.originalTileSize, panel.originalTileSize);
            down2 = sprite_sheet.getSubimage(16, 0, panel.originalTileSize, panel.originalTileSize);
            left1 = sprite_sheet.getSubimage(32, 0, panel.originalTileSize, panel.originalTileSize);
            left2 = sprite_sheet.getSubimage(0, 16, panel.originalTileSize, panel.originalTileSize);
            right1 = sprite_sheet.getSubimage(16, 16, panel.originalTileSize, panel.originalTileSize);
            right2 = sprite_sheet.getSubimage(32, 16, panel.originalTileSize, panel.originalTileSize);
            up1 = sprite_sheet.getSubimage(0, 32, panel.originalTileSize, panel.originalTileSize);
            up2 = sprite_sheet.getSubimage(16, 32, panel.originalTileSize, panel.originalTileSize);

            up2 = scalingManager.toCompatibleImage(up2, width, height);
            up1 = scalingManager.toCompatibleImage(up1, width, height);
            down1 = scalingManager.toCompatibleImage(down1, width, height);
            down2 = scalingManager.toCompatibleImage(down2, width, height);
            left1 = scalingManager.toCompatibleImage(left1, width, height);
            left2 = scalingManager.toCompatibleImage(left2, width, height);
            right1 = scalingManager.toCompatibleImage(right1, width, height);
            right2 = scalingManager.toCompatibleImage(right2, width, height);

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void setAction(){
        unlockAction++;

        if(unlockAction == 60) {
            int randDirection = (int) floor(random() * (3 - 0 + 1) + 0);

            switch (randDirection) {
                case 0:
                    direction = "up";
                    break;
                case 1:
                    direction = "down";
                    break;
                case 2:
                    direction = "left";
                    break;
                case 3:
                    direction = "right";
                    break;
            }

            unlockAction = 0;
        }
    }

    public void update(int idx){
        setAction();
        collision = false;
        panel.collisionManager.checkTile(this);
        panel.collisionManager.checkObject(this, false);
        panel.collisionManager.checkPlayer(this, true, idx);

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
