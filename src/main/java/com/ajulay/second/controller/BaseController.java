package com.ajulay.second.controller;

import com.ajulay.second.model.Message;
import com.ajulay.second.service.Producer;
import lombok.AllArgsConstructor;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/second")
@AllArgsConstructor
public class BaseController {

private final Producer producer;

    @GetMapping("/hello")
    public String sayHello(@RequestParam(required = false) String name) throws ExecutionException, InterruptedException {
        String content = String.format("Hello, %s!", name);
        ListenableFuture<SendResult<String, String>> sendResultListenableFuture = producer.sendMessage("INPUT_DATA", "IN_KEY", new Message().setContent(content).toString());

        return sendResultListenableFuture.get().toString();
    }
}
