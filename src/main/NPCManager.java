package main;

import entity.Boss;
import entity.Outfitter;

public class NPCManager {
    GamePanel panel;
    public NPCManager(GamePanel panel){
        this.panel = panel;
    }

    public void unloadNPCs(){
        for(int i = 0; i < panel.npcs.length; i++){
            panel.npcs[i] = null;
        }
    }

    public void loadNPCs(){
        panel.npcs[0] = new Outfitter(panel);
        panel.npcs[0].worldX = 57* panel.tileSize;
        panel.npcs[0].worldY = 59 * panel.tileSize;
    }
}
