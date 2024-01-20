package main;

import outfit.*;
import upgrades.HealthUpgrade;
import upgrades.SpeedUpgrade;
import upgrades.StrengthUpgrade;

public class UpgradeLoader {
    GamePanel panel;
    public UpgradeLoader(GamePanel panel){
        this.panel = panel;
        intializeUpgrades();
    }
    public void intializeUpgrades(){
        panel.upgrades[0] = new HealthUpgrade();
        panel.upgrades[1] = new StrengthUpgrade();
        panel.upgrades[2] = new SpeedUpgrade();
    }
}
