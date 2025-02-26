package com.frimac.preoperational.domain.services.User;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frimac.preoperational.domain.dto.UserDTO;
import com.frimac.preoperational.persistence.entities.Area;
import com.frimac.preoperational.persistence.entities.Position;
import com.frimac.preoperational.persistence.entities.Role;
import com.frimac.preoperational.persistence.entities.User;
import com.frimac.preoperational.persistence.repositories.AreaRepository;
import com.frimac.preoperational.persistence.repositories.PositionRepository;
import com.frimac.preoperational.persistence.repositories.RoleRepository;
import com.frimac.preoperational.persistence.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private AreaRepository areaRepository;
    
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setState(userDTO.getState());
        user.setType(userDTO.getType());
        
        Role role = roleRepository.findById(userDTO.getIdRole())
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRole(role);
        
        Area area = areaRepository.findById(userDTO.getIdArea())
                .orElseThrow(() -> new RuntimeException("Area not found"));
        user.setArea(area);
        
        Position position = positionRepository.findById(userDTO.getIdPosition())
                .orElseThrow(() -> new RuntimeException("Position not found"));
        user.setPosition(position);
        
        user = userRepository.save(user);
        return convertToDTO(user);
    }

    @Override
    public UserDTO findUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return convertToDTO(user);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO modifyUser(String id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(userDTO.getName());
        user.setState(userDTO.getState());
        user.setType(userDTO.getType());
        
        Role role = roleRepository.findById(userDTO.getIdRole())
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRole(role);
        
        Area area = areaRepository.findById(userDTO.getIdArea())
                .orElseThrow(() -> new RuntimeException("Area not found"));
        user.setArea(area);
        
        Position position = positionRepository.findById(userDTO.getIdPosition())
                .orElseThrow(() -> new RuntimeException("Position not found"));
        user.setPosition(position);
        
        user = userRepository.save(user);
        return convertToDTO(user);
    }

    @Override
    public void removeUser(String id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getState(),
                user.getType(),
                user.getRole().getId(),
                user.getArea().getId(),
                user.getPosition().getId()
        );
    }
}
