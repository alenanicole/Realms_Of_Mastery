package item;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class RerollPotion extends SuperItem{
    ScalingManager scalingManager = new ScalingManager();
    GamePanel panel;
    public RerollPotion(GamePanel panel){
        this.panel = panel;
        name = "rerollPotion";
        numHeld = 0;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/items/rerollPotion.png"));
            image  = scalingManager.scaleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
        encounterOnly = true;
    }
}
