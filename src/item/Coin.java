package item;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Coin extends SuperItem{
    ScalingManager scalingManager = new ScalingManager();
    GamePanel panel;
    public Coin(GamePanel panel){
        this.panel = panel;
        name = "coin";
        numHeld = 500;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/items/coin.png"));
            image  = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
