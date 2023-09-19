package questions.math;

import main.GamePanel;

import static java.lang.Math.*;

public class Multiplication extends MathQuestion {

    public Multiplication(GamePanel panel) {
        super(panel);
    }

    public void drawTierOne(){
        if (!panel.ui.isAlreadyDrawn()) {
            panel.ui.setNum1((int) floor(random() * (10 - 1 + 1) + 1));
            panel.ui.setNum2((int) floor(random() * (10 - 1 + 1) + 1));
            panel.ui.setAlreadyDrawn(true);
        }
    }

    public void drawTierTwo(){
        if (!panel.ui.isAlreadyDrawn()) {
            panel.ui.setNum1((int) floor(random() * (99 - 10 + 1) + 1));
            panel.ui.setNum2((int) floor(random() * (10 - 1 + 1) + 1));
            panel.ui.setAlreadyDrawn(true);
        }
    }

    public void drawTierThree(){
        if (!panel.ui.isAlreadyDrawn()) {
            panel.ui.setNum1((int) floor(random() * (99 - 10 + 1) + 10));
            panel.ui.setNum2((int) floor(random() * (99 - 10 + 1) + 10));
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
