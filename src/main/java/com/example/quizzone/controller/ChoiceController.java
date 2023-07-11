package com.example.quizzone.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizzone.entity.Choice;
import com.example.quizzone.service.ChoiceService;

@RestController
@RequestMapping("/api/choices")
public class ChoiceController {

    private final ChoiceService choiceService;

    public ChoiceController(ChoiceService choiceService) {
        this.choiceService = choiceService;
    }

    @GetMapping("/{choiceId}")
    public ResponseEntity<Choice> getChoiceById(@PathVariable Long choiceId) {
        Choice choice = choiceService.getChoiceById(choiceId);
        if (choice != null) {
            return ResponseEntity.ok(choice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Choice> createChoice(@RequestBody Choice choice) {
        Choice createdChoice = choiceService.createChoice(choice);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdChoice);
    }

    // Other controller methods for choice-related operations
}
