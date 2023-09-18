package questions.math;

import main.GamePanel;

public class Multiplication extends Math{

    public Multiplication(GamePanel panel) {
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

    public boolean checkAns(){
        if(Integer.valueOf(panel.ui.getAns()) == (panel.ui.getNum1() * panel.ui.getNum2())){
            panel.ui.setAlreadyDrawn(false);
            panel.ui.setAns("");
            return true;
        }

        return false;
    }
}
