package com.sagiia.maman13ex1;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Maman13Ex1Controller {

    @FXML
    private RadioButton rbFour;

    @FXML
    private RadioButton rbOne;

    @FXML
    private RadioButton rbThree;

    @FXML
    private RadioButton rbTwo;

    @FXML
    private TextField tfQuestion;

    @FXML
    private TextField tfShowCount;

    final int NUMBER_OF_QUESTIONS = 10;

    final ToggleGroup group = new ToggleGroup();

    static int questionIndex = -1;

    private boolean needToCount = true;

    static int correctAnswers = 0;

    private ChangeListener<Toggle> listener;


    Question[] arrayOfQuestions = new Question[NUMBER_OF_QUESTIONS];

    @FXML
    public void initialize() {

        if (questionIndex == -1) {
            initializingQuestions();
        }

        setQuestion(arrayOfQuestions[questionIndex]);

        // Check if a listener is present before removing it
        if (listener != null) {
            group.selectedToggleProperty().removeListener(listener);
        }

        listener();

    }

    private void initializingQuestions() {
        questionIndex = 0;

        rbOne.setToggleGroup(group);
        rbTwo.setToggleGroup(group);
        rbThree.setToggleGroup(group);
        rbFour.setToggleGroup(group);

        arrayOfQuestions[0] = new Question("What is the capital of France?", "Paris", "Berlin", "Madrid", "Rome");
        arrayOfQuestions[1] = new Question("Which planet is known as the Red Planet?", "Mars", "Venus", "Jupiter", "Saturn");
        arrayOfQuestions[2] = new Question("Who wrote 'Romeo and Juliet'?", "William Shakespeare", "Charles Dickens", "Jane Austen", "Mark Twain");
        arrayOfQuestions[3] = new Question("What is the largest mammal in the world?", "Blue Whale", "Elephant", "Giraffe", "Hippopotamus");
        arrayOfQuestions[4] = new Question("In which year did the Titanic sink?", "1912", "1905", "1920", "1935");
        arrayOfQuestions[5] = new Question("What is the currency of Japan?", "Japanese Yen", "Chinese Yuan", "Korean Won", "Thai Baht");
        arrayOfQuestions[6] = new Question("Who painted the Mona Lisa?", "Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Michelangelo");
        arrayOfQuestions[7] = new Question("What is the largest ocean on Earth?", "Pacific Ocean", "Atlantic Ocean", "Indian Ocean", "Arctic Ocean");
        arrayOfQuestions[8] = new Question("Which country is known as the Land of the Rising Sun?", "Japan", "China", "South Korea", "Vietnam");
        arrayOfQuestions[9] = new Question("Who was the first President of the United States?", "George Washington", "Thomas Jefferson", "Abraham Lincoln", "John Adams");

        // Shuffle the array of questions
        List<Question> questionList = new ArrayList<>(Arrays.asList(arrayOfQuestions));
        Collections.shuffle(questionList);
        arrayOfQuestions = questionList.toArray(new Question[0]);
    }

    private void listener() {
        listener = (ov, old_toggle, new_toggle) -> {

            if (new_toggle != null) { // Only respond when the new toggle is selected

                if (arrayOfQuestions[questionIndex].getCorrectAnswer().equals(((RadioButton) new_toggle).getText())) {
                    if (needToCount) {
                        correctAnswers++;
                        needToCount = false;
                    }
                    JOptionPane.showMessageDialog(null, "Correct!");
                } else {
                    needToCount = false;
                    JOptionPane.showMessageDialog(null, "Wrong!");
                }

            }
        };

        group.selectedToggleProperty().addListener(listener);
    }


    private void setQuestion(Question question) {
        needToCount = true;

        tfShowCount.setText((questionIndex + 1) + " of " + NUMBER_OF_QUESTIONS);
        tfQuestion.setText(question.getQuestion());

        // Create a list of answer choices
        List<String> answerChoices = Arrays.asList(
                question.getCorrectAnswer(),
                question.getAnswer2(),
                question.getAnswer3(),
                question.getAnswer4()
        );

        // Shuffle the answer choices
        Collections.shuffle(answerChoices);

        // Set the shuffled answer choices
        rbOne.setText(answerChoices.get(0));
        rbTwo.setText(answerChoices.get(1));
        rbThree.setText(answerChoices.get(2));
        rbFour.setText(answerChoices.get(3));
        rbOne.setSelected(false);
        rbTwo.setSelected(false);
        rbThree.setSelected(false);
        rbFour.setSelected(false);
    }

    @FXML
    void onNextPress(ActionEvent ignoredEvent) {
        questionIndex++;

        if (questionIndex == NUMBER_OF_QUESTIONS) {
            JOptionPane.showMessageDialog(null, "Your grade is: " + (correctAnswers * (100 / NUMBER_OF_QUESTIONS)) + "!");
            questionIndex = 0;
            correctAnswers = 0;
        } else {
            initialize();
        }

    }

    @FXML
    void onRestartPress(ActionEvent ignoredEvent) {
        questionIndex = 0;
        correctAnswers = 0;
        initialize();
    }

}
