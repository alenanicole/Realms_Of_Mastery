package item;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Key extends SuperItem{
    ScalingManager scalingManager = new ScalingManager();
    GamePanel panel;

    public Key(GamePanel panel){
        this.panel = panel;
        name = "key";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/items/key.png"));
            image  = scalingManager.scaleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}