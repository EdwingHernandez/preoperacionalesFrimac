package com.frimac.preoperational.domain.services.SurveyAssignment;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frimac.preoperational.domain.dto.SurveyAssignmentDTO;
import com.frimac.preoperational.persistence.entities.Survey;
import com.frimac.preoperational.persistence.entities.SurveyAssignment;
import com.frimac.preoperational.persistence.entities.User;
import com.frimac.preoperational.persistence.repositories.SurveyAssignmentRepository;
import com.frimac.preoperational.persistence.repositories.SurveyRepository;
import com.frimac.preoperational.persistence.repositories.UserRepository;

@Service
public class SurveyAssignmentServiceImpl implements SurveyAssignmentService {

    @Autowired
    private SurveyAssignmentRepository surveyAssignmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public SurveyAssignmentDTO createSurveyAssignment(SurveyAssignmentDTO surveyAssignmentDTO) {
        SurveyAssignment assignment = new SurveyAssignment();
        assignment.setDate(surveyAssignmentDTO.getDate());

        User user = userRepository.findById(surveyAssignmentDTO.getIdUser())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        assignment.setUser(user);

        Survey survey = surveyRepository.findById(surveyAssignmentDTO.getIdSurvey())
                .orElseThrow(() -> new RuntimeException("Encuesta no encontrada"));
        assignment.setSurvey(survey);

        assignment = surveyAssignmentRepository.save(assignment);
        return convertToDTO(assignment);
    }

    @Override
    public SurveyAssignmentDTO getSurveyAssignmentById(Long id) {
        SurveyAssignment assignment = surveyAssignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignación no encontrada"));
        return convertToDTO(assignment);
    }

    @Override
    public List<SurveyAssignmentDTO> getAllSurveyAssignments() {
        List<SurveyAssignment> assignments = surveyAssignmentRepository.findAll();
        return assignments.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public SurveyAssignmentDTO updateSurveyAssignment(Long id, SurveyAssignmentDTO surveyAssignmentDTO) {
        SurveyAssignment assignment = surveyAssignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignación no encontrada"));

        assignment.setDate(surveyAssignmentDTO.getDate());

        User user = userRepository.findById(surveyAssignmentDTO.getIdUser())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        assignment.setUser(user);

        Survey survey = surveyRepository.findById(surveyAssignmentDTO.getIdSurvey())
                .orElseThrow(() -> new RuntimeException("Encuesta no encontrada"));
        assignment.setSurvey(survey);

        assignment = surveyAssignmentRepository.save(assignment);
        return convertToDTO(assignment);
    }

    @Override
    public void deleteSurveyAssignment(Long id) {
        if (!surveyAssignmentRepository.existsById(id)) {
            throw new RuntimeException("Asignación no encontrada");
        }
        surveyAssignmentRepository.deleteById(id);
    }

    private SurveyAssignmentDTO convertToDTO(SurveyAssignment assignment) {
        return new SurveyAssignmentDTO(
                assignment.getId(),
                assignment.getDate(),
                assignment.getUser().getId(),
                assignment.getSurvey().getId());
    }

    @Override
    public List<SurveyAssignmentDTO> getAssignmentsByUser(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        List<SurveyAssignment> assignments = surveyAssignmentRepository.findByUser(user);

        return assignments.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

}
