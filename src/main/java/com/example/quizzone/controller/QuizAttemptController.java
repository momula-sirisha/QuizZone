package com.example.quizzone.controller;


import com.example.quizzone.entity.QuizAttempt;
import com.example.quizzone.exceptionHandler.QuizAttemptNotFoundException;
import com.example.quizzone.service.QuizAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quizAttempts")
public class QuizAttemptController {
	 @Autowired
    private final QuizAttemptService quizAttemptService;

   
    public QuizAttemptController(QuizAttemptService quizAttemptService) {
        this.quizAttemptService = quizAttemptService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizAttempt> getQuizAttemptById(@PathVariable Long id) {
        QuizAttempt quizAttempt = quizAttemptService.getQuizAttemptById(id);
        if (quizAttempt != null) {
            return ResponseEntity.ok(quizAttempt);
        } else {
           // return ResponseEntity.notFound().build();
        	throw new QuizAttemptNotFoundException ("Quiz Attempt with ID  not found : " + id );
        }
    }

    @PostMapping("/")
    public ResponseEntity<QuizAttempt> createQuizAttempt(@RequestBody QuizAttempt quizAttempt) {
        QuizAttempt createdQuizAttempt = quizAttemptService.createQuizAttempt(quizAttempt);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuizAttempt);
    }

    // Other controller methods for QuizAttempt CRUD operations
    
}
