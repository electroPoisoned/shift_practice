package com.example.demo.service;

import com.example.demo.PlatformType;
import com.example.demo.model.Subscription;
import com.example.demo.repository.SubscriptionRecord;


public interface SubscribeService {

    Subscription subscribe(SubscriptionRecord subscriptionRecord);

    Subscription unsubscribe(SubscriptionRecord subscriptionRecord);

    PlatformType getPlatformType();

}
