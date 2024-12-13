package com.example.demo.controller;

import com.example.demo.model.Channel;
import com.example.demo.service.ChannelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/channels")
public class ChannelController {

    private final ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Channel> getChannel(@PathVariable String id) {
        return ResponseEntity.ok(channelService.findChannel(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Channel>> getAllChannels() {
        return ResponseEntity.ok(channelService.findAllChannels());
    }

    @PostMapping("/create")
    public ResponseEntity<Channel> createChannel(@RequestBody Channel channel) {
        return ResponseEntity.ok(channelService.saveChannel(channel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteChannel(@PathVariable String id) {
        return ResponseEntity.ok(channelService.deleteChannel(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Channel> updateChannel(@PathVariable String id, @RequestBody Channel updatedChannel) {
        return ResponseEntity.ok(channelService.updateChannel(id, updatedChannel));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Channel> patchChannel(@PathVariable String id, @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(channelService.patchChannel(id, updates));
    }

}
