package tile;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class TileManager {
    GamePanel panel;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel panel){
        this.panel = panel;
        tile = new Tile[10];
        mapTileNum = new int[panel.maxWorldCol][panel.maxWorldRow];
        getTileImage();
        loadMap("/maps/MainMap.txt");
    }

    public void getTileImage(){
            loadImage(0, "grass", false, false);
            loadImage(1, "water", true, true);
            loadImage(2, "wall", true, true);
            loadImage(3, "path", false, true);
            loadImage(4, "dirt", false, true);
            loadImage(5, "tree", true, true);
            loadImage(6, "floor", false, false);
            loadImage(7, "collision_grass", true, true);
            loadImage(8, "sand", false, true);


    }

    public void loadImage(int idx, String fileName, boolean collision, boolean collisionNPC){
        ScalingManager scalingManager = new ScalingManager();
        try {
            tile[idx] = new Tile();
            tile[idx].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + fileName + ".png"));
            tile[idx].collision = collision;
            tile[idx].collisionNPC = collisionNPC;
            tile[idx].image = scalingManager.toCompatibleImage(tile[idx].image, panel.tileSize, panel.tileSize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadMap(String map) {
        try {
            InputStream is = getClass().getResourceAsStream(map);
            assert is != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader((is)));

            int col = 0;
            int row = 0;

            while (col < panel.maxWorldCol && row < panel.maxWorldRow) {
                String line = reader.readLine();

                while (col < panel.maxWorldCol) {
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == panel.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }

            reader.close();
        }catch (Exception e){

        }
    }

    public void draw(Graphics2D graphics2D){

        int leftMax = (panel.player.worldX - panel.player.screenX - panel.tileSize)/48;
        int rightMax = (panel.player.worldX + panel.player.screenX + panel.tileSize)/48;
        int upMax = (panel.player.worldY - panel.player.screenY - panel.tileSize)/48;
        int downMax = (panel.player.worldY + panel.player.screenY + panel.tileSize)/48;

        for(int lr = leftMax; lr <= rightMax; lr++){
            for(int ud = upMax; ud <= downMax; ud++){
                int tileNum = mapTileNum[lr][ud];
                if(tileNum != 9) {
                    int worldX = lr * panel.tileSize;
                    int worldY = ud * panel.tileSize;
                    int screenX = worldX - panel.player.worldX + panel.player.screenX;
                    int screenY = worldY - panel.player.worldY + panel.player.screenY;

                    graphics2D.drawImage(tile[tileNum].image, screenX, screenY, null);
                }
            }
        }
    }
}
