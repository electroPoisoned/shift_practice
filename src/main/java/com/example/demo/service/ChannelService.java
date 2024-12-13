package com.example.demo.service;

import com.example.demo.config.ConfigLoader;
import com.example.demo.exceptions.custom.ChannelNotFoundException;
import com.example.demo.model.Channel;
import com.example.demo.model.User;
import com.example.demo.repository.ChannelRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Service
public class ChannelService {

    private final ChannelRepository channelRepository;
    private final ConfigLoader configLoader = new ConfigLoader();

    public ChannelService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public void init() {
        for (int i = 1; i <= 5; i++) {
            channelRepository.save(new Channel(configLoader.getProperty("channel" + i)));
        }
    }

    public Channel findChannel(String id) {
        return channelRepository.findById(id)
                .orElseThrow(() -> new ChannelNotFoundException("Channel with id: " + id + " not found."));
    }

    public List<Channel> findAllChannels() {
        return channelRepository.findAll();
    }

    public Channel saveChannel(Channel channel) {
        channelRepository.save(channel);
        return channel;
    }

    public Boolean deleteChannel(String id) {
        return channelRepository.deleteById(id);
    }

    public Channel updateChannel(String id, Channel updatedChannel) {
        Channel existingChannel = findChannel(id);
        existingChannel.setName(updatedChannel.getName());
        existingChannel.setSubscribers(updatedChannel.getSubscribers());
        channelRepository.save(existingChannel);
        return existingChannel;
    }

    public Channel patchChannel(String id, Map<String, Object> updates) {
        Channel existingChannel = findChannel(id);

        if (updates.containsKey("name")) {
            existingChannel.setName((String) updates.get("name"));
        }
        if (updates.containsKey("subscribers")) {
            existingChannel.setSubscribers(new HashSet<>((List<User>) updates.get("subscribers")));
        }

        channelRepository.save(existingChannel);
        return existingChannel;
    }

    public void addSubscriber(String channelId, User user) {
        Channel channel = findChannel(channelId);
        channel.getSubscribers().add(user);
        channelRepository.save(channel);
    }

    public void removeSubscriber(String channelId, User user) {
        Channel channel = findChannel(channelId);
        channel.getSubscribers().remove(user);
        channelRepository.save(channel);
    }
}
