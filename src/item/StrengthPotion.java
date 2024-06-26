package item;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class StrengthPotion extends SuperItem{
    GamePanel panel;
    ScalingManager scalingManager = new ScalingManager();
    public StrengthThread strengthThread;
    public StrengthPotion(GamePanel panel){
        this.panel = panel;
        name = "strengthPotion";
        numHeld = 0;
        price = 30;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/items/strengthPotion.png"));
            image  = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void use(){
        panel.player.potionsUsed++;
        strengthThread = new StrengthThread(panel);
        strengthThread.start();
    }
}
