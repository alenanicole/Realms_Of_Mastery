package main;

import java.awt.*;

public class LoadingThread extends Thread implements Runnable{
    GamePanel panel;
    int state;
    public LoadingThread(GamePanel panel){
        this.panel = panel;
    }

    public void run(int state){
        this.state = state;
        start();
    }
    @Override
    public void run()
    {
        synchronized (this) {
            panel.ui.loadingScreen.draw();
            if(state == 0){
                loadRun();
            }else if(state == 1){
                reset();
            }

            synchronized (panel.gameThread){
                panel.gameThread.notifyAll();
            }

            try {
                this.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void loadRun(){
        System.out.println(System.currentTimeMillis());
        panel.npcLoader.unloadNPCs();
        panel.tileManager.loadMap("/maps/Dungeon_1.txt");
        panel.player.worldX = panel.tileSize * 57;
        panel.player.worldY = panel.tileSize * 105;
        panel.objectLoader.unloadObjects();
        panel.objectLoader.setObject();
        panel.itemLoader.initializeItems();
        panel.monsterLoader.intializeMonsters();
        System.out.println(System.currentTimeMillis());
    }

    public void reset(){
        panel.numOfFight = 0;
        panel.tileManager.loadMap("/maps/Map.txt");
        panel.objectLoader.unloadObjects();
        panel.itemLoader.unloadItems();
        panel.monsterLoader.unloadMonsters();
        panel.npcLoader.loadNPCs();
        panel.player.currentHealth = panel.player.maxHealth;

        panel.player.worldX = 59 * panel.tileSize;
        panel.player.worldY = 59 * panel.tileSize;
    }

}
