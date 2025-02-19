package com.frimac.preoperational.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frimac.preoperational.domain.dto.AreaDTO;
import com.frimac.preoperational.domain.services.Area.AreaService;
import com.frimac.preoperational.persistence.entities.Area;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/area")
public class AreaController {

    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }
    

    @GetMapping("/all")
    public ResponseEntity<List<AreaDTO>>  listAllAreas(){
        return ResponseEntity.ok(areaService.findAll());
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<AreaDTO> getArea(@PathVariable Long id){
        Optional<AreaDTO> areaDTO = areaService.findById(id);
        return areaDTO.map(ResponseEntity :: ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/new")
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
    public ResponseEntity<AreaDTO> createArea(@RequestBody Area area){
        AreaDTO areaDTO = areaService.save(area);
        return ResponseEntity.status(HttpStatus.CREATED).body(areaDTO);
    }

}
