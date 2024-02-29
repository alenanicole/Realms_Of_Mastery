package object;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Closet extends SuperObject {
    ScalingManager scalingManager = new ScalingManager();
    GamePanel panel;
    public Closet(GamePanel panel){
        this.panel = panel;
        name = "closet";
        collision = true;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tutorial_objects/outfitter/closet.png"));
            image  = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
