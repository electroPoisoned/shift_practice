package com.example.demo.service;

import com.example.demo.model.Subscribe;
import org.springframework.stereotype.Service;

@Service
public class YoutubeSubscribe implements SubscribeService{

    @Override
    public Subscribe subscribe(String chanel) {
        Subscribe subscribe = new Subscribe();

        subscribe.setSubscribed(true);
        subscribe.setChanel(chanel);

        return subscribe;
    }

    @Override
    public Subscribe unsubscribe(String chanel) {
        return null;
    }
}
