package object;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Chest_obj extends SuperObject {
    ScalingManager scalingManager = new ScalingManager();
    GamePanel panel;
    public Chest_obj(GamePanel panel){
        this.panel = panel;
        name = "chest";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
            image  = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
