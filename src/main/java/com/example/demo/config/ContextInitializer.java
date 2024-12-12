package com.example.demo.config;

import com.example.demo.service.ChannelService;
import com.example.demo.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ContextInitializer {

    private final UserService userService;
    private final ChannelService channelService;

    public ContextInitializer(UserService userService, ChannelService channelService) {
        this.userService = userService;
        this.channelService = channelService;
    }

    @PostConstruct
    public void init(){
        userService.init();
        channelService.init();
    }
}
