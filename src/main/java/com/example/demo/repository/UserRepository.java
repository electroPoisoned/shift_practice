package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    Map<Integer, User> users = new HashMap<>();

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public User findUserById(int id) {
        return users.get(id);
    }
}
