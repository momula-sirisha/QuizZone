package com.example.quizzone.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizzone.entity.Choice;
import com.example.quizzone.repository.ChoiceRepository;
import com.example.quizzone.service.ChoiceService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ChoiceServiceImpl implements ChoiceService {

	
	@Autowired
    private final ChoiceRepository choiceRepository;

    public ChoiceServiceImpl(ChoiceRepository choiceRepository) {
        this.choiceRepository = choiceRepository;
    }

    @Override
    public Choice getChoiceById(Long choiceId) {
        return choiceRepository.findById(choiceId).orElse(null);
    }

    @Override
    public Choice createChoice(Choice choice) {
        return choiceRepository.save(choice);
    }

    // Implement other service methods for choice-related operations
    
    @Override
    public boolean isAnswerCorrect(Long choiceId) {
        Choice selectedChoice = choiceRepository.findById(choiceId)
                .orElseThrow(() -> new EntityNotFoundException("Choice not found"));

        return selectedChoice.isCorrect();
    }

	
}
