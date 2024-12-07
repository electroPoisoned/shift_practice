package com.example.demo.service;

import com.example.demo.SubscribeType;
import com.example.demo.model.Subscribe;
import org.springframework.stereotype.Service;

@Service
public class YoutubeSubscribeService implements SubscribeService{

    @Override
    public Subscribe subscribe(String chanel, int id) {
        Subscribe subscribe = new Subscribe();

        subscribe.setSubscribed(true);
        subscribe.setChanel(chanel);

        return subscribe;
    }

    @Override
    public Subscribe unsubscribe(String chanel) {
        Subscribe subscribe = new Subscribe();

        subscribe.setSubscribed(false);
        subscribe.setChanel(chanel);

        return subscribe;
    }

    @Override
    public SubscribeType getSubscribeType() {
        return SubscribeType.YT;
    }
}
