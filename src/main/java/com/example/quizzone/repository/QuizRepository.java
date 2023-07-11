package com.example.quizzone.repository;



import com.example.quizzone.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    // Searching by title
    List<Quiz> findByTitleContainingIgnoreCase(String keyword);

    // Sorting by title in ascending order
    List<Quiz> findAllByOrderByTitleAsc();

    // Sorting by duration in descending order
    List<Quiz> findAllByOrderByDurationMinutesDesc();

    // Custom JPQL query for searching and sorting
    @Query("SELECT q FROM Quiz q WHERE LOWER(q.title) LIKE %:keyword% ORDER BY q.durationMinutes DESC")
    List<Quiz> searchAndSortQuizzes(@Param("keyword") String keyword);
}

