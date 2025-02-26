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

import com.frimac.preoperational.domain.dto.QuestionTypeDTO;
import com.frimac.preoperational.domain.services.QuestionType.QuestionTypeService;

@RestController
@RequestMapping("/question-types")
public class QuestionTypeController {

    private final QuestionTypeService questionTypeService;

    public QuestionTypeController(QuestionTypeService questionTypeService) {
        this.questionTypeService = questionTypeService;
    }

    @GetMapping
    public ResponseEntity<List<QuestionTypeDTO>> listAllQuestionTypes() {
        return ResponseEntity.ok(questionTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionTypeDTO> getQuestionType(@PathVariable Long id) {
        return questionTypeService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<QuestionTypeDTO> createQuestionType(@RequestBody QuestionTypeDTO questionTypeDTO) {
        QuestionTypeDTO savedQuestionType = questionTypeService.save(questionTypeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedQuestionType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionTypeDTO> updateQuestionType(@PathVariable Long id, @RequestBody QuestionTypeDTO questionTypeDTO) {
        QuestionTypeDTO updatedQuestionType = questionTypeService.update(id, questionTypeDTO);
        return ResponseEntity.ok(updatedQuestionType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestionType(@PathVariable Long id) {
        return questionTypeService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
