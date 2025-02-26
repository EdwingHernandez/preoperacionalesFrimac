package com.frimac.preoperational.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frimac.preoperational.domain.dto.SurveyCompletionDTO;
import com.frimac.preoperational.domain.services.SurveyCompletion.SurveyCompletionService;

@RestController
@RequestMapping("/survey-completions")
public class SurveyCompletionController {

    @Autowired
    private SurveyCompletionService surveyCompletionService;

    @PostMapping
    public ResponseEntity<SurveyCompletionDTO> createSurveyCompletion(@RequestBody SurveyCompletionDTO surveyCompletionDTO) {
        SurveyCompletionDTO createdCompletion = surveyCompletionService.createSurveyCompletion(surveyCompletionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCompletion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurveyCompletionDTO> getSurveyCompletionById(@PathVariable Long id) {
        SurveyCompletionDTO surveyCompletion = surveyCompletionService.getSurveyCompletionById(id);
        return ResponseEntity.ok(surveyCompletion);
    }

    @GetMapping
    public ResponseEntity<List<SurveyCompletionDTO>> getAllSurveyCompletions() {
        List<SurveyCompletionDTO> surveyCompletions = surveyCompletionService.getAllSurveyCompletions();
        return ResponseEntity.ok(surveyCompletions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SurveyCompletionDTO> updateSurveyCompletion(@PathVariable Long id, @RequestBody SurveyCompletionDTO surveyCompletionDTO) {
        SurveyCompletionDTO updatedCompletion = surveyCompletionService.updateSurveyCompletion(id, surveyCompletionDTO);
        return ResponseEntity.ok(updatedCompletion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurveyCompletion(@PathVariable Long id) {
        surveyCompletionService.deleteSurveyCompletion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SurveyCompletionDTO>> getSurveyCompletionsByUser(@PathVariable String userId) {
        List<SurveyCompletionDTO> completions = surveyCompletionService.getSurveyCompletionsByUser(userId);
        return ResponseEntity.ok(completions);
    }
}

