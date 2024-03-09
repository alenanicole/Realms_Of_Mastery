package questions.math;

import main.GamePanel;

import static java.lang.Math.floor;
import static java.lang.Math.random;

public class Division extends MathQuestion {
    int num1, num2;
    public Division(GamePanel panel) {
        super(panel);
    }

    public void drawTierOne(){
        num1 = panel.randGen.getRandomInteger(99, 10);
        num2 = panel.randGen.getRandomInteger(9, 2);
        panel.questionManager.setQuestion("What is " + num1 + " divided by " + num2 + "?-If there is a remainder-use the form #R#");
        if(num1 % num2 != 0) {
            panel.questionManager.setCorrectAns(String.valueOf(num1 / num2) + "R" + String.valueOf(num1 % num2));
        }else{
            panel.questionManager.setCorrectAns(String.valueOf(num1 / num2));
        }

    }

    public void drawTierTwo(){
        num1 = panel.randGen.getRandomInteger(999, 100);
        num2 = panel.randGen.getRandomInteger(9, 2);
        panel.questionManager.setQuestion("What is " + num1 + " divided by " + num2 + "?-If there is a remainder-use the form #R#");
        if(num1 % num2 != 0) {
            panel.questionManager.setCorrectAns(String.valueOf(num1 / num2) + "R" + String.valueOf(num1 % num2));
        }else{
            panel.questionManager.setCorrectAns(String.valueOf(num1 / num2));
        }
    }

    public void drawTierThree(){
        num1 = panel.randGen.getRandomInteger(9999, 1000);
        num2 = panel.randGen.getRandomInteger(9, 2);
        panel.questionManager.setQuestion("What is " + num1 + " divided by " + num2 + "?-If there is a remainder-use the form #R#");
        if(num1 % num2 != 0) {
            panel.questionManager.setCorrectAns(String.valueOf(num1 / num2) + "R" + String.valueOf(num1 % num2));
        }else{
            panel.questionManager.setCorrectAns(String.valueOf(num1 / num2));
        }
    }
}
