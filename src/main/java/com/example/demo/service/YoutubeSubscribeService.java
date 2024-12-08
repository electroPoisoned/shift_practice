package com.example.demo.service;

import com.example.demo.PlatformType;
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
public class YoutubeSubscribeService implements SubscribeService {

    private final UserRepository userRepository;
    private final ChannelRepository channelRepository;
    private final SubscriptionRepository subscriptionRepository;

    public YoutubeSubscribeService(UserRepository userRepository, ChannelRepository channelRepository, SubscriptionRepository subscriptionRepository) {
        this.userRepository = userRepository;
        this.channelRepository = channelRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Subscription subscribe(SubscriptionRecord record) {
        Optional<User> optUser = userRepository.findById(record.userId());
        User user = optUser.orElseThrow(() -> new RuntimeException("User not found"));

        Optional<Channel> optChannel = channelRepository.findById(record.channelId());
        Channel channel = optChannel.orElseThrow(() -> new RuntimeException("Channel not found"));

        Subscription subscription = new Subscription(record.channelId(), record.userId(), getPlatformType());
        subscriptionRepository.save(subscription);

        user.addSubscription(channel);
        channel.addSubscriber(user);

        return subscription;
    }

    @Override
    public Subscription unsubscribe(SubscriptionRecord record) {
        Optional<User> optUser = userRepository.findById(record.userId());
        User user = optUser.orElseThrow(() -> new RuntimeException("User not found"));

        Optional<Channel> optChannel = channelRepository.findById(record.channelId());
        Channel channel = optChannel.orElseThrow(() -> new RuntimeException("Channel not found"));

        user.removeSubscription(channel);
        channel.removeSubscriber(user);

        Optional<Subscription> optSubscription = subscriptionRepository.findByUserIdAndChannelId(record.userId(), record.channelId());
        Subscription subscription = optSubscription.orElseThrow(() -> new RuntimeException("Subscription not found"));

        subscriptionRepository.deleteById(subscription.getSubscriptionId());

        return subscription;
    }

    @Override
    public PlatformType getPlatformType() {
        return PlatformType.YT;
    }
}
