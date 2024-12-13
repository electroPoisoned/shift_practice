package com.example.demo.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class Channel {

    private String id;
    private String name;
    Set<User> subscribers = new HashSet<>();

    public Channel(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public void addSubscriber(User user) {
        subscribers.add(user);
    }

    public void removeSubscriber(User user) {
        subscribers.remove(user);
    }

}
