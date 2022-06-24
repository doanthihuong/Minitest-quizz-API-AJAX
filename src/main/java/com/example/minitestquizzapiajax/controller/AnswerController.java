package com.example.minitestquizzapiajax.controller;

import com.example.minitestquizzapiajax.model.Answer;
import com.example.minitestquizzapiajax.service.impl.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/answers")
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @GetMapping
    public ResponseEntity<Iterable<Answer>> findAll() {
        return new ResponseEntity<>(answerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Answer> findProductById(@PathVariable Long id) {
        Optional<Answer> answerOptional = answerService.findById(id);
        if (!answerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(answerOptional.get(), HttpStatus.OK);
    }
//  tạo mới
    @PostMapping
    public ResponseEntity<Answer> saveAnswer(@RequestBody Answer answer) {
        return new ResponseEntity<>(answerService.save(answer),HttpStatus.CREATED);
    }
//  edit
    @PutMapping("/{id}")
    public ResponseEntity<Answer> update(@RequestBody Answer answer, @PathVariable Long id) {
        Optional<Answer> answerOptional = answerService.findById(id);
        if (!answerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        answer.setId(answerOptional.get().getId());

        answerService.save(answer);
        return new ResponseEntity<>(answer,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Answer> deleteAnswer(@PathVariable Long id) {
        Optional<Answer> answerOptional = answerService.findById(id);
        if (!answerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        answerService.remove(id);
        return new ResponseEntity<>(answerOptional.get(), HttpStatus.NO_CONTENT);
    }
}
