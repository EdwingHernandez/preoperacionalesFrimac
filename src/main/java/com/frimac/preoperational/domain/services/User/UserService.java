package com.frimac.preoperational.domain.services.User;

import java.util.List;

import com.frimac.preoperational.domain.dto.UserDTO;


public interface UserService {

    List<UserDTO> findAllUsers();
    UserDTO findUserById(String id);
    UserDTO saveUser(UserDTO userDTO);
    UserDTO modifyUser(String id, UserDTO userDTO);
    void removeUser(String id);

}
