package com.example.quizzone.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

	
	 @ExceptionHandler
	    public ResponseEntity<UserErrorResponse> handleQuizException(UserNotFoundException ex) {
	        UserErrorResponse errorResponse = new UserErrorResponse();
	        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
	    	errorResponse.setMessage(ex.getMessage());
	    	errorResponse.setTimeStamp(System.currentTimeMillis());
	    	return new ResponseEntity<>(errorResponse , HttpStatus.NOT_FOUND);
	    }
	    


	 @ExceptionHandler
	    public ResponseEntity<UserErrorResponse> handleQuizException(Exception ex) {
	        UserErrorResponse errorResponse = new UserErrorResponse();
	        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
	    	errorResponse.setMessage(ex.getMessage());
	    	errorResponse.setTimeStamp(System.currentTimeMillis());
	    	return new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST);
	    }
}
