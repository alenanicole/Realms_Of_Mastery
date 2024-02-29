package object;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ClosetDoor extends SuperObject {
    ScalingManager scalingManager = new ScalingManager();
    GamePanel panel;
    public ClosetDoor(GamePanel panel){
        this.panel = panel;
        name = "closetdoor";
        collision = true;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tutorial_objects/outfitter/closet_door.png"));
            image  = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
