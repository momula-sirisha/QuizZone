package com.example.quizzone.service;

import com.example.quizzone.entity.Question;

public interface QuestionService {

    Question getQuestionById(Long questionId);

    Question createQuestion(Question question);

    // Other service methods for question-related operations
}

