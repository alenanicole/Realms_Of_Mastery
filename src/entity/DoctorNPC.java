package entity;

import main.GamePanel;

public class DoctorNPC extends NPC{
    GamePanel panel;
    public DoctorNPC(GamePanel panel) {
        super(panel);
        this.panel = panel;
        name = "doctor";
        getImage(name);
        setDefaultValues();
    }
}
