package com.example.quizzone.serviceImpl;

import java.util.List;
import com.example.quizzone.entity.Quiz;
import com.example.quizzone.repository.QuizRepository;
import com.example.quizzone.service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz getQuizById(Long quizId) {
        return quizRepository.findById(quizId).orElse(null);
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    // Other service methods for quiz-related operations
    
    @Override
    public List<Quiz> searchQuizzes(String keyword) {
        return quizRepository.findByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public List<Quiz> sortQuizzesByTitle() {
        return quizRepository.findAllByOrderByTitleAsc();
    }

    @Override
    public List<Quiz> sortQuizzesByDuration() {
        return quizRepository.findAllByOrderByDurationMinutesDesc();
    }

    @Override
    public List<Quiz> searchAndSortQuizzes(String keyword) {
        return quizRepository.searchAndSortQuizzes(keyword);
    }

}
