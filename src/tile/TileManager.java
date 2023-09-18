package tile;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel panel;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel panel){
        this.panel = panel;
        tile = new Tile[10];
        mapTileNum = new int[panel.maxWorldCol][panel.maxWorldRow];
        getTileImage();
        loadMap("/maps/Map.txt");
    }

    public void getTileImage(){
            loadImage(0, "grass", false);
            loadImage(1, "water", true);
            loadImage(2, "wall", true);
            loadImage(3, "path", false);
            loadImage(4, "sand", false);
            loadImage(5, "tree", true);
            loadImage(6, "floor", false);
            loadImage(7, "collision_grass", true);
            loadImage(8, "dirt", false);
    }

    public void loadImage(int idx, String fileName, boolean collision){
        ScalingManager scalingManager = new ScalingManager();
        try {
            tile[idx] = new Tile();
            tile[idx].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + fileName + ".png"));
            tile[idx].collision = collision;
            tile[idx].image = scalingManager.scaleImage(tile[idx].image, panel.tileSize, panel.tileSize);
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
                int worldX = lr * panel.tileSize;
                int worldY = ud * panel.tileSize;
                int screenX = worldX - panel.player.worldX + panel.player.screenX;
                int screenY = worldY - panel.player.worldY + panel.player.screenY;

                graphics2D.drawImage(tile[tileNum].image, screenX, screenY, null);
            }
        }
    }
}
