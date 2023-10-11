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
            image = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
            tier1 = ImageIO.read(getClass().getResourceAsStream("/weapons/bow/tier_one.png"));
            tier1 = scalingManager.toCompatibleImage(tier1, panel.tileSize * 2, panel.tileSize * 2);
            tier2 = ImageIO.read(getClass().getResourceAsStream("/weapons/bow/tier_two.png"));
            tier2 = scalingManager.toCompatibleImage(tier2, panel.tileSize * 2, panel.tileSize * 2);
            tier3 = ImageIO.read(getClass().getResourceAsStream("/weapons/bow/tier_three.png"));
            tier3 = scalingManager.toCompatibleImage(tier3, panel.tileSize * 2, panel.tileSize * 2);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
