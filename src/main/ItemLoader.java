package main;

import item.*;
import weapon.Bow;
import weapon.Staff;
import weapon.Sword;

import static java.lang.Math.floor;
import static java.lang.Math.random;

public class ItemLoader {

    GamePanel panel;
    int randSelect, randX, randY;
    int tileNum;

    public ItemLoader(GamePanel panel){
        this.panel = panel;
    }

    public void unloadItems(){
        panel.items[1].numHeld = 1;
        panel.items[2].numHeld = 0;
        panel.items[3].numHeld = 0;
        panel.items[4].numHeld = 0;
        panel.items[5].numHeld = 0;

        for(int i = 6; i < panel.items.length; i++){
            panel.items[i] = null;
        }
    }

    public void intializeStaticItems(){
        panel.items[0] = new Coin(panel);
        panel.items[1] = new Key(panel);
        panel.items[2] = new HealthPotion(panel);
        panel.items[3] = new StrengthPotion(panel);
        panel.items[4] = new SpeedPotion(panel);
        panel.items[5] = new RerollPotion(panel);

        panel.weapons[0] = new Sword(panel);
        panel.weapons[1] = new Staff(panel);
        panel.weapons[2] = new Bow(panel);

    }
    public void initializeItems(){

        // Distribute around map

        for(int i = 6; i < panel.items.length; i++){
            if(i < 10){
                panel.items[i] = new Key(panel);
            }else {
                randSelect = (int) floor(random() * (4 - 0 + 1) + 0);
                switch (randSelect) {
                    case 0 -> panel.items[i] = new Coin(panel);
                    case 1 -> panel.items[i] = new HealthPotion(panel);
                    case 2 -> panel.items[i] = new StrengthPotion(panel);
                    case 3 -> panel.items[i] = new SpeedPotion(panel);
                    case 4 -> panel.items[i] = new RerollPotion(panel);
                }
            }

            do{
                randX = (int) floor(random() * (119 + 1) + 0);
                randY = (int) floor(random() * (119 + 1) + 0);
                tileNum = panel.tileManager.mapTileNum[randX][randY];
            }while(tileNum == 9 || panel.tileManager.tile[tileNum].collision);

            panel.items[i].worldX = randX * panel.tileSize;
            panel.items[i].worldY = randY * panel.tileSize;
        }

    }

}
