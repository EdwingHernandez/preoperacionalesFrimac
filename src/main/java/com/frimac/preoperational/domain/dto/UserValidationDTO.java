package com.frimac.preoperational.domain.dto;

public class UserValidationDTO {

    private boolean allowed;
    private String message;
    private UserTCDTO userTCDTO;

    
    public UserValidationDTO(boolean allowed, String message, UserTCDTO userTCDTO) {
        this.allowed = allowed;
        this.message = message;
        this.userTCDTO = userTCDTO;
    }


    public boolean isAllowed() {
        return allowed;
    }


    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public UserTCDTO getUserTCDTO() {
        return userTCDTO;
    }


    public void setUserTCDTO(UserTCDTO userTCDTO) {
        this.userTCDTO = userTCDTO;
    }

    

}

