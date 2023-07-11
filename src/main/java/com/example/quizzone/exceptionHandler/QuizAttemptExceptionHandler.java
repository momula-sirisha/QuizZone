package com.example.quizzone.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class QuizAttemptExceptionHandler {
	
	 @ExceptionHandler
	    public ResponseEntity<QuizAttemptErrorResponse> handleQuizException(QuizAttemptNotFoundException ex) {
	        QuizAttemptErrorResponse errorResponse = new QuizAttemptErrorResponse();
	        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
	    	errorResponse.setMessage(ex.getMessage());
	    	errorResponse.setTimeStamp(System.currentTimeMillis());
	    	return new ResponseEntity<>(errorResponse , HttpStatus.NOT_FOUND);
	    }
	    
	 
	 @ExceptionHandler
	    public ResponseEntity<QuizAttemptErrorResponse> handleQuizException(Exception ex) {
	        QuizAttemptErrorResponse errorResponse = new QuizAttemptErrorResponse();
	        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
	    	errorResponse.setMessage(ex.getMessage());
	    	errorResponse.setTimeStamp(System.currentTimeMillis());
	    	return new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST);
	    }
	    

}
