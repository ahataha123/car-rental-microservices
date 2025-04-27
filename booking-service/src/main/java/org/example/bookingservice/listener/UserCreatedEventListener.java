package org.example.bookingservice.listener;

import org.example.bookingservice.event.UserCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class UserCreatedEventListener {

    @RabbitListener(queues = "${user.queue.name}")
    public void handleUserCreated(UserCreatedEvent event) {
        System.out.println("Booking-Service: Neuer User erstellt -> Name: " + event.getName() + ", Email: " + event.getEmail());
    }
}
