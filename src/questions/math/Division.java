package questions.math;

import main.GamePanel;

public class Division extends Math{
    public Division(GamePanel panel) {
        super(panel);
    }

    public void drawTierOne(){
        if (!panel.ui.isAlreadyDrawn()) {
            panel.ui.setNum1((int) java.lang.Math.floor(java.lang.Math.random() * (10 - 1 + 1) + 1));
            panel.ui.setNum2((int) java.lang.Math.floor(java.lang.Math.random() * (10 - 1 + 1) + 1));
            panel.ui.setAlreadyDrawn(true);
        }
    }

    public void drawTierTwo(){
        if (!panel.ui.isAlreadyDrawn()) {
            panel.ui.setNum1((int) java.lang.Math.floor(java.lang.Math.random() * (99 - 10 + 1) + 1));
            panel.ui.setNum2((int) java.lang.Math.floor(java.lang.Math.random() * (10 - 1 + 1) + 1));
            panel.ui.setAlreadyDrawn(true);
        }
    }

    public void drawTierThree(){
        if (!panel.ui.isAlreadyDrawn()) {
            panel.ui.setNum1((int) java.lang.Math.floor(java.lang.Math.random() * (99 - 10 + 1) + 10));
            panel.ui.setNum2((int) java.lang.Math.floor(java.lang.Math.random() * (99 - 10 + 1) + 10));
            panel.ui.setAlreadyDrawn(true);
        }
    }
}
