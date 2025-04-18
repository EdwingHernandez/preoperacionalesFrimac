package com.frimac.preoperational.domain.services.User;

import java.util.List;

import com.frimac.preoperational.domain.dto.UserDTO;
import com.frimac.preoperational.domain.dto.UserSurveyDTO;
import com.frimac.preoperational.domain.dto.UserValidationDTO;


public interface UserService {

    List<UserDTO> findAllUsers();
    UserDTO findUserById(String id);
    UserDTO saveUser(UserDTO userDTO);
    UserDTO modifyUser(String id, UserDTO userDTO);
    void removeUser(String id);
    UserSurveyDTO findUserWithSurveys(String id);
    UserValidationDTO findUserTC(String id);
    boolean existsByUsername(String username);

}
