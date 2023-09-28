package questions.math;

import main.GamePanel;

public class Fraction extends MathQuestion{

    int num1, num2, denom;

    int denomOptions[] = {2, 3, 4, 5, 6, 8, 10, 12, 25, 100};
    public Fraction(GamePanel panel) {
        super(panel);
    }

    public void drawTierOne(){
        denom = denomOptions[panel.randGen.getRandomInteger(denomOptions.length, 0)];
        num1 = panel.randGen.getRandomInteger(denom, 1);
        num2 = panel.randGen.getRandomInteger(denom, 1);

        int rand = panel.randGen.getRandomInteger(100, 1);
        if(rand >= 1 && rand <= 33) {
            panel.questionManager.setQuestion(num1 + "/" + denom + " = " + num2 + "/" + denom + "?-True (T) or False (F)");
            if(num1 == num2) {
                panel.questionManager.setCorrectAns("T");
            }else{
                panel.questionManager.setCorrectAns("F");
            }
        }else if(rand > 33 && rand <= 66){
            panel.questionManager.setQuestion(num1 + "/" + denom + " < " + num2 + "/" + denom + "?-True (T) or False (F)");
            if(num1 < num2) {
                panel.questionManager.setCorrectAns("T");
            }else{
                panel.questionManager.setCorrectAns("F");
            }
        }else{
            panel.questionManager.setQuestion(num1 + "/" + denom + " > " + num2 + "/" + denom + "?-True (T) or False (F)");
            if(num1 > num2) {
                panel.questionManager.setCorrectAns("T");
            }else{
                panel.questionManager.setCorrectAns("F");
            }
        }

    }

    public void drawTierTwo(){
        denom = denomOptions[panel.randGen.getRandomInteger(denomOptions.length, 0)];
        num1 = panel.randGen.getRandomInteger(denom, 1);
        num2 = panel.randGen.getRandomInteger(denom, 1);

        if(panel.randGen.getRandomInteger(100, 1) > 50 ) {
            panel.questionManager.setQuestion("What is " + num1 + "/" + denom + " plus " + num2 + "/" + denom + "?-Enter your answer as ??/??");
            panel.questionManager.setCorrectAns(String.valueOf((num1 + num2) + "/" + denom));
        }else{
            panel.questionManager.setQuestion("What is " + num1 + "/" + denom + " minus " + num2 + "/" + denom + "?-Enter your answer as ??/??");
            panel.questionManager.setCorrectAns(String.valueOf((num1 + num2) + "/" + denom));
        }

    }

    public void drawTierThree(){
        denom = denomOptions[panel.randGen.getRandomInteger(denomOptions.length, 0)];
        num1 = panel.randGen.getRandomInteger(denom, 1);
        num2 = panel.randGen.getRandomInteger(10, 1);

        panel.questionManager.setQuestion("What is " + num1 + "/" + denom + " times " + num2 + "?-Enter your answer as ??/??");
        panel.questionManager.setCorrectAns(String.valueOf((num1 * num2) + "/" + denom));
    }
}
