package com.example.demo.service;

import com.example.demo.config.ConfigLoader;
import com.example.demo.exceptions.custom.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ConfigLoader configLoader = new ConfigLoader();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void init() {
        for (int i = 1; i <= 5; i++) {
            userRepository.save(new User(configLoader.getProperty("name" + i)));
        }
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public User findUser(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id: " + id + " not found."));
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

}
