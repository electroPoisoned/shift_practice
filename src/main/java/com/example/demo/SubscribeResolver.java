package com.example.demo;

import com.example.demo.service.SubscribeService;

import java.util.HashMap;
import java.util.Map;

public class SubscribeResolver {

    private final Map<SubscribeType, SubscribeService> subscribeServiceMap =new HashMap<>();

    public SubscribeService getSubscribeService(SubscribeType subscribeType) {
        return subscribeServiceMap.get(subscribeType);
    }

}
