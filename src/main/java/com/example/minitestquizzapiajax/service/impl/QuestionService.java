package com.example.minitestquizzapiajax.service.impl;

import com.example.minitestquizzapiajax.model.Question;
import com.example.minitestquizzapiajax.repository.QuestionRepository;
import com.example.minitestquizzapiajax.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Iterable<Question> findAll() {
       return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public void remove(Long id) {
        questionRepository.deleteById(id);

    }
}
