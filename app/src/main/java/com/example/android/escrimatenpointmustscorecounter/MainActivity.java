package com.example.android.escrimatenpointmustscorecounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

// The 10-point must system is a scoring system wherein both players (one in Blue Armor, the other in Red) start with 10 points each per round
// When a player gets a foul or a disarm the player gets -1 or when warned gets -0.5
// A bonus may be granted by the judge depending on the execution or technique
// There are 3 rounds per match and the end all scores are tallied. And a maximum of 30 points may be received at the end of the match.
// the scores cannot exceed 10 points per round. If in the scoring it does, the score is reverted back to 10 points.

public class MainActivity extends AppCompatActivity {
    double redScore = 10;
    double blueScore = 10;
    double foulDeductionRed = -1;
    double foulDeductionBlue = -1;
    double warningRed = -0.5;
    double warningBlue = -0.5;
    double disarmDeductionRed = -1;
    double disarmDeductionBlue = -1;
    double bonusRed = 1;
    double bonusBlue = 1;
    double totalRed;
    double totalBlue;
    double redScoreRoundOne;
    double blueScoreRoundOne;
    double redScoreRoundTwo;
    double blueScoreRoundTwo;
    double redScoreRoundThree;
    double blueScoreRoundThree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForRed(redScore);
        displayForBlue(blueScore);
    }


    /**
     * This method is called when foul button for red is clicked
     */
    public void foulDeductionRed(View view) {
        redScore = redScore + foulDeductionRed;
        displayForRed(redScore);
    }

    /**s pressed
     * This method is called when warning button for red is clicked
     */
    public void warningRed(View view) {
        redScore = redScore + warningRed;
        displayForRed(redScore);
    }

    /**
     * This method is called when disarm button for red is clicked
     */
    public void disarmDeductionRed(View view) {
        redScore = redScore + disarmDeductionRed;
        displayForRed(redScore);
    }

    /**
     * This method is called when bonus button for red is clicked
     */
    public void bonusRed(View view) {
        redScore = redScore + bonusRed;
        if (redScore > 10) {
            displayForRed(10);
        }
        displayForRed(redScore);
    }

    /**
     * This method is called when foul button for blue is clicked
     */
    public void foulDeductionBlue(View view) {
        blueScore = blueScore + foulDeductionBlue;
        displayForBlue(blueScore);
    }
    /**
     * This method is called when warning button for blue is clicked
     */
    public void warningBlue(View view) {
        blueScore = blueScore + warningBlue;
        displayForBlue(blueScore);
    }

    /**
     * This method is called when disarm button for blue is clicked
     */
    public void disarmDeductionBlue(View view) {
        blueScore = blueScore + disarmDeductionBlue;
        displayForBlue(blueScore);
    }

    /**
     * This method is called when bonus button for blue is clicked
     */
    public void bonusBlue(View view) {
        blueScore = blueScore + bonusBlue;
        displayForBlue(blueScore);
    }

    /**
     * This method is called when 1st Round button is clicked
     */
    public void roundOneWinner(View view) {
        displayForRed(10);
        displayForBlue(10);
        redScoreRoundOne = redScore;
        if (redScore > 10) {
            redScoreRoundOne = 10;
        }
        blueScoreRoundOne = blueScore;
        if (blueScore > 10) {
            blueScoreRoundOne=10;
        }
        displayRoundOneWinner(redScoreRoundOne,blueScoreRoundOne);
        redScore = 10;
        blueScore = 10;
    }

    /**
     * This method is called when 2nd Round button is clicked
     */
    public void roundTwoWinner(View view) {
        displayForRed(10);
        displayForBlue(10);
        redScoreRoundTwo = redScore;
        if (redScore > 10) {
            redScoreRoundTwo = 10;
        }
        blueScoreRoundTwo = blueScore;
        if (blueScore > 10) {
            blueScoreRoundTwo=10;
        }
        displayRoundTwoWinner(redScoreRoundTwo,blueScoreRoundTwo);
        redScore = 10;
        blueScore = 10;
    }

    /**
     * This method is called when 3rd Round button is clicked
     */
    public void roundThreeWinner(View view) {
        displayForRed(10);
        displayForBlue(10);
        redScoreRoundThree = redScore;
        if (redScore > 10) {
            redScoreRoundThree=10;
        }
        blueScoreRoundThree = blueScore;
        if (blueScore > 10) {
            blueScoreRoundOne=10;
        }
        displayRoundThreeWinner(redScoreRoundThree,blueScoreRoundThree);
        redScore = 10;
        blueScore = 10;
    }

    /**
     * This method is called when Total button is clicked (
     */
    public void total(View view) {
        totalRed = redScoreRoundOne + redScoreRoundTwo + redScoreRoundThree;
        totalBlue = blueScoreRoundOne +blueScoreRoundTwo + blueScoreRoundThree;
        displayTotal(totalRed, totalBlue);
    }
    /**
     * Displays the given score for Red Armor.
     */
    public void displayForRed(double score) {
        TextView scoreView = (TextView) findViewById(R.id.red_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Blue Armor.
     */

    public void displayForBlue(double score) {
        TextView scoreView = (TextView) findViewById(R.id.blue_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for 1st Round.
     */
    public void displayRoundOneWinner(double redScore, double blueScore) {
        TextView firstRoundRedScore = (TextView) findViewById(R.id.first_round_red_score);
        firstRoundRedScore.setText(String.valueOf(redScore));
        TextView firstRoundBlueScore = (TextView) findViewById(R.id.first_round_blue_score);
        firstRoundBlueScore.setText(String.valueOf(blueScore));
    }

    /**
     * Displays the given score for 2nd Round.
     */
    public void displayRoundTwoWinner(double redScore, double blueScore) {
        TextView secondRoundRedScore = (TextView) findViewById(R.id.second_round_red_score);
        secondRoundRedScore.setText(String.valueOf(redScore));
        TextView secondRoundBlueScore = (TextView) findViewById(R.id.second_round_blue_score);
        secondRoundBlueScore.setText(String.valueOf(blueScore));
    }

    /**
     * Displays the given score for 3rd Round.
     */
    public void displayRoundThreeWinner(double redScore, double blueScore) {
        TextView thirdRoundRedScore = (TextView) findViewById(R.id.third_round_red_score);
        thirdRoundRedScore.setText(String.valueOf(redScore));
        TextView thirdRoundBlueScore = (TextView) findViewById(R.id.third_round_blue_score);
        thirdRoundBlueScore.setText(String.valueOf(blueScore));
    }

    /**
     * Displays the given score for Total Round.
     */
    public void displayTotal(double redScore, double blueScore) {
        TextView totalRed = (TextView) findViewById(R.id.red_score);
        totalRed.setText(String.valueOf(redScore));
        TextView totalBlue = (TextView) findViewById(R.id.blue_score);
        totalBlue.setText(String.valueOf(blueScore));
    }

    public void reset (View view){
        redScore=0;
        blueScore=0;
        redScoreRoundOne=0;
        blueScoreRoundOne=0;
        redScoreRoundTwo=0;
        blueScoreRoundTwo=0;
        redScoreRoundThree=0;
        blueScoreRoundThree=0;

        displayRoundOneWinner( redScoreRoundOne, blueScoreRoundOne);
        displayRoundTwoWinner(redScoreRoundTwo,blueScoreRoundTwo);
        displayRoundThreeWinner(redScoreRoundThree, blueScoreRoundThree);
        displayForRed(redScore);
        displayForBlue(blueScore);

    }
}