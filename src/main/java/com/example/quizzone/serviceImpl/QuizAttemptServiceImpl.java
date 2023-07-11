package com.example.quizzone.serviceImpl;

import com.example.quizzone.entity.QuizAttempt;
import com.example.quizzone.repository.QuizAttemptRepository;
import com.example.quizzone.service.QuizAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizAttemptServiceImpl implements QuizAttemptService {
	@Autowired
    private final QuizAttemptRepository quizAttemptRepository;

    
    public QuizAttemptServiceImpl(QuizAttemptRepository quizAttemptRepository) {
        this.quizAttemptRepository = quizAttemptRepository;
    }

    @Override
    public QuizAttempt getQuizAttemptById(Long id) {
        return quizAttemptRepository.findById(id).orElse(null);
    }

    @Override
    public QuizAttempt createQuizAttempt(QuizAttempt quizAttempt) {
        return quizAttemptRepository.save(quizAttempt);
    }

    // Other service methods for QuizAttempt CRUD operations
}
