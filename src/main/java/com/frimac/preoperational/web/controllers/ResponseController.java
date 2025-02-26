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

import com.frimac.preoperational.domain.dto.ResponseDTO;
import com.frimac.preoperational.domain.services.Response.ResponseService;

@RestController
@RequestMapping("/responses")
public class ResponseController {

    private final ResponseService responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseDTO>> listAllResponses() {
        return ResponseEntity.ok(responseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getResponse(@PathVariable Long id) {
        return responseService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createResponse(@RequestBody ResponseDTO responseDTO) {
        ResponseDTO savedResponse = responseService.save(responseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateResponse(@PathVariable Long id, @RequestBody ResponseDTO responseDTO) {
        ResponseDTO updatedResponse = responseService.update(id, responseDTO);
        return ResponseEntity.ok(updatedResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResponse(@PathVariable Long id) {
        return responseService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

