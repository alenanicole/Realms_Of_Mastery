package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldX, worldY;
    public volatile int speed;

    public BufferedImage sprite_sheet, up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle collisionArea;
    public int collisionAreaDefaultX, collisionAreaDefaultY;
    public boolean collision = false;
}
