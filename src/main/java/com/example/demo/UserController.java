package com.example.demo;


import com.example.demo.model.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> listUsers() {
        return userService.listUsers();
    }

    @PostMapping("/create")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping("/{email}")
    public UserDTO getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody Login login) {
        try {
            UserDTO user = userService.login(login);
            return user;
        } catch (Exception e) {
            return null; //TODO investigar como retornar error personalizado
        }
    }
}

