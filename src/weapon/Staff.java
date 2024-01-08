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
        price = 300;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/weapons/staff/staff.png"));
            image = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
            tier1 = ImageIO.read(getClass().getResourceAsStream("/weapons/staff/tier_one.png"));
            tier1 = scalingManager.toCompatibleImage(tier1, panel.tileSize * 2, panel.tileSize * 2);
            tier2 = ImageIO.read(getClass().getResourceAsStream("/weapons/staff/tier_two.png"));
            tier2 = scalingManager.toCompatibleImage(tier2, panel.tileSize * 2, panel.tileSize * 2);
            tier3 = ImageIO.read(getClass().getResourceAsStream("/weapons/staff/tier_three.png"));
            tier3 = scalingManager.toCompatibleImage(tier3, panel.tileSize * 2, panel.tileSize * 2);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
