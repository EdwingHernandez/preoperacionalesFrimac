package com.frimac.preoperational.domain.services.Survey;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.frimac.preoperational.domain.dto.QuestionDTO;
import com.frimac.preoperational.domain.dto.QuestionWithOptionsDTO;
import com.frimac.preoperational.domain.dto.SurveyDTO;
import com.frimac.preoperational.domain.dto.SurveyFilledModuleDTO;
import com.frimac.preoperational.domain.services.Question.QuestionService;
import com.frimac.preoperational.persistence.entities.Survey;
import com.frimac.preoperational.persistence.repositories.SurveyRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;
    private final QuestionService questionService;

    public SurveyServiceImpl(SurveyRepository surveyRepository, QuestionService questionService) {
        this.surveyRepository = surveyRepository;
        this.questionService = questionService;
    }

    @Override
    public List<SurveyDTO> findAll() {
        return surveyRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SurveyDTO> findById(Long id) {
        return surveyRepository.findById(id).map(this::toDTO);
    }

    @Override
    public SurveyDTO save(SurveyDTO surveyDTO) {
        if (surveyRepository.existsByName(surveyDTO.getName())) {
            throw new EntityExistsException("La encuesta '" + surveyDTO.getName() + "' ya existe.");
        }

        Survey survey = new Survey(surveyDTO.getName(), surveyDTO.getDescription(), surveyDTO.getState());
        Survey savedSurvey = surveyRepository.save(survey);
        return toDTO(savedSurvey);
    }

    @Override
    public SurveyDTO update(Long id, SurveyDTO surveyDTO) {
        Survey existingSurvey = surveyRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Encuesta no encontrada con id " + id));

        if (surveyDTO.getName() != null) {
            if (surveyRepository.existsByName(surveyDTO.getName()) && !existingSurvey.getName().equals(surveyDTO.getName())) {
                throw new EntityExistsException("La encuesta '" + surveyDTO.getName() + "' ya existe.");
            }
            existingSurvey.setName(surveyDTO.getName());
        }

        if (surveyDTO.getDescription() != null) {
            existingSurvey.setDescription(surveyDTO.getDescription());
        }

        if (surveyDTO.getState() != null) {
            existingSurvey.setState(surveyDTO.getState());
        }

        Survey updatedSurvey = surveyRepository.save(existingSurvey);
        return toDTO(updatedSurvey);
    }

    @Override
    public Boolean delete(Long id) {
        if (!surveyRepository.existsById(id)) {
            return false;
        }
        surveyRepository.deleteById(id);
        return true;
    }

    private SurveyDTO toDTO(Survey survey) {
        return new SurveyDTO(survey.getId(), survey.getName(), survey.getDescription(), survey.getState());
    }

    
    @Override
    public Optional<SurveyFilledModuleDTO> findSurveyWithQuestionsById(Long surveyId){

        List<QuestionDTO> questionsDTO = questionService.findBySurveyId(surveyId);
        List<QuestionWithOptionsDTO> questionsWithOptions = questionsDTO.stream().map(questionService::toQuestionWithOptionsDTO).collect(Collectors.toList());

        Survey survey = surveyRepository.findById(surveyId)
        .orElseThrow(() -> new RuntimeException("Encuesta no encontrada"));        

        SurveyFilledModuleDTO surveyDTO = new SurveyFilledModuleDTO();
        surveyDTO.setIdSurvey(survey.getId());
        surveyDTO.setNameSurvey(survey.getName());
        surveyDTO.setDescriptionSurvey(survey.getDescription());
        surveyDTO.setStateSurvey(survey.getState());
        surveyDTO.setQuestionsDTO(questionsWithOptions);

        return Optional.of(surveyDTO);

    }


}
