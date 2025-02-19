package com.frimac.preoperational.domain.dto;

public class UserDTO {

    private String id;
    private String name;
    private String state;
    private String type;
    private Long idRole;
    private Long idArea;
    private Long idPosition;

    public UserDTO(String id, String name, String state, String type, Long idRole, Long idArea, Long idPosition) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.type = type;
        this.idRole = idRole;
        this.idArea = idArea;
        this.idPosition = idPosition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public Long getIdArea() {
        return idArea;
    }

    public void setIdArea(Long idArea) {
        this.idArea = idArea;
    }

    public Long getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Long idPosition) {
        this.idPosition = idPosition;
    }


    

    
}
