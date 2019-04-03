package com.demo.controllers;

import com.demo.domain.UserRequest;
import com.demo.producer.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Sender sender;

    @Autowired
    KafkaController(Sender sender) {
        this.sender = sender;
    }

    @PostMapping(value = "demo")
    public void sendSchemaRegistryToKafkaTopic(@RequestBody UserRequest request) {
        example.avro.User user = example.avro.User.newBuilder()
                .setName(request.getName())
                .setFavoriteColor(request.getFavoriteColor())
                .setId(request.getId())
                .build();
        this.sender.sendMessage(user);
    }
}
