package com.example.demo.service.impl;


import com.example.demo.Login;
import com.example.demo.model.entity.User;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;




@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> listUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserDTO(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword()))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        User userGuardado = userRepository.save(user);

        UserDTO userDTONew = new UserDTO(userGuardado.getFirstName(), userGuardado.getLastName(), userGuardado.getEmail(), userGuardado.getPassword());
        userDTONew.setId(userGuardado.getId());
        return userDTONew;
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        System.out.println(email);
        System.out.println(user);
        if (user == null) {
            return null;
        }
        return new UserDTO(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
    }

    public class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

    public class IncorrectPasswordException extends RuntimeException {
        public IncorrectPasswordException(String message) {
            super(message);
        }
    }

    @Override
    public UserDTO  login(Login login) {
        System.out.println(1);
        System.out.println(login.email);
        System.out.println(login.password);
        User user = userRepository.findByEmail(login.email);
        if (user == null) {
            throw new UserNotFoundException("user_not_found");
        }

        if (user.getPassword().equals(login.password)) {
            return new UserDTO(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        }

        throw new IncorrectPasswordException("password_incorrect");
    }


}
