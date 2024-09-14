package com.example.demo.service;

import com.example.demo.Login;
import com.example.demo.model.dto.UserDTO;
import java.util.List;

public interface UserService {
    List<UserDTO> listUsers();
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserByEmail(String email);
    UserDTO login(Login login);
}
