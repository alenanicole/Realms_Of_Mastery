package object;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class PortalBR extends SuperObject {
    ScalingManager scalingManager = new ScalingManager();
    GamePanel panel;
    public PortalBR(GamePanel panel){
        this.panel = panel;
        name = "portal";
        collision = true;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tutorial_objects/start_run/portal_br.png"));
            image  = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
