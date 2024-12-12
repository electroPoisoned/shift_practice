package com.example.demo.service;

import com.example.demo.config.ConfigLoader;
import com.example.demo.model.Channel;
import com.example.demo.repository.ChannelRepository;
import org.springframework.stereotype.Service;

@Service
public class ChannelService {

    private final ChannelRepository channelRepository;
    private final ConfigLoader configLoader = new ConfigLoader();

    public ChannelService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public void init(){
        for (int i = 1; i <= 5; i++) {
            channelRepository.save(new Channel(configLoader.getProperty("channel" + i)));
        }
    }
}
