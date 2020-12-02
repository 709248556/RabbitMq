package com.example.rabbitmq;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
/**
 * @author nature
 */
@Slf4j
@Component
public class RabbitMqClient {

    @Resource
    private AmqpTemplate amqpTemplate;

    /**
     * 发送统计消息
     */
    public void sendStatistics(Object message) {
        try {
            if (message != null) {
                String messageJson = JSON.toJSONString(message);
                log.info("发送消息到消息队列：" + messageJson);
                amqpTemplate.convertAndSend(RabbitMqConstant.EXCHANGE_STATISTICS, RabbitMqConstant.QUEUE_STATISTICS, messageJson);
            }
        } catch (AmqpException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
