package org.example.carservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class RabbitMQConfig {

    @Value("${car.booking.queue.name}")
    private String queueName;
    @Value("${car.return.queue.name}")
    private String returnQueueName;

    @Bean
    public Queue carBookingQueue() { // <- Name angepasst
        return new Queue(queueName, false);
    }
    @Bean
    public Queue carReturnQueue() {return new Queue(returnQueueName, false);}

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
