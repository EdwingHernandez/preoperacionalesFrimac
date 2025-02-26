package com.frimac.preoperational.domain.services.SurveyCompletion;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frimac.preoperational.domain.dto.SurveyCompletionDTO;
import com.frimac.preoperational.persistence.entities.Survey;
import com.frimac.preoperational.persistence.entities.SurveyCompletion;
import com.frimac.preoperational.persistence.entities.User;
import com.frimac.preoperational.persistence.repositories.SurveyCompletionRepository;
import com.frimac.preoperational.persistence.repositories.SurveyRepository;
import com.frimac.preoperational.persistence.repositories.UserRepository;


@Service
public class SurveyCompletionServiceImpl implements SurveyCompletionService {

    @Autowired
    private SurveyCompletionRepository surveyCompletionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public SurveyCompletionDTO createSurveyCompletion(SurveyCompletionDTO surveyCompletionDTO) {
        SurveyCompletion completion = new SurveyCompletion();
        completion.setDate(surveyCompletionDTO.getDate());
        completion.setIscompleted(surveyCompletionDTO.getIscompleted());

        User user = userRepository.findById(surveyCompletionDTO.getIdUser())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        completion.setUser(user);

        Survey survey = surveyRepository.findById(surveyCompletionDTO.getIdSurvey())
                .orElseThrow(() -> new RuntimeException("Encuesta no encontrada"));
        completion.setSurvey(survey);

        completion = surveyCompletionRepository.save(completion);
        return convertToDTO(completion);
    }

    @Override
    public SurveyCompletionDTO getSurveyCompletionById(Long id) {
        SurveyCompletion completion = surveyCompletionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de finalización no encontrado"));
        return convertToDTO(completion);
    }

    @Override
    public List<SurveyCompletionDTO> getAllSurveyCompletions() {
        List<SurveyCompletion> completions = surveyCompletionRepository.findAll();
        return completions.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public SurveyCompletionDTO updateSurveyCompletion(Long id, SurveyCompletionDTO surveyCompletionDTO) {
        SurveyCompletion completion = surveyCompletionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de finalización no encontrado"));

        completion.setDate(surveyCompletionDTO.getDate());
        completion.setIscompleted(surveyCompletionDTO.getIscompleted());

        User user = userRepository.findById(surveyCompletionDTO.getIdUser())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        completion.setUser(user);

        Survey survey = surveyRepository.findById(surveyCompletionDTO.getIdSurvey())
                .orElseThrow(() -> new RuntimeException("Encuesta no encontrada"));
        completion.setSurvey(survey);

        completion = surveyCompletionRepository.save(completion);
        return convertToDTO(completion);
    }

    @Override
    public void deleteSurveyCompletion(Long id) {
        if (!surveyCompletionRepository.existsById(id)) {
            throw new RuntimeException("Registro de finalización no encontrado");
        }
        surveyCompletionRepository.deleteById(id);
    }

    private SurveyCompletionDTO convertToDTO(SurveyCompletion completion) {
        return new SurveyCompletionDTO(
                completion.getId(),
                completion.getDate(),
                completion.getIscompleted(),
                completion.getUser().getId(),
                completion.getSurvey().getId()
        );
    }
    
    @Override
    public List<SurveyCompletionDTO> getSurveyCompletionsByUser(String userId) {
        List<SurveyCompletion> completions = surveyCompletionRepository.findByUserId(userId);
        return completions.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    


}

