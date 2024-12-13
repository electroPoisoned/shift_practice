package com.example.demo.service;

import com.example.demo.config.ConfigLoader;
import com.example.demo.exceptions.custom.UserNotFoundException;
import com.example.demo.model.Channel;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

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

    public User deleteUser(String id) {
        return userRepository.deleteById(id);
    }

    public User findUser(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id: " + id + " not found."));
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String id, User updatedUser) {
        User existingUser = findUser(id);
        existingUser.setUserName(updatedUser.getUserName());
        existingUser.setSubscriptions(updatedUser.getSubscriptions());
        return userRepository.save(existingUser);
    }

    public User patchUser(String id, Map<String, Object> updates) {
        User existingUser = findUser(id);

        if (updates.containsKey("userName")) {
            existingUser.setUserName((String) updates.get("userName"));
        }
        if (updates.containsKey("subscriptions")) {
            existingUser.setSubscriptions(new HashSet<>((List<Channel>) updates.get("subscriptions")));
        }

        return userRepository.save(existingUser);
    }


}
