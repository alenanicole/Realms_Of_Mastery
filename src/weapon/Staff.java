package weapon;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Staff extends Weapon{
    GamePanel panel;
    ScalingManager scalingManager = new ScalingManager();
    public Staff(GamePanel panel){
        this.panel = panel;
        name = "staff";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/weapons/staff/staff.png"));
            image = scalingManager.scaleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
