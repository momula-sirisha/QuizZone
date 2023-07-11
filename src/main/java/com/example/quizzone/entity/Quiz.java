package com.example.quizzone.entity;

import java.time.LocalDateTime;
import java.util.List;
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
@Table(name = "quizzes")
@SequenceGenerator(name = "quiz_sequence", sequenceName = "quiz_sequence", allocationSize = 1)
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "duration_minutes")
    private int durationMinutes;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    // Constructors, getters, and setters

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JsonManagedReference
    private List<Question> questions;
    
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JsonIgnoreProperties("quiz")
    private List<QuizAttempt> quizAttempts;


    // Getters and setters for additional attributes



    public Quiz(Long id, String title, String description, int durationMinutes, LocalDateTime startTime) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.durationMinutes = durationMinutes;
		this.startTime = startTime;
	}

	public Quiz() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDurationMinutes() {
		return durationMinutes;
	}

	public void setDurationMinutes(int durationMinutes) {
		this.durationMinutes = durationMinutes;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

//	public void addQuestion(Question question) {
//        if (questions == null) {
//            questions = new ArrayList<>();
//        }
//        questions.add(question);
//        question.setQuiz(this);
//    }
//	
	
	
    
}
