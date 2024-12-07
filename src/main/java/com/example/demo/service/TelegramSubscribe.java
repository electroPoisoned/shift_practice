package com.example.demo.service;

import com.example.demo.model.Subscribe;
import org.springframework.stereotype.Service;

@Service
public class TelegramSubscribe implements SubscribeService{

    @Override
    public Subscribe subscribe(String chanel) {
        return null;
    }

    @Override
    public Subscribe unsubscribe(String chanel) {
        return null;
    }
}
