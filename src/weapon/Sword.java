package weapon;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Sword extends Weapon{
    ScalingManager scalingManager = new ScalingManager();
    GamePanel panel;
    public Sword(GamePanel panel){
        this.panel = panel;
        name = "sword";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/weapons/sword/sword.png"));
            image = scalingManager.scaleImage(image, panel.tileSize, panel.tileSize);

        }catch (IOException e){
            e.printStackTrace();
        }
//        equipped = true;
    }
}
