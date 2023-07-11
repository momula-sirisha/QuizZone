package com.example.quizzone.service;



import com.example.quizzone.entity.Choice;

public interface ChoiceService {

    Choice getChoiceById(Long choiceId);

    Choice createChoice(Choice choice);
    
    boolean isAnswerCorrect(Long choiceId);
    
   

    // Other service methods for choice-related operations
}

