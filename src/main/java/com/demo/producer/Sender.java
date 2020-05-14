package com.demo.producer;

import example.avro.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    private static final String TOPIC = "users-demo";

    @Value("${spring.kafka.topic.avro}")
    private String avroTopic;

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void send(example.avro.User user) {
        LOGGER.info("sending user='{}'", user.toString());
        kafkaTemplate.send(avroTopic, user);
    }

    public void sendMessage(User user) {
        LOGGER.info(String.format("#### -> Producing message -> %s", user.toString()));
        this.kafkaTemplate.send(TOPIC, user);
    }

    /**
     * SQL
     */
}
