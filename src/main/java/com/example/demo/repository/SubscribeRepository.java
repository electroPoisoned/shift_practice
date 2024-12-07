package com.example.demo.repository;

import com.example.demo.model.Subscribe;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SubscribeRepository {

    private final Map<String, Subscribe> subscribes = new HashMap<>();

    public void save(Subscribe subscribe) {
        subscribes.put(subscribe.getChanel(), subscribe);
    }

    public void delete(Subscribe subscribe) {
        subscribes.remove(subscribe.getChanel());
    }
}
