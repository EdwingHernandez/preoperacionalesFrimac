package com.frimac.preoperational.web.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frimac.preoperational.domain.dto.SurveyAssignmentDTO;
import com.frimac.preoperational.domain.services.SurveyAssignment.SurveyAssignmentService;

@RestController
@RequestMapping("/survey-assignments")
public class SurveyAssignmentController {

    private final SurveyAssignmentService surveyAssignmentService;

    public SurveyAssignmentController(SurveyAssignmentService surveyAssignmentService) {
        this.surveyAssignmentService = surveyAssignmentService;
    }

    @PostMapping("/assign")
    public ResponseEntity<SurveyAssignmentDTO> assignSurvey(@RequestBody SurveyAssignmentDTO surveyAssignmentDTO) {
        SurveyAssignmentDTO createdAssignment = surveyAssignmentService.createSurveyAssignment(surveyAssignmentDTO);

        return new ResponseEntity<>(createdAssignment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SurveyAssignmentDTO>> getAllAssignments() {
        List<SurveyAssignmentDTO> assignments = surveyAssignmentService.getAllSurveyAssignments();
        return ResponseEntity.ok(assignments);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SurveyAssignmentDTO>> getAssignmentsByUser(@PathVariable String userId) {
        List<SurveyAssignmentDTO> assignments = surveyAssignmentService.getAssignmentsByUser(userId);
        return ResponseEntity.ok(assignments);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        surveyAssignmentService.deleteSurveyAssignment(id);
        return ResponseEntity.noContent().build();
    }
}

