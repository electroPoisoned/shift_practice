package com.example.demo.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class User {

    private String userId;
    private String userName;
    private Set<Channel> subscriptions =  new HashSet<>();

    public User(String userName) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
    }

    public void addSubscription(Channel channel) {
        subscriptions.add(channel);
    }

    public void removeSubscription(Channel channel) {
        subscriptions.remove(channel);
    }

}
