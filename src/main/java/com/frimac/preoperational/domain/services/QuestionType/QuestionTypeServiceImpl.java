package com.frimac.preoperational.domain.services.QuestionType;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frimac.preoperational.persistence.entities.QuestionType;
import com.frimac.preoperational.persistence.repositories.QuestionTypeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {

    @Autowired
    private QuestionTypeRepository questionTypeRepository;

    public QuestionTypeServiceImpl(QuestionTypeRepository questionTypeRepository) {
        this.questionTypeRepository = questionTypeRepository;
    }

    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }

    @Override
    public Optional<QuestionType> findById(Long id) {
        return questionTypeRepository.findById(id);
    }  
    
    @Override
    public QuestionType save(QuestionType questionType) {
        return questionTypeRepository.save(questionType);
    }    

    @Override
    public QuestionType update(Long id, QuestionType questionType) {
        if (!questionTypeRepository.existsById(id)) {
            throw new EntityNotFoundException("QuestionType no encontrada con id " + id);
        }
        questionType.setId(id); 
        return questionTypeRepository.save(questionType);
    }    

    @Override
    @Transactional
    public Optional<QuestionType> delete(Long id) {
        Optional<QuestionType> questionType = questionTypeRepository.findById(id);
        if (questionType.isPresent()) {
            questionTypeRepository.deleteById(id);
        }
        return questionType;
    }




}
