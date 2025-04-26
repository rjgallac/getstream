package com.example.demo.controller;

import com.example.demo.model.User;
import io.getstream.client.Client;
import io.getstream.client.FlatFeed;
import io.getstream.core.exceptions.StreamException;
import io.getstream.core.models.Activity;
import io.getstream.core.models.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Client client;


    @GetMapping()
    public Data getUser(@RequestParam String userId) throws StreamException {
        return client.user(userId).get().join();
    }

    @PostMapping()
    public void post(@RequestBody User user) throws StreamException {
        client.user(user.getUserId()).create(new Data()
                .set("name", "John Doe")
                .set("occupation", "Software Engineer")
                .set("gender", "male")).join();
    }

    @DeleteMapping
    public void delete(@RequestParam String userId) throws StreamException {
        client.user(userId).delete().join();
    }



}
