package com.frimac.preoperational.domain.dto;

public class QuestionDTO {

    private Long id;
    private String question;
    private Long idSurvey;
    private Long idQuestiontype;



    public QuestionDTO() {
    }

    public QuestionDTO(Long id, String question, Long idSurvey, Long idQuestiontype) {
        this.id = id;
        this.question = question;
        this.idSurvey = idSurvey;
        this.idQuestiontype = idQuestiontype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getIdSurvey() {
        return idSurvey;
    }

    public void setIdSurvey(Long idSurvey) {
        this.idSurvey = idSurvey;
    }

    public Long getIdQuestiontype() {
        return idQuestiontype;
    }

    public void setIdQuestiontype(Long idQuestiontype) {
        this.idQuestiontype = idQuestiontype;
    }



}
