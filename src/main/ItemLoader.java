package main;

import item.*;
import weapon.Bow;
import weapon.Staff;
import weapon.Sword;

public class ItemLoader {

    GamePanel panel;

    public ItemLoader(GamePanel panel){
        this.panel = panel;
    }

    public void initializeItems(){

        panel.items[0] = new Coin(panel);
        panel.items[1] = new Key(panel);
        panel.items[2] = new HealthPotion(panel);
        panel.items[3] = new StrengthPotion(panel);
        panel.items[4] = new SpeedPotion(panel);
        panel.items[5] = new RerollPotion(panel);

        panel.items[6] = new HealthPotion(panel);
        panel.items[6].worldX = 69 * panel.tileSize;
        panel.items[6].worldY = 56 * panel.tileSize;

        panel.items[7] = new StrengthPotion(panel);
        panel.items[7].worldX = 97 * panel.tileSize;
        panel.items[7].worldY = 40 * panel.tileSize;

        panel.items[8] = new SpeedPotion(panel);
        panel.items[8].worldX = 69 * panel.tileSize;
        panel.items[8].worldY = 54 * panel.tileSize;

        panel.items[9] = new Key(panel);
        panel.items[9].worldX = 69 * panel.tileSize;
        panel.items[9].worldY = 52 * panel.tileSize;

        panel.weapons[0] = new Sword(panel);
        panel.weapons[1] = new Staff(panel);
        panel.weapons[2] = new Bow(panel);

    }

}
