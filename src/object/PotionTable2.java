package object;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class PotionTable2 extends SuperObject {
    ScalingManager scalingManager = new ScalingManager();
    GamePanel panel;
    public PotionTable2(GamePanel panel){
        this.panel = panel;
        name = "potiontable";
        collision = true;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tutorial_objects/potions/potionTable2.png"));
            image  = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
