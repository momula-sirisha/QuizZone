package com.example.quizzone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.quizzone.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}