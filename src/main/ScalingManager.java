package main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ScalingManager {
    BufferedImage scaledImage;
    Graphics2D graphics2D;

    public BufferedImage scaleImage(BufferedImage image, int width, int height){
        scaledImage = new BufferedImage(width, height, image.getType());
        graphics2D = scaledImage.createGraphics();
        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();

        return scaledImage;
    }
}
