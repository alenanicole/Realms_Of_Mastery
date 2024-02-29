package object;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class UpgradeTable1 extends SuperObject {
    ScalingManager scalingManager = new ScalingManager();
    GamePanel panel;
    public UpgradeTable1(GamePanel panel){
        this.panel = panel;
        name = "upgradetable";
        collision = true;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tutorial_objects/upgrades/upgradeTable1.png"));
            image  = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
