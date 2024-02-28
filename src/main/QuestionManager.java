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

    private boolean correct = true;

    private boolean alreadyDrawn = false;
    private int numOfAttempts = 0;
    private boolean difficultyChosen = false;

    public String currentCategory = "";

    public String[] questionTypes = {"Multiplication", "Division", "Fractions", "Word Problems"};
    public float[] percentCorrect = {0, 0, 0, 0};

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
            if(randSelector >= 1 && randSelector <= 25){
                multiplication.drawTierOne();
                currentCategory = "multiplication";
            }else if(randSelector > 25 && randSelector <= 50){
                wordProblem.drawTierOne();
                currentCategory = "wordproblem";
            }else if(randSelector > 50 && randSelector <= 75){
                division.drawTierOne();
                currentCategory = "division";
            }else if(randSelector > 75 && randSelector <= 100){
                fraction.drawTierOne();
                currentCategory = "fraction";
            }
            setAlreadyDrawn(true);
        }
    }

    public void drawTierTwo(){
        if (!isAlreadyDrawn()) {
            int randSelector = panel.randGen.getRandomInteger(100, 1);
            if(randSelector >= 1 && randSelector <= 25){
                multiplication.drawTierTwo();
                currentCategory = "multiplication";
            }else if(randSelector > 25 && randSelector <= 50){
                wordProblem.drawTierTwo();
                currentCategory = "wordproblem";
            }else if(randSelector > 50 && randSelector <= 75) {
                division.drawTierTwo();
                currentCategory = "division";
            }else if(randSelector > 75 && randSelector <= 100){
                fraction.drawTierTwo();
                currentCategory = "fraction";
            }
            setAlreadyDrawn(true);
        }
    }

    public void drawTierThree(){
        if (!isAlreadyDrawn()) {
            int randSelector = panel.randGen.getRandomInteger(100, 1);
            if(randSelector >= 1 && randSelector <= 25){
                multiplication.drawTierThree();
                currentCategory = "multiplication";
            }else if(randSelector > 25 && randSelector <= 50){
                wordProblem.drawTierThree();
                currentCategory = "wordproblem";
            }else if(randSelector > 50 && randSelector <= 75){
                division.drawTierThree();
                currentCategory = "division";
            }else if(randSelector > 75 && randSelector <= 100){
                fraction.drawTierThree();
                currentCategory = "fraction";
            }
            setAlreadyDrawn(true);
        }
    }

    public boolean checkAns(){
        boolean isCorrect = false;
        if(givenAns.equals(correctAns)){
            isCorrect = true;
            setCorrect(true);
        }else{
            setCorrect(false);
        }

        setAlreadyDrawn(false);
        setGivenAns("");
        setDifficultyChosen(false);
        return isCorrect;
    }

    public void drawTierOne(String category){
        if (!isAlreadyDrawn()) {
            switch (category){
                case "multiplication":
                    multiplication.drawTierOne();
                    currentCategory = "multiplication";
                    break;
                case "division":
                    division.drawTierOne();
                    currentCategory = "division";
                    break;
                case "fraction":
                    fraction.drawTierOne();
                    currentCategory = "fraction";
                    break;
                case "wordproblem":
                    wordProblem.drawTierOne();
                    currentCategory = "wordproblem";
                    break;
            }
            setAlreadyDrawn(true);
        }
    }

    public void drawTierTwo(String category){
        if (!isAlreadyDrawn()) {
            switch (category){
                case "multiplication":
                    multiplication.drawTierTwo();
                    currentCategory = "multiplication";
                    break;
                case "division":
                    division.drawTierTwo();
                    currentCategory = "division";
                    break;
                case "fraction":
                    fraction.drawTierTwo();
                    currentCategory = "fraction";
                    break;
                case "wordproblem":
                    wordProblem.drawTierTwo();
                    currentCategory = "wordproblem";
                    break;
            }
            setAlreadyDrawn(true);
        }
    }

    public void drawTierThree(String category){
        if (!isAlreadyDrawn()) {
            switch (category){
                case "multiplication":
                    multiplication.drawTierThree();
                    currentCategory = "multiplication";
                    break;
                case "division":
                    division.drawTierThree();
                    currentCategory = "division";
                    break;
                case "fraction":
                    fraction.drawTierThree();
                    currentCategory = "fraction";
                    break;
                case "wordproblem":
                    wordProblem.drawTierThree();
                    currentCategory = "wordproblem";
                    break;
            }
            setAlreadyDrawn(true);
        }
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

    public boolean isCorrect() {
        return correct;
    }
    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
