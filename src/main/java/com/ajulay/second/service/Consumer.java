package com.ajulay.second.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {


    @KafkaListener(topics = "SECOND", groupId = "second")
    public void consume(String message) throws IOException {
        System.out.println("Get... " + message);
    }
}