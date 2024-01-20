package item;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperItem {
    public BufferedImage image;
    public String name;
    public boolean found = false;
    public boolean inUse = false;

    public int numHeld = 0;

    public int worldX, worldY;
    public Rectangle collisionArea = new Rectangle(0, 0, 48, 48);
    public int collisionAreaDefaultX = 0;
    public int collisionAreaDefaultY = 0;
    public boolean encounterOnly = false;
    public boolean adventureOnly = false;
    public int price;

    public void draw(Graphics2D graphics2D, GamePanel panel){
        int screenX = worldX - panel.player.worldX + panel.player.screenX;
        int screenY = worldY - panel.player.worldY + panel.player.screenY;

        if(worldX > panel.player.worldX - panel.player.screenX - panel.tileSize &&
                worldX < panel.player.worldX + panel.player.screenX + panel.tileSize &&
                worldY > panel.player.worldY - panel.player.screenY - panel.tileSize &&
                worldY < panel.player.worldY + panel.player.screenY + panel.tileSize){
            graphics2D.drawImage(image, screenX, screenY, null);
        }
    }

}
