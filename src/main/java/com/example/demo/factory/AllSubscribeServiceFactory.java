package com.example.demo.factory;

import com.example.demo.service.SubscribeService;
import com.example.demo.service.TelegramSubscribe;
import com.example.demo.service.YoutubeSubscribe;

import java.util.ArrayList;
import java.util.List;
//todo delete
public class AllSubscribeServiceFactory implements SubscribeServiceFactory{


    @Override
    public List<SubscribeService> get() {
        List<SubscribeService> subscribeServices = new ArrayList<>();

        subscribeServices.add(new TelegramSubscribe());
        subscribeServices.add(new YoutubeSubscribe());

        return subscribeServices;
    }
}
