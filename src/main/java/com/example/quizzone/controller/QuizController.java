 package com.example.quizzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizzone.entity.Quiz;

import com.example.quizzone.exceptionHandler.QuizNotFoundException;
import com.example.quizzone.service.QuizService;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

	@Autowired
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long quizId) {
        Quiz quiz = quizService.getQuizById(quizId);
        if (quiz != null) {
            return ResponseEntity.ok(quiz);
        } else {
            throw new QuizNotFoundException("Quiz with ID " + quizId + " not found");
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return ResponseEntity.ok(quizzes);
    }

    @PostMapping("/")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        Quiz createdQuiz = quizService.createQuiz(quiz);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuiz);
    }

    // Other controller methods for quiz-related operations
    
    @GetMapping("/search")
    public ResponseEntity<List<Quiz>> searchQuizzes(@RequestParam(required = false, defaultValue = "") String keyword) {
        List<Quiz> quizzes;
        if (keyword.isEmpty()) {
            quizzes = quizService.getAllQuizzes();  // Perform the desired logic when keyword is not provided
        } else {
            quizzes = quizService.searchQuizzes(keyword);  // Perform the logic to search quizzes based on the provided keyword
        }
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }


    @GetMapping("/sort/title")
    public ResponseEntity<List<Quiz>> sortQuizzesByTitle() {
        List<Quiz> quizzes = quizService.sortQuizzesByTitle();
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    @GetMapping("/sort/duration")
    public ResponseEntity<List<Quiz>> sortQuizzesByDuration() {
        List<Quiz> quizzes = quizService.sortQuizzesByDuration();
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }
    @GetMapping("/search-and-sort")
    public ResponseEntity<?> searchAndSortQuizzes(@RequestParam(required = false, defaultValue = "") String keyword) {
        if (keyword.isEmpty()) {
            return ResponseEntity.badRequest().body("No keyword provided."); // Return custom error response for missing keyword
        }
        
        List<Quiz> quizzes = quizService.searchAndSortQuizzes(keyword); // Search and sort quizzes by keyword

        if (quizzes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No quizzes found for the provided keyword."); // Return custom error response if no quizzes are found
        } else {
            return new ResponseEntity<>(quizzes, HttpStatus.OK);
        }
    }




}





