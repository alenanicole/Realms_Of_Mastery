package main;

import object.Chest_obj;
import object.Door_obj;

public class ObjectLoader {
    GamePanel panel;

    public ObjectLoader(GamePanel panel){
        this.panel = panel;
    }
    
    public void setObject(){
        panel.obj[0] = new Chest_obj();
        panel.obj[0].worldX = 13 * panel.tileSize;
        panel.obj[0].worldY = 19 * panel.tileSize;

        panel.obj[1] = new Door_obj();
        panel.obj[1].worldX = 11 * panel.tileSize;
        panel.obj[1].worldY = 18 * panel.tileSize;

        panel.obj[2] = new Door_obj();
        panel.obj[2].worldX = 20 * panel.tileSize;
        panel.obj[2].worldY = 37 * panel.tileSize;

        panel.obj[3] = new Door_obj();
        panel.obj[3].worldX = 25 * panel.tileSize;
        panel.obj[3].worldY = 28 * panel.tileSize;

        panel.obj[4] = new Chest_obj();
        panel.obj[4].worldX = 19 * panel.tileSize;
        panel.obj[4].worldY = 36 * panel.tileSize;

        panel.obj[5] = new Chest_obj();
        panel.obj[5].worldX = 21 * panel.tileSize;
        panel.obj[5].worldY = 36 * panel.tileSize;

        panel.obj[6] = new Door_obj();
        panel.obj[6].worldX = 74 * panel.tileSize;
        panel.obj[6].worldY = 28 * panel.tileSize;

        panel.obj[7] = new Door_obj();
        panel.obj[7].worldX = 51 * panel.tileSize;
        panel.obj[7].worldY = 21 * panel.tileSize;

        panel.obj[8] = new Chest_obj();
        panel.obj[8].worldX = 51 * panel.tileSize;
        panel.obj[8].worldY = 19 * panel.tileSize;

        panel.obj[9] = new Door_obj();
        panel.obj[9].worldX = 81 * panel.tileSize;
        panel.obj[9].worldY = 48 * panel.tileSize;

        panel.obj[10] = new Chest_obj();
        panel.obj[10].worldX = 105 * panel.tileSize;
        panel.obj[10].worldY = 48 * panel.tileSize;
    }
}
