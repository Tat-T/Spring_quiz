package com.example.quiz.model;

public class ResultRow {
    private final String question;
    private final String userAnswer;
    private final String correctAnswer;
    private final boolean isCorrect;

    public ResultRow(String question, String userAnswer, String correctAnswer, boolean isCorrect) {
        this.question = question;
        this.userAnswer = userAnswer;
        this.correctAnswer = correctAnswer;
        this.isCorrect = isCorrect;
    }

    public String getQuestion() {
        return question;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}