package com.example.demo.service;

import com.example.demo.SubscribeType;
import com.example.demo.model.Subscribe;


public interface SubscribeService {

    Subscribe subscribe(String chanel, int userID);

    Subscribe unsubscribe(String chanel);

    SubscribeType getSubscribeType();

}
