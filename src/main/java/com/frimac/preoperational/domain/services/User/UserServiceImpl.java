package com.frimac.preoperational.domain.services.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.frimac.preoperational.domain.dto.UserDTO;
import com.frimac.preoperational.domain.dto.UserSurveyDTO;
import com.frimac.preoperational.domain.dto.UserTCDTO;
import com.frimac.preoperational.domain.dto.UserValidationDTO;
import com.frimac.preoperational.domain.services.TorreControl.TorreApiService;
import com.frimac.preoperational.persistence.entities.Area;
import com.frimac.preoperational.persistence.entities.Position;
import com.frimac.preoperational.persistence.entities.Role;
import com.frimac.preoperational.persistence.entities.Survey;
import com.frimac.preoperational.persistence.entities.User;
import com.frimac.preoperational.persistence.repositories.AreaRepository;
import com.frimac.preoperational.persistence.repositories.PositionRepository;
import com.frimac.preoperational.persistence.repositories.RoleRepository;
import com.frimac.preoperational.persistence.repositories.SurveyAssignmentRepository;
import com.frimac.preoperational.persistence.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

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

        @Autowired
        private SurveyAssignmentRepository surveyAssignmentRepository;

        @Autowired
        private TorreApiService torreApiService;

        @Autowired
        private PasswordEncoder passwordEncoder;

        public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                        AreaRepository areaRepository,
                        PositionRepository positionRepository, SurveyAssignmentRepository surveyAssignmentRepository,
                        TorreApiService torreApiService) {
                this.userRepository = userRepository;
                this.roleRepository = roleRepository;
                this.areaRepository = areaRepository;
                this.positionRepository = positionRepository;
                this.surveyAssignmentRepository = surveyAssignmentRepository;
                this.torreApiService = torreApiService;
        }

        @Override
        public UserDTO saveUser(UserDTO userDTO) { 
                if (userRepository.existsById(userDTO.getId())) {
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El usuario ya existe");
                }
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
                System.out.println("ID de la entidad: " + user.getPosition().getName());

                user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
                user.setUsername(userDTO.getUsername());
                user.setEnable(userDTO.isEnable());
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
                                user.getPosition().getId(),
                                user.getPassword(),
                                user.getUsername(),
                                user.isEnable());
        }

        public UserSurveyDTO findUserWithSurveys(String id) {
                User user = userRepository.findById(id)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                "Usuario no encontrado"));

                List<Survey> enabledSurveys = surveyAssignmentRepository.findByUser(user).stream()
                                .filter(surveyAssignment -> Boolean.TRUE
                                                .equals(surveyAssignment.getSurvey().getState()))
                                .map(surveyAssignment -> surveyAssignment.getSurvey())
                                .collect(Collectors.toList());

                return new UserSurveyDTO(
                                user.getId(),
                                user.getName(),
                                user.getPosition().getName(),
                                user.getArea().getName(),
                                enabledSurveys);
        }

        public UserValidationDTO findUserTC(String id) {
                UserTCDTO userTCDTO = torreApiService.getUserTC(id);
                if (userTCDTO == null || !userTCDTO.isStateUserTC()) {
                        return new UserValidationDTO(false, "El usuario no está activo en Torre de Control", null);

                }

                Optional<User> user = userRepository.findById(id);
                if (user.isPresent()) {
                        return new UserValidationDTO(false,
                                        "El usuario ya existe en el sistema, comuníquese con el lider de operación para activar la encuesta",
                                        userTCDTO);
                }

                return new UserValidationDTO(true, "El usuario puede ser creado en el sistema", userTCDTO);
        }

        @Override
        public boolean existsByUsername(String username) {
                return userRepository.existsByUsername(username);
        }

}
