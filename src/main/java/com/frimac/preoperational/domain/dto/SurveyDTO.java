package com.frimac.preoperational.domain.dto;

public class SurveyDTO {

    private Long id;
    private String name;
    private String description;
    private Boolean state;

    public SurveyDTO(Long id, String name, String description, Boolean state) {
        this.id = id;
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
