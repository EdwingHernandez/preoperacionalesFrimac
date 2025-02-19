package com.frimac.preoperational.domain.services.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frimac.preoperational.persistence.entities.User;
import com.frimac.preoperational.persistence.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }  
    
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }    

    @Override
    public User update(String id, User user) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User no encontrada con id " + id);
        }
        user.setId(id); 
        return userRepository.save(user);
    }    

}