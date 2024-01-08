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
//        panel.npcs[0] = new OutfitterNPC(panel);
//        panel.npcs[0].worldX = 57 * panel.tileSize;
//        panel.npcs[0].worldY = 59 * panel.tileSize;

        panel.npcs[1] = new WeaponMasterNPC(panel);
        panel.npcs[1].worldX = 38 * panel.tileSize;
        panel.npcs[1].worldY = 44 * panel.tileSize;

//        panel.npcs[2] = new DoctorNPC(panel);
//        panel.npcs[2].worldX = 62 * panel.tileSize;
//        panel.npcs[2].worldY = 59 * panel.tileSize;
//
//        panel.npcs[3] = new ArtificerNPC(panel);
//        panel.npcs[3].worldX = 61 * panel.tileSize;
//        panel.npcs[3].worldY = 59 * panel.tileSize;
//
//        panel.npcs[4] = new BossRushNPC(panel);
//        panel.npcs[4].worldX = 60 * panel.tileSize;
//        panel.npcs[4].worldY = 59 * panel.tileSize;

    }
}
