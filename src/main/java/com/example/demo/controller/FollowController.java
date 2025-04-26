package com.example.demo.controller;

import com.example.demo.model.Follow;
import io.getstream.client.Client;
import io.getstream.client.FlatFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    private Client client;

    @PostMapping()
    public void follow(@RequestBody Follow follow) throws Exception {
        FlatFeed users = client.flatFeed(follow.getFeedSlug(), follow.getFollowerId());
        FlatFeed feed = client.flatFeed(follow.getFeedSlug(), follow.getUserId());
        users.follow(feed).join();
    }



}
