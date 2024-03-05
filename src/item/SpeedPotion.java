package item;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SpeedPotion extends SuperItem{
    GamePanel panel;
    ScalingManager scalingManager = new ScalingManager();
    public SpeedPotion(GamePanel panel){
        this.panel = panel;
        name = "speedPotion";
        numHeld = 0;
        price = 15;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/items/speedPotion.png"));
            image  = scalingManager.toCompatibleImage(image, panel.tileSize, panel.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
        adventureOnly = true;
    }

    public void use(){
        panel.player.potionsUsed++;

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                panel.player.currentSpeed = panel.player.speed + 2;
                inUse = true;

                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                panel.player.currentSpeed = panel.player.speed;
                inUse = false;
            }
        }).start();
    }
}
