package com.example.demo.service;

import com.example.demo.model.Subscribe;
import org.springframework.stereotype.Service;

public interface SubscribeService {

    Subscribe subscribe(String chanel);

    Subscribe unsubscribe(String chanel);
}
