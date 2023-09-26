package questions.math;

import main.GamePanel;

import static java.lang.Math.*;

public class Multiplication extends MathQuestion {

    int num1, num2;
    public Multiplication(GamePanel panel) {
        super(panel);
    }

    public void drawTierOne(){
        num1 = ((int) floor(random() * (10 - 1 + 1) + 1));
        num2 = ((int) floor(random() * (10 - 1 + 1) + 1));
        panel.questionManager.setQuestion("What is " + num1 + " times " + num2 + "?");
        panel.questionManager.setCorrectAns(String.valueOf(num1 * num2));

    }

    public void drawTierTwo(){
        num1 = ((int) floor(random() * (99 - 10 + 1) + 10));
        num2 = ((int) floor(random() * (10 - 1 + 1) + 1));
        panel.questionManager.setQuestion("What is " + num1 + " times " + num2 + "?");
        panel.questionManager.setCorrectAns(String.valueOf(num1 * num2));

    }

    public void drawTierThree(){
        num1 = ((int) floor(random() * (99 - 10 + 1) + 10));
        num2 = ((int) floor(random() * (99 - 10 + 1) + 10));
        panel.questionManager.setQuestion("What is " + num1 + " times " + num2 + "?");
        panel.questionManager.setCorrectAns(String.valueOf(num1 * num2));
    }
}
