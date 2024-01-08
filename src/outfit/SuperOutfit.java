package outfit;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SuperOutfit {
    GamePanel panel;
    public BufferedImage image;
    public String name;
    public boolean available = false;
    public boolean equipped = false;
    public int price = 0;
    public BufferedImage sprite_sheet, up1, up2, down1, down2, left1, left2, right1, right2;

    public SuperOutfit(GamePanel panel){
        this.panel = panel;
    }
    public void getImage(String name, int width, int height){
        ScalingManager scalingManager = new ScalingManager();
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/outfit/" + name + "/" + name + ".png"));
        }catch(IOException e) {
            e.printStackTrace();
        }

        if(name == "hat") {
            try {
                sprite_sheet = ImageIO.read(getClass().getResourceAsStream("/outfit/" + name + "/sprite_sheet.png"));

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

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
