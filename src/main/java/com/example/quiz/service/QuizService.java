package com.example.quiz.service;

import com.example.quiz.model.Category;
import com.example.quiz.model.Question;
import com.example.quiz.model.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    private  final QuestionRepository questionRepository;

    @Autowired
    public QuizService(QuestionRepository repository)
     {
        this.questionRepository = repository;
    }

    public List<Question> getQuestionsByCategory(Category category) {
        return  questionRepository.findByCategory(category);
    }
}
