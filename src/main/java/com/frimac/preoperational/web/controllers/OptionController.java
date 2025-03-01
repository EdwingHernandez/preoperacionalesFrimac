package com.frimac.preoperational.web.controllers;

import com.frimac.preoperational.domain.dto.OptionDTO;
import com.frimac.preoperational.domain.services.Option.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/options")
@CrossOrigin
public class OptionController {

    private final OptionService optionService;

    @Autowired
    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<OptionDTO>> getOptionsByQuestion(@PathVariable Long questionId) {
        return ResponseEntity.ok(optionService.getOptionsByQuestion(questionId));
    }

    @PostMapping
    public ResponseEntity<OptionDTO> createOption(@RequestBody OptionDTO optionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(optionService.createOption(optionDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOption(@PathVariable Long id) {
        optionService.deleteOption(id);
        return ResponseEntity.noContent().build();
    }
}
