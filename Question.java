package com.sagiia.maman13ex1;


/**
 * The Question class represents a single quiz question with multiple-choice answers.
 */
public class Question {
    private final String question;      // The text of the question
    private final String correctAnswer; // The correct answer
    private final String answer2;      // The second answer
    private final String answer3;     // The third answer
    private final String answer4;   // The fourth answer

    /**
     * Constructs a new Question object with the specified parameters.
     *
     * @param question      The text of the question.
     * @param correctAnswer The correct answer to the question.
     * @param answer2       The second answer choice.
     * @param answer3       The third answer choice.
     * @param answer4       The fourth answer choice.
     */
    public Question(String question, String correctAnswer, String answer2, String answer3, String answer4) {
        this.question = question; // The text of the question
        this.correctAnswer = correctAnswer; // The correct answer
        this.answer2 = answer2; // The second answer
        this.answer3 = answer3; // The third answer
        this.answer4 = answer4; // The fourth answer
    }

    /**
     * Gets the text of the question.
     *
     * @return The text of the question.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Gets the correct answer to the question.
     *
     * @return The correct answer to the question.
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Gets the second answer choice.
     *
     * @return The second answer choice.
     */
    public String getAnswer2() {
        return answer2;
    }

    /**
     * Gets the third answer choice.
     *
     * @return The third answer choice.
     */
    public String getAnswer3() {
        return answer3;
    }

    /**
     * Gets the fourth answer choice.
     *
     * @return The fourth answer choice.
     */
    public String getAnswer4() {
        return answer4;
    }

}
