package com.example.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: yanlianglong
 * @create: 2020-12-02 17:30
 **/
@RestController
public class TestController {

    @Autowired
    private RabbitMqClient rabbitMqClient;

    @GetMapping("/send")
    public void send(String messages) {
        rabbitMqClient.sendStatistics(messages);
    }

}
