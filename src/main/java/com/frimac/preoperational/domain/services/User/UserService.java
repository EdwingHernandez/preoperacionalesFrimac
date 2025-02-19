package com.frimac.preoperational.domain.services.User;

import java.util.List;
import java.util.Optional;

import com.frimac.preoperational.persistence.entities.User;


public interface UserService {

    List<User> findAll();
    Optional<User> findById(String id);
    User save(User user);
    User update(String id, User user);

}
