package com.frimac.preoperational.domain.dto;

public class UserDTO {

    private String id;
    private String name;
    private String state;
    private String type;
    private Long idRole;
    private Long idArea;
    private Long idPosition;
    private String password;
    private String username;
    private boolean enable; 

    public UserDTO(String id, String name, String state, String type, 
                    Long idRole, Long idArea, Long idPosition, String password, String username, boolean enable) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.type = type;
        this.idRole = idRole;
        this.idArea = idArea;
        this.idPosition = idPosition;
        this.password = password;
        this.username = username;
        this.enable = enable;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    
}
