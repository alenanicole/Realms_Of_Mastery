package main;

import entity.*;

public class NPCLoader {
    GamePanel panel;
    public NPCLoader(GamePanel panel){
        this.panel = panel;
    }

    public void unloadNPCs(){
        for(int i = 0; i < panel.npcs.length; i++){
            panel.npcs[i] = null;
        }
    }

    public void loadNPCs(){
        panel.npcs[0] = new OutfitterNPC(panel);
        panel.npcs[0].worldX = (int) (76.5 * panel.tileSize);
        panel.npcs[0].worldY = 47 * panel.tileSize;

        panel.npcs[1] = new WeaponMasterNPC(panel);
        panel.npcs[1].worldX = (int) (22.5 * panel.tileSize);
        panel.npcs[1].worldY = 50 * panel.tileSize;

        panel.npcs[2] = new DoctorNPC(panel);
        panel.npcs[2].worldX = (int) (96.5 * panel.tileSize);
        panel.npcs[2].worldY = 50 * panel.tileSize;

        panel.npcs[3] = new ArtificerNPC(panel);
        panel.npcs[3].worldX = (int) (40.5 * panel.tileSize);
        panel.npcs[3].worldY = 44 * panel.tileSize;

        panel.npcs[4] = new BossRushNPC(panel);
        panel.npcs[4].worldX = (int) (40.5 * panel.tileSize);
        panel.npcs[4].worldY = 63 * panel.tileSize;

    }
}
