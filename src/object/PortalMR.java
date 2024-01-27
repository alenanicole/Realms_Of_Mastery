package object;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class PortalMR extends SuperObject {
    ScalingManager scalingManager = new ScalingManager();
    GamePanel panel;
    public PortalMR(GamePanel panel){
        this.panel = panel;
        name = "portal";
        collision = true;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tutorial_objects/start_run/portal_mr.png"));
            image  = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
