package com.example.quizzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quizzone.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    // Custom query methods for question entity, if needed

}
