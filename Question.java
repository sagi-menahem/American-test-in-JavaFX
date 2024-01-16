package com.sagiia.maman13ex1;

public class Question {
    private final String question;
    private final String correctAnswer;
    private final String answer2;
    private final String answer3;
    private final String answer4;

    public Question(String question, String correctAnswer, String answer2, String answer3, String answer4) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

}
