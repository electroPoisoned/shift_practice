package com.example.demo.service;

import com.example.demo.PlatformType;
import com.example.demo.exceptions.custom.ChannelNotFoundException;
import com.example.demo.exceptions.custom.SubscriptionNotFoundException;
import com.example.demo.exceptions.custom.UserNotFoundException;
import com.example.demo.model.Channel;
import com.example.demo.model.Subscription;
import com.example.demo.model.User;
import com.example.demo.repository.ChannelRepository;
import com.example.demo.repository.SubscriptionRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.SubscriptionRecord;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TelegramSubscribeService implements SubscribeService {

    private final UserRepository userRepository;
    private final ChannelRepository channelRepository;
    private final SubscriptionRepository subscriptionRepository;

    public TelegramSubscribeService(UserRepository userRepository, ChannelRepository channelRepository, SubscriptionRepository subscriptionRepository) {
        this.userRepository = userRepository;
        this.channelRepository = channelRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Subscription subscribe(SubscriptionRecord record) {
        Optional<User> optUser = userRepository.findById(record.userId());
        User user = optUser.
                orElseThrow(() -> new UserNotFoundException("User Not Found"));

        Optional<Channel> optChannel = channelRepository.findById(record.channelId());
        Channel channel = optChannel.
                orElseThrow(() -> new ChannelNotFoundException("Channel Not Found"));

        Subscription subscription = new Subscription(record.channelId(), record.userId(), getPlatformType());
        subscriptionRepository.save(subscription);

        user.addSubscription(channel);
        channel.addSubscriber(user);

        return subscription;
    }

    @Override
    public Subscription unsubscribe(SubscriptionRecord record) {
        Optional<User> optUser = userRepository.findById(record.userId());
        User user = optUser.
                orElseThrow(() -> new UserNotFoundException("User Not Found"));

        Optional<Channel> optChannel = channelRepository.findById(record.channelId());
        Channel channel = optChannel.
                orElseThrow(() -> new ChannelNotFoundException("Channel Not Found"));

        user.removeSubscription(channel);
        channel.removeSubscriber(user);

        Optional<Subscription> optSubscription = subscriptionRepository.findByUserIdAndChannelId(record.userId(), record.channelId());
        Subscription subscription = optSubscription.
                orElseThrow(() -> new SubscriptionNotFoundException("Subscription Not Found"));

        subscriptionRepository.deleteById(subscription.getId());

        return subscription;
    }

    @Override
    public PlatformType getPlatformType() {
        return PlatformType.TG;
    }
}
