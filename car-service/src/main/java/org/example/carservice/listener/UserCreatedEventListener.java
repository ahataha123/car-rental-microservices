package org.example.carservice.listener;

import org.example.carservice.event.UserCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class UserCreatedEventListener {

    @RabbitListener(queues = "${user.queue.name}")
    public void handleUserCreated(UserCreatedEvent event) {
        System.out.println("Car-Service: Neuer User empfangen -> Name: " + event.getName() + ", Email: " + event.getEmail());
    }
}
