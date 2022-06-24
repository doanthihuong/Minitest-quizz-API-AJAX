package com.example.minitestquizzapiajax.service.impl;


import com.example.minitestquizzapiajax.model.Answer;
import com.example.minitestquizzapiajax.repository.AnswerRepository;
import com.example.minitestquizzapiajax.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService implements IAnswerService {
    @Autowired
    AnswerRepository answerRepository;
    @Override
    public Iterable<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public Optional<Answer> findById(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public void remove(Long id) {
        answerRepository.deleteById(id);

    }
}
