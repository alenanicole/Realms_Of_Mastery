package object;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Chest_Super extends SuperObject {
    ScalingManager scalingManager = new ScalingManager();
    GamePanel panel;
    public Chest_Super(GamePanel panel){
        this.panel = panel;
        name = "super_chest";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tutorial_objects/super_chest/chest_super.png"));
            image  = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
