package com.example.demo.controller;

import com.example.demo.model.Subscribe;
import com.example.demo.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {

    @Qualifier("youtubeSubscribe")
    @Autowired
    private SubscribeService ytSubscribe;

    @Qualifier("telegramSubscribe")
    @Autowired
    private SubscribeService tgSubscribe;

    @GetMapping("/sub")
    public String subscribe() {
        return "Hello, Subscriber!";
    }

    @PostMapping("/subscribe/yt")
    public Subscribe subscribeYT(@RequestParam String chanel) {
        return ytSubscribe.subscribe(chanel);
    }

    @PostMapping("/subscribe/tg")
    public Subscribe subscribeTG(@RequestParam String chanel) {
        return tgSubscribe.subscribe(chanel);
    }

    @PutMapping("/update")
    public String updateResource(@RequestBody String resource) {
        return "Resource updated: " + resource;
    }

    @DeleteMapping("/delete")
    public String deleteResource(@RequestParam String id) {
        return "Resource with id " + id + " deleted.";
    }


}