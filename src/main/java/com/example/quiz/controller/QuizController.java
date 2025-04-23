package com.example.quiz.controller;

import com.example.quiz.model.Category;
import com.example.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
