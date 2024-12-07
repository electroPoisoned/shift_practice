package com.example.demo.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {

    private String name;
    private List<Subscribe> subscribes =  new ArrayList<>();
    private int id;

    public void addSubscribe(Subscribe subscribe) {
        subscribes.add(subscribe);
    }
}
