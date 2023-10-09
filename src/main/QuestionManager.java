package main;

import questions.math.Division;
import questions.math.Fraction;
import questions.math.Multiplication;
import questions.math.WordProblem;

import static java.lang.Math.floor;
import static java.lang.Math.random;

public class QuestionManager {
    GamePanel panel;
    Multiplication multiplication;
    WordProblem wordProblem;
    Division division;
    Fraction fraction;
    private String question = "";
    private String correctAns = "";
    private String givenAns = "";

    private boolean alreadyDrawn = false;
    private int numOfAttempts = 0;
    private boolean difficultyChosen = false;

    public QuestionManager(GamePanel panel){
        this.panel = panel;
        initializeTypes();
    }

    public void initializeTypes(){
        multiplication = new Multiplication(panel);
        division = new Division(panel);
        wordProblem = new WordProblem(panel);
        fraction = new Fraction(panel);
    }

    public void intitializeQuestions(){
        wordProblem.initializeProblems("tier_one");
        wordProblem.initializeProblems("tier_two");
        wordProblem.initializeProblems("tier_three");
    }

    public void drawTierOne(){
        if (!isAlreadyDrawn()) {
            int randSelector = panel.randGen.getRandomInteger(100, 1);
//            randSelector = 78;
            if(randSelector >= 1 && randSelector <= 25){
                multiplication.drawTierOne();
            }else if(randSelector > 25 && randSelector <= 50){
                wordProblem.drawTierOne();
            }else if(randSelector > 50 && randSelector <= 75){
                division.drawTierOne();
            }else if(randSelector > 75 && randSelector <= 100){
                fraction.drawTierOne();
            }
            setAlreadyDrawn(true);
        }
    }

    public void drawTierTwo(){
        if (!isAlreadyDrawn()) {
            int randSelector = panel.randGen.getRandomInteger(100, 1);
//            randSelector = 78;
            if(randSelector >= 1 && randSelector <= 25){
                multiplication.drawTierTwo();
            }else if(randSelector > 25 && randSelector <= 50){
                wordProblem.drawTierTwo();
            }else if(randSelector > 50 && randSelector <= 75) {
                division.drawTierTwo();
            }else if(randSelector > 75 && randSelector <= 100){
                fraction.drawTierTwo();
            }
            setAlreadyDrawn(true);
        }
    }

    public void drawTierThree(){
        if (!isAlreadyDrawn()) {
            int randSelector = panel.randGen.getRandomInteger(100, 1);
//            randSelector = 78;
            if(randSelector >= 1 && randSelector <= 25){
                multiplication.drawTierThree();
            }else if(randSelector > 25 && randSelector <= 50){
                wordProblem.drawTierThree();
            }else if(randSelector > 50 && randSelector <= 75){
                division.drawTierThree();
            }else if(randSelector > 75 && randSelector <= 100){
                fraction.drawTierThree();
            }
            setAlreadyDrawn(true);
        }
    }

    public boolean checkAns(){
        boolean isCorrect = false;
        if(givenAns.equals(correctAns)){
            isCorrect = true;
        }

        setAlreadyDrawn(false);
        setGivenAns("");
        setDifficultyChosen(false);
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

    public boolean isAlreadyDrawn() {
        return alreadyDrawn;
    }

    public void setAlreadyDrawn(boolean alreadyDrawn) {
        this.alreadyDrawn = alreadyDrawn;
    }


    public int getNumOfAttempts() {
        return numOfAttempts;
    }

    public void setNumOfAttempts(int numOfAttempts) {
        this.numOfAttempts = numOfAttempts;
    }

    public boolean isDifficultyChosen() {
        return difficultyChosen;
    }

    public void setDifficultyChosen(boolean difficultyChosen) {
        this.difficultyChosen = difficultyChosen;
    }
}
