package com.example.quizzone.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;
    
    @Column(name = "total_quiz_count")
    private int totalQuizCount;

    @Column(name = "total_quiz_time")
    private long totalQuizTime;

    @Column(name = "quiz_completion_time")
    private long quizCompletionTime;
    
    @Column(name = "highest_quiz_score")
    private int highestQuizScore;

    @Column(name = "lowest_quiz_score")
    private int lowestQuizScore;

    

    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("user")
    private List<QuizAttempt> quizAttempts;

    
	public User() {
		super();
	}


	


	public User(Long id, String firstName, String lastName, String emailId, int totalQuizCount, long totalQuizTime,
			long quizCompletionTime, int highestQuizScore, int lowestQuizScore, List<QuizAttempt> quizAttempts) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.totalQuizCount = totalQuizCount;
		this.totalQuizTime = totalQuizTime;
		this.quizCompletionTime = quizCompletionTime;
		this.highestQuizScore = highestQuizScore;
		this.lowestQuizScore = lowestQuizScore;
		this.quizAttempts = quizAttempts;
	}





	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public int getTotalQuizCount() {
		return totalQuizCount;
	}


	public void setTotalQuizCount(int totalQuizCount) {
		this.totalQuizCount = totalQuizCount;
	}


	public long getTotalQuizTime() {
		return totalQuizTime;
	}


	public void setTotalQuizTime(long totalQuizTime) {
		this.totalQuizTime = totalQuizTime;
	}


	public long getQuizCompletionTime() {
		return quizCompletionTime;
	}


	public void setQuizCompletionTime(long quizCompletionTime) {
		this.quizCompletionTime = quizCompletionTime;
	}


	public int getHighestQuizScore() {
		return highestQuizScore;
	}


	public void setHighestQuizScore(int highestQuizScore) {
		this.highestQuizScore = highestQuizScore;
	}


	public int getLowestQuizScore() {
		return lowestQuizScore;
	}


	public void setLowestQuizScore(int lowestQuizScore) {
		this.lowestQuizScore = lowestQuizScore;
	}


	




	
}