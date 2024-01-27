package object;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class WeaponTable3 extends SuperObject {
    ScalingManager scalingManager = new ScalingManager();
    GamePanel panel;
    public WeaponTable3(GamePanel panel){
        this.panel = panel;
        name = "weapontable3";
        collision = true;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tutorial_objects/weapons/weapon-table-3.png"));
            image  = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
