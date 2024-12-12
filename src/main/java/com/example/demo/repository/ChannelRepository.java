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
public class ChannelRepository {
    private final Map<String, Channel> channels = new HashMap<>();

    public Optional<Channel> findById(String channelId) {
        return channels.values().stream()
                .filter(channel -> channel.getId().equals(channelId))
                .findFirst();
    }

    public List<Channel> findAll() {
        return new ArrayList<>(channels.values());
    }

    public void save(Channel channel) {
        channels.put(channel.getId(), channel);
    }

    public void deleteById(String channelId) {
        channels.entrySet().removeIf(entry -> entry.getValue().getId().equals(channelId));
    }

    public void addSubscriber(String channelId, User user) {
        Channel channel = channels.get(channelId);
        if (channel == null) {
            throw new RuntimeException("Channel not found");
        }
        channel.getSubscribers().add(user);
    }

    public void removeSubscriber(String channelId, User user) {
        Channel channel = channels.get(channelId);
        if (channel == null) {
            throw new RuntimeException("Channel not found");
        }
        channel.getSubscribers().remove(user);
    }
}
