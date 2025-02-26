package com.frimac.preoperational.domain.services.Question;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.frimac.preoperational.domain.dto.QuestionDTO;
import com.frimac.preoperational.persistence.entities.Question;
import com.frimac.preoperational.persistence.entities.QuestionType;
import com.frimac.preoperational.persistence.entities.Survey;
import com.frimac.preoperational.persistence.repositories.QuestionRepository;
import com.frimac.preoperational.persistence.repositories.QuestionTypeRepository;
import com.frimac.preoperational.persistence.repositories.SurveyRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final SurveyRepository surveyRepository;
    private final QuestionTypeRepository questionTypeRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, 
                               SurveyRepository surveyRepository, 
                               QuestionTypeRepository questionTypeRepository) {
        this.questionRepository = questionRepository;
        this.surveyRepository = surveyRepository;
        this.questionTypeRepository = questionTypeRepository;
    }

    @Override
    public List<QuestionDTO> findAll() {
        return questionRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<QuestionDTO> findById(Long id) {
        return questionRepository.findById(id).map(this::toDTO);
    }

    @Override
    public QuestionDTO save(QuestionDTO questionDTO) {
        Question question = toEntity(questionDTO);
        Question newQuestion = questionRepository.save(question);
        return toDTO(newQuestion);
    }

    @Override
    public QuestionDTO update(Long id, QuestionDTO questionDTO) {
        Question existingQuestion = questionRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Pregunta no encontrada con id " + id));

        if (questionDTO.getQuestion() != null) {
            existingQuestion.setQuestion(questionDTO.getQuestion());
        }

        if (questionDTO.getIdSurvey() != null) {
            Survey survey = surveyRepository.findById(questionDTO.getIdSurvey())
                .orElseThrow(() -> new EntityNotFoundException("Survey no encontrado con id " + questionDTO.getIdSurvey()));
            existingQuestion.setSurvey(survey);
        }

        if (questionDTO.getIdQuestiontype() != null) {
            QuestionType questionType = questionTypeRepository.findById(questionDTO.getIdQuestiontype())
                .orElseThrow(() -> new EntityNotFoundException("QuestionType no encontrado con id " + questionDTO.getIdQuestiontype()));
            existingQuestion.setQuestionType(questionType);
        }

        Question savedQuestion = questionRepository.save(existingQuestion);
        return toDTO(savedQuestion);
    }

    @Override
    public Boolean delete(Long id) {
        if (!questionRepository.existsById(id)) {
            return false;
        }
        questionRepository.deleteById(id);
        return true;
    }

    private QuestionDTO toDTO(Question question) {
        return new QuestionDTO(
            question.getId(),
            question.getQuestion(),
            question.getSurvey() != null ? question.getSurvey().getId() : null,
            question.getQuestionType() != null ? question.getQuestionType().getId() : null
        );
    }

    private Question toEntity(QuestionDTO questionDTO) {
        Question question = new Question();
        question.setId(questionDTO.getId());
        question.setQuestion(questionDTO.getQuestion());

        if (questionDTO.getIdSurvey() != null) {
            Survey survey = surveyRepository.findById(questionDTO.getIdSurvey())
                .orElseThrow(() -> new EntityNotFoundException("Survey no encontrado con id " + questionDTO.getIdSurvey()));
            question.setSurvey(survey);
        }

        if (questionDTO.getIdQuestiontype() != null) {
            QuestionType questionType = questionTypeRepository.findById(questionDTO.getIdQuestiontype())
                .orElseThrow(() -> new EntityNotFoundException("QuestionType no encontrado con id " + questionDTO.getIdQuestiontype()));
            question.setQuestionType(questionType);
        }

        return question;
    }
}

