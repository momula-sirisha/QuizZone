package com.example.quizzone.exceptionHandler;

public class QuizAttemptNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuizAttemptNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuizAttemptNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public QuizAttemptNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public QuizAttemptNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public QuizAttemptNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
