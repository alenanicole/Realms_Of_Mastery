package object;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class BRPortalBR extends SuperObject {
    ScalingManager scalingManager = new ScalingManager();
    GamePanel panel;
    public BRPortalBR(GamePanel panel){
        this.panel = panel;
        name = "brportal";
        collision = true;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tutorial_objects/br_portal/portal_br_br.png"));
            image  = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
