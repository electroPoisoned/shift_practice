package com.example.demo.repository;

import com.example.demo.model.Subscription;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SubscriptionRepository {
    private final Map<String, Subscription> subscriptions = new HashMap<>();

    public Optional<Subscription> findById(String subscriptionId) {
        return Optional.ofNullable(subscriptions.get(subscriptionId));
    }

    public List<Subscription> findAll() {
        return new ArrayList<>(subscriptions.values());
    }

    public void save(Subscription subscription) {
        subscriptions.put(subscription.getId(), subscription);
    }

    public void deleteById(String subscriptionId) {
        subscriptions.remove(subscriptionId);
    }

    public List<Subscription> findByUserId(String userId) {
        return subscriptions.values().stream()
                .filter(subscription -> subscription.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    public List<Subscription> findByChannelId(String channelId) {
        return subscriptions.values().stream()
                .filter(subscription -> subscription.getChannelId().equals(channelId))
                .collect(Collectors.toList());
    }

    public Optional<Subscription> findByUserIdAndChannelId(String userId, String channelId) {
        return subscriptions.values().stream()
                .filter(subscription -> subscription.getUserId().equals(userId) && subscription.getChannelId().equals(channelId))
                .findFirst();
    }

}
