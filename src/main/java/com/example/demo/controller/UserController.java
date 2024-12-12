package com.example.demo.controller;

import com.example.demo.exceptions.custom.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ExceptionHandler(UserNotFoundException.class)
    @GetMapping
    public ResponseEntity<User> getUser(@RequestParam String id){
        return new ResponseEntity<>(userService.findUser(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.findAllUser(), HttpStatus.OK);
    }

    //TODO
    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return user;
    }

    @DeleteMapping
    public void deleteUser(@RequestParam String id){
        userService.deleteUser(id);
    }

}
