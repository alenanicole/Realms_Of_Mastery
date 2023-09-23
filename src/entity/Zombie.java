package entity;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

import static java.lang.Math.floor;
import static java.lang.Math.random;

public class Zombie extends Monster{

    GamePanel panel;

    public Zombie(GamePanel panel){
        super(panel);
        this.panel = panel;
        name = "zombie";
        getImage(name);
        setDefaultValues();
    }

}
