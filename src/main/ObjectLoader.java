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

//        panel.obj[2] = new Key_obj();
//        panel.obj[2].worldX = 69 * panel.tileSize;
//        panel.obj[2].worldY = 52 * panel.tileSize;
//
//        panel.obj[3] = new Door_obj();
//        panel.obj[3].worldX = 28 * panel.tileSize;
//        panel.obj[3].worldY = 150 * panel.tileSize;
//
//        panel.obj[4] = new Key_obj();
//        panel.obj[4].worldX = 30 * panel.tileSize;
//        panel.obj[4].worldY = 148 * panel.tileSize;
    }
}
