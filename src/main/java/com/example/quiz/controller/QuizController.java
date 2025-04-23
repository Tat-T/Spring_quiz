package com.example.quiz.controller;

import com.example.quiz.model.Category;
import com.example.quiz.model.Question;
import com.example.quiz.model.ResultRow;
import com.example.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public String showCategories(Model model) {
        model.addAttribute("categories", Category.values());
        return "categories";
    }

//    @PostMapping("/start")
//    public String startQuiz(@RequestParam Category category, Model model) {
//        model.addAttribute("category", category);
//        return "quiz";
//    }

    @PostMapping("/start")
    public String startQuiz(@RequestParam Category category, Model model) {
        model.addAttribute("category", category);
        model.addAttribute("questions", quizService.getQuestionsByCategory(category));
        return "quiz";
    }

    @PostMapping("/result")
    public String showResult(
            @RequestParam("questionIds") List<Long> questionIds,
            @RequestParam("answers") List<String> answers,
            Model model) {

        List<ResultRow> results = new ArrayList<>();
        int score = 0;

        for (int i = 0; i < questionIds.size(); i++) {
            Question question = quizService.findById(questionIds.get(i));
            String userAnswer = answers.get(i).trim();

            boolean isCorrect = question.getCorrectAnswer().equalsIgnoreCase(userAnswer);
            if (isCorrect) score++;

            results.add(new ResultRow(question.getText(), userAnswer, question.getCorrectAnswer(), isCorrect));
        }

        model.addAttribute("results", results);
        model.addAttribute("score", score);
        model.addAttribute("total", questionIds.size());
        return "result";
    }
}