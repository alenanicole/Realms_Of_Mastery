package object;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Door_obj extends SuperObject {
    ScalingManager scalingManager = new ScalingManager();
    GamePanel panel;
    public Door_obj(GamePanel panel){
        this.panel = panel;
        name = "door";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
            image  = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }

        collision = true;
    }
}