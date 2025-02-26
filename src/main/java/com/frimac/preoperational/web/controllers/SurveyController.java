package com.frimac.preoperational.web.controllers;

import java.util.List;

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

import com.frimac.preoperational.domain.dto.SurveyDTO;
import com.frimac.preoperational.domain.services.Survey.SurveyService;

@RestController
@RequestMapping("/surveys")
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping
    public ResponseEntity<List<SurveyDTO>> listAllSurveys() {
        return ResponseEntity.ok(surveyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurveyDTO> getSurvey(@PathVariable Long id) {
        return surveyService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SurveyDTO> createSurvey(@RequestBody SurveyDTO surveyDTO) {
        SurveyDTO savedSurvey = surveyService.save(surveyDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSurvey);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SurveyDTO> updateSurvey(@PathVariable Long id, @RequestBody SurveyDTO surveyDTO) {
        SurveyDTO updatedSurvey = surveyService.update(id, surveyDTO);
        return ResponseEntity.ok(updatedSurvey);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id) {
        return surveyService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

