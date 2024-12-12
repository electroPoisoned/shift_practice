package com.example.demo.model;

import com.example.demo.PlatformType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Subscription {

    private String id;
    private String channelId;
    private String userId;
    private PlatformType platformType;
    private LocalDateTime timeStamp;

    public Subscription(String channelId, String userId, PlatformType platformType) {
        this.id = UUID.randomUUID().toString();
        this.channelId = channelId;
        this.userId = userId;
        this.platformType = platformType;
        this.timeStamp = LocalDateTime.now();
    }
}
