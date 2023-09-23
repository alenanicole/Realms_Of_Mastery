package main;

import entity.Ghost;
import entity.Skeleton;
import entity.Slime;
import entity.Zombie;
import item.*;

import static java.lang.Math.floor;
import static java.lang.Math.random;

public class MonsterLoader {

    GamePanel panel;
    int randSelect, randX, randY;
    int tileNum;
    public MonsterLoader(GamePanel panel){
        this.panel = panel;
    }

    public void intializeMonsters(){
        panel.monster[0] = new Skeleton(panel);
        panel.monster[0].worldX = 87 * panel.tileSize;
        panel.monster[0].worldY = 28 * panel.tileSize;

        for(int i = 1; i < panel.monster.length; i++){
            randSelect = (int) floor(random() * (3 - 0 + 1) + 0);
            switch (randSelect) {
                case 0 -> panel.monster[i] = new Skeleton(panel);
                case 1 -> panel.monster[i] = new Zombie(panel);
                case 2 -> panel.monster[i] = new Ghost(panel);
                case 3 -> panel.monster[i] = new Slime(panel);
            }

            do{
                randX = (int) floor(random() * (119 + 1) + 0);
                randY = (int) floor(random() * (119 + 1) + 0);
                tileNum = panel.tileManager.mapTileNum[randX][randY];
            }while(tileNum == 9 || panel.tileManager.tile[tileNum].collision);

            panel.monster[i].worldX = randX * panel.tileSize;
            panel.monster[i].worldY = randY * panel.tileSize;
        }
    }
}
