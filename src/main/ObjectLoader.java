package main;

import object.*;

import java.util.Arrays;

public class ObjectLoader {
    GamePanel panel;

    public ObjectLoader(GamePanel panel){
        this.panel = panel;
    }

    public void unloadObjects(){
        Arrays.fill(panel.obj, null);
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

    public void centralMapObjects(){
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
        panel.obj[6].worldX = (int) (21.5 * panel.tileSize);
        panel.obj[6].worldY = 52 * panel.tileSize;

        panel.obj[7] = new WeaponTable2(panel);
        panel.obj[7].worldX = (int) (22.5 * panel.tileSize);
        panel.obj[7].worldY = 52 * panel.tileSize;

        panel.obj[8] = new WeaponTable3(panel);
        panel.obj[8].worldX = (int) (23.5 * panel.tileSize);
        panel.obj[8].worldY = 52 * panel.tileSize;


        panel.obj[9] = new PotionTable1(panel);
        panel.obj[9].worldX = (int) (95 * panel.tileSize);
        panel.obj[9].worldY = 52 * panel.tileSize;

        panel.obj[10] = new PotionTable2(panel);
        panel.obj[10].worldX = (int) (96 * panel.tileSize);
        panel.obj[10].worldY = 52 * panel.tileSize;

        panel.obj[11] = new PotionTable3(panel);
        panel.obj[11].worldX = (int) (97 * panel.tileSize);
        panel.obj[11].worldY = 52 * panel.tileSize;

        panel.obj[12] = new PotionTable4(panel);
        panel.obj[12].worldX = (int) (98 * panel.tileSize);
        panel.obj[12].worldY = 52 * panel.tileSize;

        panel.obj[13] = new UpgradeTable1(panel);
        panel.obj[13].worldX = 41 * panel.tileSize;
        panel.obj[13].worldY = (int) (45.5 * panel.tileSize);

        panel.obj[14] = new UpgradeTable2(panel);
        panel.obj[14].worldX = 41 * panel.tileSize;
        panel.obj[14].worldY = (int) (46.5 * panel.tileSize);

        panel.obj[15] = new UpgradeTable3(panel);
        panel.obj[15].worldX = 41 * panel.tileSize;
        panel.obj[15].worldY = (int) (47.5 * panel.tileSize);

        panel.obj[16] = new Closet(panel);
        panel.obj[16].worldX = 75 * panel.tileSize;
        panel.obj[16].worldY = (int) (43 * panel.tileSize);

        panel.obj[17] = new ClosetDoor(panel);
        panel.obj[17].worldX = 75 * panel.tileSize;
        panel.obj[17].worldY = (int) (44 * panel.tileSize);

        panel.obj[18] = new Closet(panel);
        panel.obj[18].worldX = 76 * panel.tileSize;
        panel.obj[18].worldY = (int) (43 * panel.tileSize);

        panel.obj[19] = new ClosetDoor(panel);
        panel.obj[19].worldX = 76 * panel.tileSize;
        panel.obj[19].worldY = (int) (44 * panel.tileSize);

        panel.obj[20] = new Closet(panel);
        panel.obj[20].worldX = 77 * panel.tileSize;
        panel.obj[20].worldY = (int) (43 * panel.tileSize);

        panel.obj[21] = new ClosetDoor(panel);
        panel.obj[21].worldX = 77 * panel.tileSize;
        panel.obj[21].worldY = (int) (44 * panel.tileSize);

        panel.obj[22] = new Closet(panel);
        panel.obj[22].worldX = 78 * panel.tileSize;
        panel.obj[22].worldY = (int) (43 * panel.tileSize);

        panel.obj[23] = new ClosetDoor(panel);
        panel.obj[23].worldX = 78 * panel.tileSize;
        panel.obj[23].worldY = (int) (44 * panel.tileSize);

        panel.obj[24] = new Closet(panel);
        panel.obj[24].worldX = 79 * panel.tileSize;
        panel.obj[24].worldY = (int) (43 * panel.tileSize);

        panel.obj[25] = new ClosetDoor(panel);
        panel.obj[25].worldX = 79 * panel.tileSize;
        panel.obj[25].worldY = (int) (44 * panel.tileSize);

        panel.obj[26] = new Closet(panel);
        panel.obj[26].worldX = 80 * panel.tileSize;
        panel.obj[26].worldY = (int) (43 * panel.tileSize);

        panel.obj[27] = new ClosetDoor(panel);
        panel.obj[27].worldX = 80 * panel.tileSize;
        panel.obj[27].worldY = (int) (44 * panel.tileSize);

        panel.obj[28] = new BRPortalBL(panel);
        panel.obj[28].worldX = 40 * panel.tileSize;
        panel.obj[28].worldY = 66 * panel.tileSize;

        panel.obj[29] = new BRPortalBR(panel);
        panel.obj[29].worldX = 41 * panel.tileSize;
        panel.obj[29].worldY = 66 * panel.tileSize;

        panel.obj[30] = new BRPortalML(panel);
        panel.obj[30].worldX = 40 * panel.tileSize;
        panel.obj[30].worldY = 65 * panel.tileSize;

        panel.obj[31] = new BRPortalMR(panel);
        panel.obj[31].worldX = 41 * panel.tileSize;
        panel.obj[31].worldY = 65 * panel.tileSize;

        panel.obj[32] = new BRPortalTL(panel);
        panel.obj[32].worldX = 40 * panel.tileSize;
        panel.obj[32].worldY = 64 * panel.tileSize;

        panel.obj[33] = new BRPortalTR(panel);
        panel.obj[33].worldX = 41 * panel.tileSize;
        panel.obj[33].worldY = 64 * panel.tileSize;
    }
}
