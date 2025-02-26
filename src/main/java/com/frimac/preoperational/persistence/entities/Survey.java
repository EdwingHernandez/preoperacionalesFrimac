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
@Table(name = "survey")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_survey")
    private Long id;

    @NotBlank
    @Size(min = 4, max = 30)
    @Column(name = "name_survey")
    private String name;

    
    @Column(name = "survey_description")
    private String description;

    @NotBlank
    @Column(name = "survey_state")
    private Boolean state;
    

    
    public Survey() {
    }

    public Survey(@NotBlank @Size(min = 4, max = 30) String name, String description, @NotBlank Boolean state) {
        this.name = name;
        this.description = description;
        this.state = state;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

}
