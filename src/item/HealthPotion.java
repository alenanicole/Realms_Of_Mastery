package item;

import main.GamePanel;
import main.ScalingManager;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class HealthPotion extends SuperItem {
    GamePanel panel;
    ScalingManager scalingManager = new ScalingManager();
    public HealthPotion(GamePanel panel){
        this.panel = panel;
        name = "healthPotion";
        numHeld = 0;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/items/healthPotion.png"));
            image  = scalingManager.scaleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void use(){
        panel.player.currentHealth += 2;
    }
}
