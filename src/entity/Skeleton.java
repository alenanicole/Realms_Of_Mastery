package entity;

import main.GamePanel;
import main.ScalingManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

import static java.lang.Math.*;

public class Skeleton extends Monster{

    GamePanel panel;

    public Skeleton(GamePanel panel){
        super(panel);
        this.panel = panel;
        name = "skeleton";
        getImage(name);
        setDefaultValues();
        maxHealth = 16;
        currentHealth = maxHealth;
    }
}
