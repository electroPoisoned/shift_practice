package com.example.demo.repository;

import com.example.demo.PlatformType;

public record SubscriptionRecord(String userId, String channelId, PlatformType platformType) {
}
