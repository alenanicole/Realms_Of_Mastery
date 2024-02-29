package object;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class UpgradeTable3 extends SuperObject {
    ScalingManager scalingManager = new ScalingManager();
    GamePanel panel;
    public UpgradeTable3(GamePanel panel){
        this.panel = panel;
        name = "upgradetable";
        collision = true;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tutorial_objects/upgrades/upgradeTable3.png"));
            image  = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
