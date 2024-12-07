package com.example.demo.service;

import com.example.demo.SubscribeType;
import com.example.demo.model.Subscribe;
import com.example.demo.model.User;
import com.example.demo.repository.SubscribeRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class TelegramSubscribeService implements SubscribeService{

    UserRepository userRepository;

    public TelegramSubscribeService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Subscribe subscribe(String chanel, int userID) {
        Subscribe subscribe = new Subscribe();

        subscribe.setSubscribed(true);
        subscribe.setChanel(chanel);

        User user = new User();

        user.addSubscribe(subscribe);

        userRepository.save(user);

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
        return SubscribeType.TG;
    }
}
