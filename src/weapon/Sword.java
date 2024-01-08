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
        price = 50;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/weapons/sword/sword.png"));
            image = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
            tier1 = ImageIO.read(getClass().getResourceAsStream("/weapons/sword/tier_one.png"));
            tier1 = scalingManager.toCompatibleImage(tier1, panel.tileSize * 2, panel.tileSize * 2);
            tier2 = ImageIO.read(getClass().getResourceAsStream("/weapons/sword/tier_two.png"));
            tier2 = scalingManager.toCompatibleImage(tier2, panel.tileSize * 2, panel.tileSize * 2);
            tier3 = ImageIO.read(getClass().getResourceAsStream("/weapons/sword/tier_three.png"));
            tier3 = scalingManager.toCompatibleImage(tier3, panel.tileSize * 2, panel.tileSize * 2);

        }catch (IOException e){
            e.printStackTrace();
        }
        equipped = false;
        available = false;
    }
}
