package com.example.quizzone.service;

import java.util.List;

import com.example.quizzone.entity.Quiz;

public interface QuizService {

    Quiz getQuizById(Long quizId);

    List<Quiz> getAllQuizzes();

    Quiz createQuiz(Quiz quiz);

    // Other service methods for quiz-related operations
    
    List<Quiz> searchQuizzes(String keyword);

    List<Quiz> sortQuizzesByTitle();

    List<Quiz> sortQuizzesByDuration();

    List<Quiz> searchAndSortQuizzes(String keyword);
}


