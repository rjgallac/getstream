package com.example.demo.controller;

import io.getstream.client.Client;
import io.getstream.client.FlatFeed;
import io.getstream.core.exceptions.StreamException;
import io.getstream.core.models.Activity;
import io.getstream.core.options.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/feed")
public class FeedController {


    @Autowired
    private Client client;

    @GetMapping("/{feedSlug}/{userId}/")
    public List<Activity> getFeed(@PathVariable String feedSlug, @PathVariable String userId) throws StreamException {
        FlatFeed feed = client.flatFeed(feedSlug, userId);

        List<Activity> response = new ArrayList<>();
        try {
            response = feed.getActivities(new Pagination().limit(10)).join();
        } catch (StreamException e) {
            throw new RuntimeException(e);
        }

        return response;
    }


}
