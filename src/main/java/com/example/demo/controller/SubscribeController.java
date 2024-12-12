package com.example.demo.controller;

import com.example.demo.SubscribeResolver;
import com.example.demo.model.Subscription;
import com.example.demo.repository.SubscriptionRecord;
import com.example.demo.service.SubscribeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sub")
public class SubscribeController {

    private final SubscribeResolver subscribeResolver;

    public SubscribeController(SubscribeResolver subscribeResolver) {
        this.subscribeResolver = subscribeResolver;
    }

    @PostMapping("/subscribe")
    public Subscription subscribe(@RequestBody SubscriptionRecord record) {
        SubscribeService subscribeService = subscribeResolver.getSubscribeService(record.platformType());
        return subscribeService.subscribe(record);
    }

    @PostMapping("/unsubscribe")
    public Subscription unsubscribe(@RequestBody SubscriptionRecord record) {
        SubscribeService subscribeService = subscribeResolver.getSubscribeService(record.platformType());
        return subscribeService.unsubscribe(record);
    }
}
