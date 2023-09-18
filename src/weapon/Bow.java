package weapon;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Bow extends Weapon{
    ScalingManager scalingManager = new ScalingManager();
    GamePanel panel;
    public Bow(GamePanel panel){
        this.panel = panel;
        name = "bow";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/weapons/bow/bow.png"));
            image = scalingManager.scaleImage(image, panel.tileSize, panel.tileSize);
            tier1 = ImageIO.read(getClass().getResourceAsStream("/weapons/bow/tier_one.png"));
            tier1 = scalingManager.scaleImage(tier1, panel.tileSize, panel.tileSize);
            tier2 = ImageIO.read(getClass().getResourceAsStream("/weapons/bow/tier_two.png"));
            tier2 = scalingManager.scaleImage(tier2, panel.tileSize, panel.tileSize);
            tier3 = ImageIO.read(getClass().getResourceAsStream("/weapons/bow/tier_three.png"));
            tier3 = scalingManager.scaleImage(tier3, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
        equipped = true;
    }
}
