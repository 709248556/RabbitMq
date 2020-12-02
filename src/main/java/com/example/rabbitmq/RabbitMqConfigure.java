package com.example.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfigure {

    @Bean(name = "statistics")
    public Queue queueStatistics() {
        return new Queue(RabbitMqConstant.QUEUE_STATISTICS,true);
    }

    @Bean
    public TopicExchange exchangeStatistics() {
        return new TopicExchange(RabbitMqConstant.EXCHANGE_STATISTICS);
    }

    @Bean
    public Binding bindingExchangeMessage(@Qualifier("statistics") Queue statistics, TopicExchange exchange) {
        return BindingBuilder.bind(statistics).to(exchange).with(RabbitMqConstant.EXCHANGE_STATISTICS_KEY);
    }
}
