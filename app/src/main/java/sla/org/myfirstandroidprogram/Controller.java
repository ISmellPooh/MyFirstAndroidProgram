package sla.org.myfirstandroidprogram;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Controller {
    public TextView firstTextView;
    public TextView secondTextView;
    public TextView feedbackTextView;
    public EditText updateText;
    public Button footballButton;
    public Button lacrosseButton;
    public RadioGroup radioGroup;
    public RadioButton firstRadioButton;
    public RadioButton secondRadioButton;
    public RadioButton thirdRadioButton;

    private Model model;

    String correctAnswer;

    String[][] lacrosseQuestions;
    String[][] footballQuestions;
    int currentQuestion;
    String[][] questionsBeingAsked;
    int numberOfCorrectAnswers;

    boolean footballButtonPressed;
    boolean lacrosseButtonPressed;
    boolean firstRadioButtonPressed;
    boolean secondRadioButtonPressed;
    boolean thirdRadioButtonPressed;

    Controller(TextView myFTextView, TextView mySTextView, TextView myFBTextView, EditText editText, Button myFootballButton, Button myLacrosseButton, RadioGroup myRadioGroup, RadioButton myFRadioButton, RadioButton mySRadioButton, RadioButton myTRadioButton) {
        firstTextView = myFTextView;
        secondTextView = mySTextView;
        feedbackTextView = myFBTextView;
        updateText = editText;
        footballButton = myFootballButton;
        lacrosseButton = myLacrosseButton;
        radioGroup = myRadioGroup;
        firstRadioButton = myFRadioButton;
        secondRadioButton = mySRadioButton;
        thirdRadioButton = myTRadioButton;

        footballQuestions = new String[3][5];
        footballQuestions[0][0] = "A football is commonly called a pig skin, but what animal leather is a football really made of?";
        footballQuestions[0][1] = "Cow";
        footballQuestions[0][2] = "Horse";
        footballQuestions[0][3] = "Sheep";
        footballQuestions[0][4] = "1";
        footballQuestions[1][0] = "What number did the Eagles quarterback with the best stats wear?";
        footballQuestions[1][1] = "11";
        footballQuestions[1][2] = "32";
        footballQuestions[1][3] = "7";
        footballQuestions[1][4] = "3";
        footballQuestions[2][0] = "Which state has the most NFL teams?";
        footballQuestions[2][1] = "Pennsylvania";
        footballQuestions[2][2] = "California";
        footballQuestions[2][3] = "Texas";
        footballQuestions[2][4] = "2";
        currentQuestion = 0;
        numberOfCorrectAnswers = 0;

        lacrosseQuestions = new String[3][5];
        lacrosseQuestions[0][0] = "Lacrosse was originally played by which group of people?";
        lacrosseQuestions[0][1] = "British Nobles";
        lacrosseQuestions[0][2] = "Native Americans";
        lacrosseQuestions[0][3] = "Children in Spain";
        lacrosseQuestions[0][4] = "2";
        lacrosseQuestions[1][0] = "A lacrosse ball is about the same size and weight as what piece of hockey equipment?";
        lacrosseQuestions[1][1] = "Puck";
        lacrosseQuestions[1][2] = "Helmet";
        lacrosseQuestions[1][3] = "Stick";
        lacrosseQuestions[1][4] = "1";
        lacrosseQuestions[2][0] = "Lacrosse was named after the French term meaning what?";
        lacrosseQuestions[2][1] = "Their ball";
        lacrosseQuestions[2][2] = "A helmet";
        lacrosseQuestions[2][3] = "The stick";
        lacrosseQuestions[2][4] = "3";
        currentQuestion = 0;
        numberOfCorrectAnswers = 0;

        radioGroup.getCheckedRadioButtonId();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.firstRadioButton) {
                    firstRadioButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            radiobutton1Selected();
                        }
                    });
                }

                if (checkedId == R.id.secondRadioButton) {
                    secondRadioButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            radiobutton2Selected();
                        }
                    });
                }

                if (checkedId == R.id.thirdRadioButton) {
                    thirdRadioButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            radiobutton3Selected();
                        }
                    });
                }
            }
        });

        /*radioGroup.addView(firstRadioButton);
        radioGroup.addView(secondRadioButton);
        radioGroup.addView(thirdRadioButton);*/

        /*updateText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                updateText.setText("");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateText.setText();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/

        footballButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                footballButtonPressed = true;
                updateWhenButtonPressed();
            }
        });

        lacrosseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lacrosseButtonPressed = true;
                updateWhenButtonPressed();
            }
        });

        /*firstRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radiobutton1Selected();
            }
        });

        secondRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radiobutton2Selected();
            }
        });

        thirdRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radiobutton3Selected();
            }
        });*/
    }

    void save() {
        model.setAllData(secondTextView.getText().toString(), footballButtonPressed, lacrosseButtonPressed, firstRadioButtonPressed, secondRadioButtonPressed, thirdRadioButtonPressed, numberOfCorrectAnswers);
        model.save();
    }

    void updateWhenButtonPressed() {
        //System.out.println("HI");

        if (footballButtonPressed) {
            questionsBeingAsked = footballQuestions;
        } else if (lacrosseButtonPressed) {
            questionsBeingAsked = lacrosseQuestions;
        }
        secondTextView.setText(questionsBeingAsked[currentQuestion][0]);

        firstRadioButton.setText(questionsBeingAsked[currentQuestion][1]);
        secondRadioButton.setText(questionsBeingAsked[currentQuestion][2]);
        thirdRadioButton.setText(questionsBeingAsked[currentQuestion][3]);
        correctAnswer = questionsBeingAsked[currentQuestion][Integer.parseInt(questionsBeingAsked[currentQuestion][4])];
    }

    public void radiobutton1Selected() {
        //System.out.println("HI 1");

        /*if (currentQuestion >= 2) {
            firstLabel.setText("You got " + numberOfCorrectAnswers + " out of 3 correct");
        }*/
        if (currentQuestion < 2) {

            //numberOfCorrectAnswers = numberOfCorrectAnswers + 1;

            if (firstRadioButton.getText().equals(correctAnswer)) {
                System.out.println(firstRadioButton.getText());
            /*if (firstRadioButton.getText() == "Cow") {
                feedbackLabel.setText("Correct");
            }*/
                feedbackTextView.setText("Correct");

                if (feedbackTextView.getText().equals("Correct")) {
                    numberOfCorrectAnswers = numberOfCorrectAnswers + 1;
                }

                //numberOfCorrectAnswers = numberOfCorrectAnswers + 1;

                // Display next question
                currentQuestion = currentQuestion + 1;
                secondTextView.setText(questionsBeingAsked[currentQuestion][0]);

                firstRadioButton.setText(questionsBeingAsked[currentQuestion][1]);
                secondRadioButton.setText(questionsBeingAsked[currentQuestion][2]);
                thirdRadioButton.setText(questionsBeingAsked[currentQuestion][3]);
                correctAnswer = questionsBeingAsked[currentQuestion][Integer.parseInt(questionsBeingAsked[currentQuestion][4])];
            } else {
                feedbackTextView.setText("Incorrect");

                currentQuestion = currentQuestion + 1;
                secondTextView.setText(questionsBeingAsked[currentQuestion][0]);

                firstRadioButton.setText(questionsBeingAsked[currentQuestion][1]);
                secondRadioButton.setText(questionsBeingAsked[currentQuestion][2]);
                thirdRadioButton.setText(questionsBeingAsked[currentQuestion][3]);
                correctAnswer = questionsBeingAsked[currentQuestion][Integer.parseInt(questionsBeingAsked[currentQuestion][4])];
            }
        } else {
            secondTextView.setText("You got " + numberOfCorrectAnswers + " out of 3 correct");
        }
        System.out.println("# of correct answers = " + numberOfCorrectAnswers);
        System.out.println("current question = " + currentQuestion);
    }

    public void radiobutton2Selected() {
        //System.out.println("HI 2");

        /*if (currentQuestion >= 2) {
            firstLabel.setText("You got " + numberOfCorrectAnswers + " out of 3 correct");
        }*/
        if (currentQuestion < 2) {

            //numberOfCorrectAnswers = numberOfCorrectAnswers + 1;

            if (secondRadioButton.getText().equals(correctAnswer)) {
                System.out.println(secondRadioButton.getText());
            /*if (firstRadioButton.getText() == "Cow") {
                feedbackLabel.setText("Correct");
            }*/
                feedbackTextView.setText("Correct");

                if (secondTextView.getText().equals("Which state has the most NFL teams?")) {
                    if (feedbackTextView.getText().equals("Correct")) {
                        numberOfCorrectAnswers = numberOfCorrectAnswers + 1;
                    }
                    if (feedbackTextView.getText().equals("Incorrect")) {
                        numberOfCorrectAnswers = numberOfCorrectAnswers + 0;
                    }
                }

                //numberOfCorrectAnswers = numberOfCorrectAnswers + 1;

                // Display next question
                currentQuestion = currentQuestion + 1;
                secondTextView.setText(questionsBeingAsked[currentQuestion][0]);

                firstRadioButton.setText(questionsBeingAsked[currentQuestion][1]);
                secondRadioButton.setText(questionsBeingAsked[currentQuestion][2]);
                thirdRadioButton.setText(questionsBeingAsked[currentQuestion][3]);
                correctAnswer = questionsBeingAsked[currentQuestion][Integer.parseInt(questionsBeingAsked[currentQuestion][4])];
            } else {
                feedbackTextView.setText("Incorrect");

                currentQuestion = currentQuestion + 1;
                secondTextView.setText(questionsBeingAsked[currentQuestion][0]);

                firstRadioButton.setText(questionsBeingAsked[currentQuestion][1]);
                secondRadioButton.setText(questionsBeingAsked[currentQuestion][2]);
                thirdRadioButton.setText(questionsBeingAsked[currentQuestion][3]);
                correctAnswer = questionsBeingAsked[currentQuestion][Integer.parseInt(questionsBeingAsked[currentQuestion][4])];
            }
        } else {
            secondTextView.setText("You got " + numberOfCorrectAnswers + " out of 3 correct");
        }
        System.out.println("# of correct answers = " + numberOfCorrectAnswers);
        System.out.println("current question = " + currentQuestion);
    }

    public void radiobutton3Selected() {
        //System.out.println("HI 3");

        /*if (currentQuestion >= 2) {
            firstLabel.setText("You got " + numberOfCorrectAnswers + " out of 3 correct");
        }*/
        if (currentQuestion < 2) {

            //numberOfCorrectAnswers = numberOfCorrectAnswers + 1;

            if (thirdRadioButton.getText().equals(correctAnswer)) {
                System.out.println(thirdRadioButton.getText());
            /*if (firstRadioButton.getText() == "Cow") {
                feedbackLabel.setText("Correct");
            }*/
                feedbackTextView.setText("Correct");

                if (secondTextView.getText().equals("Which state has the most NFL teams?")) {
                    if (feedbackTextView.getText().equals("Correct")) {
                        numberOfCorrectAnswers = numberOfCorrectAnswers + 1;
                    }
                    if (feedbackTextView.getText().equals("Incorrect")) {
                        numberOfCorrectAnswers = numberOfCorrectAnswers + 0;
                    }
                }

                //numberOfCorrectAnswers = numberOfCorrectAnswers + 1;

                // Display next question
                currentQuestion = currentQuestion + 1;
                secondTextView.setText(questionsBeingAsked[currentQuestion][0]);

                firstRadioButton.setText(questionsBeingAsked[currentQuestion][1]);
                secondRadioButton.setText(questionsBeingAsked[currentQuestion][2]);
                thirdRadioButton.setText(questionsBeingAsked[currentQuestion][3]);
                correctAnswer = questionsBeingAsked[currentQuestion][Integer.parseInt(questionsBeingAsked[currentQuestion][4])];
            } else {
                feedbackTextView.setText("Incorrect");

                currentQuestion = currentQuestion + 1;
                secondTextView.setText(questionsBeingAsked[currentQuestion][0]);

                firstRadioButton.setText(questionsBeingAsked[currentQuestion][1]);
                secondRadioButton.setText(questionsBeingAsked[currentQuestion][2]);
                thirdRadioButton.setText(questionsBeingAsked[currentQuestion][3]);
                correctAnswer = questionsBeingAsked[currentQuestion][Integer.parseInt(questionsBeingAsked[currentQuestion][4])];
            }
        } else {
            secondTextView.setText("You got " + numberOfCorrectAnswers + " out of 3 correct");
        }
        System.out.println("# of correct answers = " + numberOfCorrectAnswers);
        System.out.println("current question = " + currentQuestion);
    }

}
