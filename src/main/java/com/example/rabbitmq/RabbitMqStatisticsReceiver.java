package com.example.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author nature
 */
@Slf4j
@Component
@RabbitListener(queues = RabbitMqConstant.QUEUE_STATISTICS)
public class RabbitMqStatisticsReceiver {


    @RabbitHandler
    public void process(String message) {
        log.info("收到消息:" + message);
    }
}
