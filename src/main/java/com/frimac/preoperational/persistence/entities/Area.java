package com.frimac.preoperational.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area")
    private Long id;


    @NotBlank
    @Size(min = 4, max = 30)
    @Column(name = "name_area", unique = true)
    private String name;

    

    public Area() {
    }

    public Area(@NotBlank @Size(min = 4, max = 30) String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }    

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
    
    

}
