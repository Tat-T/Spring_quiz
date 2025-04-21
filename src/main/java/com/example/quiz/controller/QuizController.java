package com.example.quiz.controller;

import com.example.quiz.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class QuizController {
    @GetMapping
    public  String showCategories(Model model){
        model.addAttribute("categories", Category.values());
        return "categories";
    }

    @PostMapping("/start")
    public String startQuiz(@RequestParam Category category, Model model) {
        model.addAttribute("category", category);
        return "quiz";
    }
}
