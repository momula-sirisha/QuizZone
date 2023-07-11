package com.example.quizzone.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizzone.entity.Question;
import com.example.quizzone.repository.QuestionRepository;
import com.example.quizzone.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	
	@Autowired
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question getQuestionById(Long questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    // Implement other service methods for question-related operations
}
