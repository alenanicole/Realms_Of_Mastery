package main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ScalingManager {
    BufferedImage scaledImage;
    Graphics2D graphics2D;
    GamePanel panel;

    public BufferedImage scaleImage(BufferedImage image, int width, int height){
        scaledImage = new BufferedImage(width, height, image.getType());
        graphics2D = scaledImage.createGraphics();
        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();

        return scaledImage;
    }

//    https://stackoverflow.com/questions/29067108/how-to-use-compatibleimage-to-make-drawing-images-faster-in-java2d
    public BufferedImage toCompatibleImage(BufferedImage image, int width, int height) {

        image = scaleImage(image, width, height);

        GraphicsConfiguration gfx_config = GraphicsEnvironment
                .getLocalGraphicsEnvironment().getDefaultScreenDevice()
                .getDefaultConfiguration();

        if (image.getColorModel().equals(gfx_config.getColorModel())) {

            return image;
        }

        BufferedImage new_image = gfx_config.createCompatibleImage(
                image.getWidth(), image.getHeight(), Transparency.TRANSLUCENT);

        Graphics2D g2d = (Graphics2D) new_image.getGraphics();

        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        return new_image;
    }
}
