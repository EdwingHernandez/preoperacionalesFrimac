package com.frimac.preoperational.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frimac.preoperational.domain.dto.UserDTO;
import com.frimac.preoperational.domain.dto.UserSurveyDTO;
import com.frimac.preoperational.domain.dto.UserValidationDTO;
import com.frimac.preoperational.domain.services.User.UserService;

import java.security.Principal;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        System.out.println("ID recibido: " + userDTO.getId());
        UserDTO createdUser = userService.saveUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        UserDTO user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.modifyUser(id, userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.removeUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/surveys/{id}")
    public ResponseEntity<UserSurveyDTO> findUserWithSurveys(@PathVariable String id) {
        return ResponseEntity.ok(userService.findUserWithSurveys(id));
    }

    @GetMapping("/torre/{id}")
    public ResponseEntity<UserValidationDTO> findUserTC(@PathVariable String id) {
        return ResponseEntity.ok(userService.findUserTC(id));
    }

    @GetMapping("/validate-session")
    public ResponseEntity<?> validateSession(HttpServletRequest request) {
        Principal userPrincipal = request.getUserPrincipal();

        if (userPrincipal != null) {
            return ResponseEntity.ok().body("Sesión válida");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autenticado");
        }
    }

}
