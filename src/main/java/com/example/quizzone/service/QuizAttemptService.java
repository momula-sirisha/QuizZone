package com.example.quizzone.service;


import com.example.quizzone.entity.QuizAttempt;

public interface QuizAttemptService {
    QuizAttempt getQuizAttemptById(Long id);
    QuizAttempt createQuizAttempt(QuizAttempt quizAttempt);
    
}
