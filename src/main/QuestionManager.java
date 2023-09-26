package main;

import questions.math.Multiplication;
import questions.math.WordProblem;

import static java.lang.Math.floor;
import static java.lang.Math.random;

public class QuestionManager {
    GamePanel panel;
    Multiplication multiplication;
    WordProblem wordProblem;

    private String question = "";
    private String correctAns = "";
    private String givenAns = "";

    public QuestionManager(GamePanel panel){
        this.panel = panel;
        initializeTypes();
    }

    public void initializeTypes(){
        multiplication = new Multiplication(panel);
        wordProblem = new WordProblem(panel);
    }

    public void intitializeQuestions(){
        wordProblem.initializeProblems("tier_one");
        wordProblem.initializeProblems("tier_two");
        wordProblem.initializeProblems("tier_three");
    }

    public void drawTierOne(){
        if (!panel.ui.isAlreadyDrawn()) {
            int randSelector = (int) floor(random() * (100 - 1 + 1) + 1);
            if(randSelector >= 1 && randSelector <= 50){
                multiplication.drawTierOne();
            }else if(randSelector > 50 && randSelector <= 100){
                wordProblem.drawTierOne();
            }
            panel.ui.setAlreadyDrawn(true);
        }
    }

    public void drawTierTwo(){
        if (!panel.ui.isAlreadyDrawn()) {
            int randSelector = (int) floor(random() * (100 - 1 + 1) + 1);
            if(randSelector >= 1 && randSelector <= 50){
                multiplication.drawTierTwo();
            }else if(randSelector > 50 && randSelector <= 100){
                wordProblem.drawTierTwo();
            }
            panel.ui.setAlreadyDrawn(true);
        }
    }

    public void drawTierThree(){
        if (!panel.ui.isAlreadyDrawn()) {
            int randSelector = (int) floor(random() * (100 - 1 + 1) + 1);
            if(randSelector >= 1 && randSelector <= 50){
                multiplication.drawTierThree();
            }else if(randSelector > 50 && randSelector <= 100){
                wordProblem.drawTierThree();
            }
            panel.ui.setAlreadyDrawn(true);
        }
    }

    public boolean checkAns(){
        boolean isCorrect = false;
        if(givenAns.equals(correctAns)){
            isCorrect = true;
        }

        panel.ui.setAlreadyDrawn(false);
        setGivenAns("");
        panel.ui.difficultyChosen = false;
        return isCorrect;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public String getGivenAns() {
        return givenAns;
    }

    public void setGivenAns(String givenAns) {
        this.givenAns = givenAns;
    }
}
