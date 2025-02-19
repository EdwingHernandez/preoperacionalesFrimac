package com.frimac.preoperational.domain.services.Question;

import java.util.List;
import java.util.Optional;

import com.frimac.preoperational.persistence.entities.Question;


public interface QuestionService {

    List<Question> findAll();
    Optional<Question> findById(Long id);
    Question save(Question Question);
    Question update(Long id, Question Question);
    Optional<Question> delete(Long id); 
}
