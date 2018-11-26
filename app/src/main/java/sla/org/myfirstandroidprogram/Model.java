package sla.org.myfirstandroidprogram;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Model {
    private Context context;

    private String secondTextViewText;
    private boolean footballButtonPressed;
    private boolean lacrosseButtonPressed;
    private boolean firstRadioButtonPressed;
    private boolean secondRadioButtonPressed;
    private boolean thirdRadioButtonPressed;
    private int numberOfCorrectAnswers;

    Model(Context cntxt) {
        context = cntxt;

        secondTextViewText = "";
        footballButtonPressed = false;
        lacrosseButtonPressed = false;
        firstRadioButtonPressed = false;
        secondRadioButtonPressed = false;
        thirdRadioButtonPressed = false;

        try {
            System.out.println("Model() opening SavedScore");
            File savedScore = new File(context.getFilesDir(), "SavedScore");
            if (savedScore.exists()) {
                System.out.println("Model() found SavedScore");
                BufferedReader input = new BufferedReader(new FileReader(savedScore));

                secondTextViewText = input.readLine();
                System.out.println("Model() read secondTextViewText" + secondTextViewText);
                footballButtonPressed = isFootballButtonPressed();
                lacrosseButtonPressed = isLacrosseButtonPressed();
                firstRadioButtonPressed = isFirstRadioButtonPressed();
                secondRadioButtonPressed = isSecondRadioButtonPressed();
                thirdRadioButtonPressed = isThirdRadioButtonPressed();
                numberOfCorrectAnswers = getNumberOfCorrectAnswers();
            }
        } catch (Exception e) {
            System.out.println("Model() threw exception");
            e.printStackTrace();
        }
    }

    void save() {

        try {

            System.out.println("Model.save() opening SavedScore");
            // Create the file if necessary
            File savedScore = new File(context.getFilesDir(), "SavedScore");

            // Write the final model to a saved file
            BufferedWriter writer = new BufferedWriter(new FileWriter(savedScore));


        } catch (Exception e) {
            System.out.println("Model() threw exception");
            e.printStackTrace();
        }
    }

    String getSecondTextViewText() { return secondTextViewText; }

    boolean isFootballButtonPressed() { return footballButtonPressed; }

    boolean isLacrosseButtonPressed() { return lacrosseButtonPressed; }

    boolean isFirstRadioButtonPressed() { return firstRadioButtonPressed; }

    boolean isSecondRadioButtonPressed() { return secondRadioButtonPressed; }

    boolean isThirdRadioButtonPressed() { return thirdRadioButtonPressed; }

    int getNumberOfCorrectAnswers() { return numberOfCorrectAnswers; }

    void setAllData(String updatedSecondTextViewText, boolean isFootballButtonPressed, boolean isLacrosseButtonPressed, boolean isFirstRadioButtonPressed, boolean isSecondRadioButtonPressed, boolean isThirdRadioButtonPressed, int updatedNumberOfCorrectAnswers) {
        secondTextViewText = updatedSecondTextViewText;
        footballButtonPressed = isFootballButtonPressed;
        lacrosseButtonPressed = isLacrosseButtonPressed;
        firstRadioButtonPressed = isFirstRadioButtonPressed;
        secondRadioButtonPressed = isSecondRadioButtonPressed;
        thirdRadioButtonPressed = isThirdRadioButtonPressed;
        if (numberOfCorrectAnswers > 0) {
            numberOfCorrectAnswers = updatedNumberOfCorrectAnswers;
        }
    }
}
