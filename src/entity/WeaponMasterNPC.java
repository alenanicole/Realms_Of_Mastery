package entity;

import main.GamePanel;

public class WeaponMasterNPC extends NPC{
    GamePanel panel;
    public WeaponMasterNPC(GamePanel panel) {
        super(panel);
        this.panel = panel;
        name = "weaponmaster";
        getImage(name);
        setDefaultValues();
    }
}
