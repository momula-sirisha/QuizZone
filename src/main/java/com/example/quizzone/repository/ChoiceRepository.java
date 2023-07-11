package com.example.quizzone.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quizzone.entity.Choice;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Long> {
    // Custom queries or methods can be added here if needed
}


