package com.example.demo.factory;

import com.example.demo.service.SubscribeService;

import java.util.List;

public interface SubscribeServiceFactory {
    List<SubscribeService> get();
}
