package object;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class WeaponTable1 extends SuperObject {
    ScalingManager scalingManager = new ScalingManager();
    GamePanel panel;
    public WeaponTable1(GamePanel panel){
        this.panel = panel;
        name = "weapontable";
        collision = true;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tutorial_objects/weapons/weapon-table-1.png"));
            image  = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
