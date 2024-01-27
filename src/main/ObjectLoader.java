package main;

import object.*;

public class ObjectLoader {
    GamePanel panel;

    public ObjectLoader(GamePanel panel){
        this.panel = panel;
    }

    public void unloadObjects(){
        for(int i = 0; i < panel.obj.length; i++){
            panel.obj[i] = null;
        }
    }
    public void setObject(){
        panel.obj[0] = new Chest_obj(panel);
        panel.obj[0].worldX = 13 * panel.tileSize;
        panel.obj[0].worldY = 19 * panel.tileSize;

        panel.obj[1] = new Door_obj(panel);
        panel.obj[1].worldX = 11 * panel.tileSize;
        panel.obj[1].worldY = 18 * panel.tileSize;

        panel.obj[2] = new Door_obj(panel);
        panel.obj[2].worldX = 20 * panel.tileSize;
        panel.obj[2].worldY = 37 * panel.tileSize;

        panel.obj[3] = new Door_obj(panel);
        panel.obj[3].worldX = 25 * panel.tileSize;
        panel.obj[3].worldY = 28 * panel.tileSize;

        panel.obj[4] = new Chest_obj(panel);
        panel.obj[4].worldX = 19 * panel.tileSize;
        panel.obj[4].worldY = 35 * panel.tileSize;

        panel.obj[5] = new Chest_obj(panel);
        panel.obj[5].worldX = 21 * panel.tileSize;
        panel.obj[5].worldY = 35 * panel.tileSize;

        panel.obj[6] = new Door_obj(panel);
        panel.obj[6].worldX = 74 * panel.tileSize;
        panel.obj[6].worldY = 28 * panel.tileSize;

        panel.obj[7] = new Door_obj(panel);
        panel.obj[7].worldX = 51 * panel.tileSize;
        panel.obj[7].worldY = 21 * panel.tileSize;

        panel.obj[8] = new Chest_obj(panel);
        panel.obj[8].worldX = 51 * panel.tileSize;
        panel.obj[8].worldY = 19 * panel.tileSize;

        panel.obj[9] = new Door_obj(panel);
        panel.obj[9].worldX = 81 * panel.tileSize;
        panel.obj[9].worldY = 48 * panel.tileSize;

        panel.obj[10] = new Chest_obj(panel);
        panel.obj[10].worldX = 105 * panel.tileSize;
        panel.obj[10].worldY = 48 * panel.tileSize;

        panel.obj[11] = new Door_obj(panel);
        panel.obj[11].worldX = 87 * panel.tileSize;
        panel.obj[11].worldY = 79 * panel.tileSize;

        panel.obj[12] = new Chest_obj(panel);
        panel.obj[12].worldX = 87 * panel.tileSize;
        panel.obj[12].worldY = 77 * panel.tileSize;

        panel.obj[13] = new Chest_obj(panel);
        panel.obj[13].worldX = 59 * panel.tileSize;
        panel.obj[13].worldY = 67 * panel.tileSize;

        // Test chest
        panel.obj[14] = new Chest_obj(panel);
        panel.obj[14].worldX = 59 * panel.tileSize;
        panel.obj[14].worldY = 103 * panel.tileSize;
    }

    public void tutorialObjects(){
        panel.obj[0] = new PortalBL(panel);
        panel.obj[0].worldX = 76 * panel.tileSize;
        panel.obj[0].worldY = 76 * panel.tileSize;

        panel.obj[1] = new PortalBR(panel);
        panel.obj[1].worldX = 77 * panel.tileSize;
        panel.obj[1].worldY = 76 * panel.tileSize;

        panel.obj[2] = new PortalML(panel);
        panel.obj[2].worldX = 76 * panel.tileSize;
        panel.obj[2].worldY = 75 * panel.tileSize;

        panel.obj[3] = new PortalMR(panel);
        panel.obj[3].worldX = 77 * panel.tileSize;
        panel.obj[3].worldY = 75 * panel.tileSize;

        panel.obj[4] = new PortalTL(panel);
        panel.obj[4].worldX = 76 * panel.tileSize;
        panel.obj[4].worldY = 74 * panel.tileSize;

        panel.obj[5] = new PortalTR(panel);
        panel.obj[5].worldX = 77 * panel.tileSize;
        panel.obj[5].worldY = 74 * panel.tileSize;


        panel.obj[6] = new WeaponTable1(panel);
        panel.obj[6].worldX = 37 * panel.tileSize;
        panel.obj[6].worldY = 47 * panel.tileSize;

        panel.obj[7] = new WeaponTable2(panel);
        panel.obj[7].worldX = 38 * panel.tileSize;
        panel.obj[7].worldY = 47 * panel.tileSize;

        panel.obj[8] = new WeaponTable3(panel);
        panel.obj[8].worldX = 39 * panel.tileSize;
        panel.obj[8].worldY = 47 * panel.tileSize;
    }
}
