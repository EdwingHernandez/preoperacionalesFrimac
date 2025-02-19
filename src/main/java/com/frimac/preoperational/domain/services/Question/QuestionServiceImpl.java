package com.frimac.preoperational.domain.services.Question;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frimac.preoperational.persistence.entities.Question;
import com.frimac.preoperational.persistence.repositories.QuestionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> findAll() {
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
    public Question update(Long id, Question question) {
        if (!questionRepository.existsById(id)) {
            throw new EntityNotFoundException("Question no encontrada con id " + id);
        }
        question.setId(id); 
        return questionRepository.save(question);
    }    

    @Override
    @Transactional
    public Optional<Question> delete(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        if (question.isPresent()) {
            questionRepository.deleteById(id);
        }
        return question;
    }




}
