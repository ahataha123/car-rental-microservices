package org.example.userservice.publisher;

import org.example.userservice.event.UserCreatedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    @Value("${user.queue.name}")
    private String queueName;

    public UserEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishUserCreated(UserCreatedEvent event) {
        rabbitTemplate.convertAndSend(queueName, event);
    }
}
