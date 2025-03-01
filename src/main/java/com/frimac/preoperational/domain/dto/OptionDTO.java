package com.frimac.preoperational.domain.dto;


public class OptionDTO {
    private Long id;
    private String text;
    private Long idQuestion;

    public OptionDTO(Long id, String text, Long idQuestion) {
        this.id = id;
        this.text = text;
        this.idQuestion = idQuestion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }
}
