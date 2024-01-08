package item;

import main.GamePanel;

public class StrengthThread extends Thread implements Runnable{
    GamePanel panel;
    public StrengthThread(GamePanel panel){
        this.panel = panel;

    }
    @Override
    public void run()
    {
        if(panel.numOfFight < 0){
            panel.numOfFight = 0;
        }
        synchronized (this) {
            panel.player.tierOneDamage += 2;
            panel.player.tierTwoDamage += 2;
            panel.player.tierThreeDamage += 2;
            panel.items[3].inUse = true;
            panel.numOfFight += 3;

            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            panel.player.tierOneDamage -= 2;
            panel.player.tierTwoDamage -= 2;
            panel.player.tierThreeDamage -= 2;
            panel.items[3].inUse = false;

            try {
                this.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
