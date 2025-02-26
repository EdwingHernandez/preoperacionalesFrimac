package com.frimac.preoperational.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frimac.preoperational.domain.dto.AreaDTO;
import com.frimac.preoperational.domain.services.Area.AreaService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/areas")  // Uso de plural para seguir convención REST
public class AreaController {

    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping
    public ResponseEntity<List<AreaDTO>> listAllAreas() {
        return ResponseEntity.ok(areaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaDTO> getArea(@PathVariable Long id) {
        return areaService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AreaDTO> createArea(@RequestBody AreaDTO areaDTO) {
        AreaDTO savedArea = areaService.save(areaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreaDTO> updateArea(@PathVariable Long id, @RequestBody AreaDTO areaDTO) {
        AreaDTO updatedArea = areaService.update(id, areaDTO);
        return ResponseEntity.ok(updatedArea);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArea(@PathVariable Long id) {
        return areaService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

