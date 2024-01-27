package object;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class PortalBL extends SuperObject {
    ScalingManager scalingManager = new ScalingManager();
    GamePanel panel;
    public PortalBL(GamePanel panel){
        this.panel = panel;
        name = "portal";
        collision = true;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tutorial_objects/start_run/portal_bl.png"));
            image  = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
