package item;

import main.GamePanel;
import main.ScalingManager;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class HealthPotion extends SuperItem {
    GamePanel panel;
    ScalingManager scalingManager = new ScalingManager();
    public HealthPotion(GamePanel panel){
        this.panel = panel;
        name = "healthPotion";
        numHeld = 0;
        price = 15;
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/items/healthPotion.png")));
            image  = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void use(){
        panel.player.potionsUsed++;
        panel.player.currentHealth += 2;
    }
}
