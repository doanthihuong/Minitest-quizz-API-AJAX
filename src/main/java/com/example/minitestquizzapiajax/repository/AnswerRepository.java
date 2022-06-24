package com.example.minitestquizzapiajax.repository;

import com.example.minitestquizzapiajax.model.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer,Long> {
}
