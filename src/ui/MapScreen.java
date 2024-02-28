package ui;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.util.Objects;

import static javax.imageio.ImageIO.*;

public class MapScreen extends UI{

    Graphics2D graphics2D;
    GamePanel panel;

    public MapScreen(GamePanel panel) {
        super(panel);
        this.panel = panel;
    }


    public void drawFloat(int x, int y, String text, int offset){
        graphics2D.setColor(Color.black);
        graphics2D.drawString(text, x + offset, y + offset);
        graphics2D.setColor(Color.white);
        graphics2D.drawString(text, x, y);
    }

    public void draw(Graphics2D graphics2D){
        try {
            centralMap = read(Objects.requireNonNull(getClass().getResource("/maps/CentralMap_Image.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        centralMap = scalingManager.toCompatibleImage(centralMap, panel.tileSize * 15, panel.tileSize * 9);

        this.graphics2D = graphics2D;
        graphics2D.setFont(joystix);
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.setColor(background);
        graphics2D.fill(new RoundRectangle2D.Float(panel.tileSize, panel.tileSize * 2, panel.screenWidth - panel.tileSize * 2, panel.screenHeight - panel.tileSize * 4, 30, 30));

        graphics2D.getFont().deriveFont(Font.BOLD);
        String text = "MAP";
        int x = getCenteredX(text, graphics2D);
        int y = panel.tileSize * 3;
        drawFloat(x, y, text, 5);

        x = (int)(panel.tileSize * 2.5);
        y += panel.tileSize;
        graphics2D.drawImage(centralMap, x, y, null);


        graphics2D.setFont(joystix_small);
        x += panel.tileSize * 15.3;
        y += panel.tileSize * 8.5;
        graphics2D.setColor(button);
        graphics2D.fill(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize + 10, 5, 5));
        graphics2D.setColor(border);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize, panel.tileSize + 10, 5, 5));
        graphics2D.setColor(Color.white);
        graphics2D.draw(new RoundRectangle2D.Float(x, y, panel.tileSize , panel.tileSize + 10, 5, 5));

        y += panel.tileSize * .9;
        x += 10;
        text = ">";
        drawFloat(x, y, text, 3);
    }
}
