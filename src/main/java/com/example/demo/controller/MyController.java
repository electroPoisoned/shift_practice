package com.example.demo.controller;

import com.example.demo.SubscribeResolver;
import com.example.demo.SubscribeType;
import com.example.demo.model.Subscribe;
import com.example.demo.model.User;
import com.example.demo.service.SubscribeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class MyController {

    private SubscribeResolver subscribeResolver;

    public MyController(SubscribeResolver subscribeResolver) {
        this.subscribeResolver = subscribeResolver;
    }

    @PostMapping("/subscribe")
    public Subscribe subscribe(@RequestParam String platform, @RequestParam String chanelName, @RequestBody int userID) {
        SubscribeService subscribeService = subscribeResolver.getSubscribeService(SubscribeType.valueOf(platform.toUpperCase()));

        return subscribeService.subscribe(chanelName, userID);
    }

//    @PutMapping("/update")
//    public String updateResource(@RequestBody String resource) {
//        return "Resource updated: " + resource;
//    }
//
//    @DeleteMapping("/delete")
//    public String deleteResource(@RequestParam String id) {
//        return "Resource with id " + id + " deleted.";
//    }


}