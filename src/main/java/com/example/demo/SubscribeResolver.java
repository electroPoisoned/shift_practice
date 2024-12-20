package com.example.demo;

import com.example.demo.service.SubscribeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubscribeResolver {

    private final Map<PlatformType, SubscribeService> subscribeServiceMap = new HashMap<>();

    public SubscribeResolver(List<SubscribeService> subscribeServices) {
        for (SubscribeService subscribeService : subscribeServices) {
            subscribeServiceMap.put(subscribeService.getPlatformType() ,subscribeService);
        }
    }

    public SubscribeService getSubscribeService(PlatformType platformType) {
        return subscribeServiceMap.get(platformType);
    }

}
