package com.example.demo.repository;

import com.example.demo.model.Channel;
import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Repository
public class UserRepository {
    private final Map<String, User> users = new HashMap<>();

    public Optional<User> findById(String userId) {
        return Optional.ofNullable(users.get(userId));
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public void save(User user) {
        users.put(user.getUserId(), user);
    }

    public void deleteById(String userId) {
        users.remove(userId);
    }

    public void addSubscription(String userId, Channel channel) {
        User user = users.get(userId);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        user.getSubscriptions().add(channel);
    }

    public void removeSubscription(String userId, Channel channel) {
        User user = users.get(userId);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        user.getSubscriptions().remove(channel);
    }
}
