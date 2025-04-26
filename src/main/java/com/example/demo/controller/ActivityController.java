package com.example.demo.controller;

import com.example.demo.model.Message;
import io.getstream.client.Client;
import io.getstream.client.FlatFeed;
import io.getstream.core.exceptions.StreamException;
import io.getstream.core.models.Activity;
import io.getstream.core.options.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {


    @Autowired
    private Client client;

    @PostMapping()
    public String add(@RequestBody Message message) throws StreamException {
        FlatFeed feed = client.flatFeed(message.getFeedSlug(), message.getUserId());
        try {
            feed.addActivity(
                    Activity.builder()
                            .actor(message.getUserId()).verb("add")
                            .object("picture:10").foreignID("picture:10")
                            .extraField("message", message).build()
            ).join();
        } catch (
                StreamException e) {
            throw new RuntimeException(e);
        }
        return "Success";
    }

}
