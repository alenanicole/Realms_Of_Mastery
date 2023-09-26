package questions.math;

import main.GamePanel;

import java.io.*;

import java.util.Vector;

import static java.lang.Math.floor;
import static java.lang.Math.random;

public class WordProblem extends MathQuestion {

    public Vector<String>  tierOneProblems = new Vector<String>();
    public Vector<Integer>  tierOneAnswers = new Vector<Integer>();

    public Vector<String>  tierTwoProblems = new Vector<String>();
    public Vector<Integer>  tierTwoAnswers = new Vector<Integer>();

    public Vector<String>  tierThreeProblems = new Vector<String>();
    public Vector<Integer>  tierThreeAnswers = new Vector<Integer>();
    int randomSelect;
    public WordProblem(GamePanel panel) {
        super(panel);
    }

    public void initializeProblems(String tier) {
        int lineNum = 1;
        InputStream is = getClass().getResourceAsStream("/questions/word_problems/" + tier + ".txt");
        assert is != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader((is)));

        String line;
        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (tier.equals("tier_one")){
                if (lineNum % 2 != 0) {
                    tierOneProblems.add(line);
                } else {
                    tierOneAnswers.add(Integer.valueOf(line));
                }
            }else if(tier.equals("tier_two")){
                if (lineNum % 2 != 0) {
                    tierTwoProblems.add(line);
                } else {
                    tierTwoAnswers.add(Integer.valueOf(line));
                }
            }else{
                if (lineNum % 2 != 0) {
                    tierThreeProblems.add(line);
                } else {
                    tierThreeAnswers.add(Integer.valueOf(line));
                }
            }

            lineNum++;
        }

    }

    public void drawTierOne(){
        randomSelect = panel.randGen.getRandomInteger(tierOneProblems.size(), 0);
        panel.questionManager.setQuestion(tierOneProblems.get(randomSelect));
        panel.questionManager.setCorrectAns(String.valueOf(tierOneAnswers.get(randomSelect)));
    }

    public void drawTierTwo(){
        randomSelect = panel.randGen.getRandomInteger(tierTwoProblems.size(), 0);
        panel.questionManager.setQuestion(tierTwoProblems.get(randomSelect));
        panel.questionManager.setCorrectAns(String.valueOf(tierTwoAnswers.get(randomSelect)));

    }

    public void drawTierThree(){
        randomSelect = panel.randGen.getRandomInteger(tierThreeProblems.size(), 0);
        panel.questionManager.setQuestion(tierThreeProblems.get(randomSelect));
        panel.questionManager.setCorrectAns(String.valueOf(tierThreeAnswers.get(randomSelect)));

    }

}
