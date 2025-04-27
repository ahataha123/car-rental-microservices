package org.example.bookingservice.publisher;

import org.example.common.events.CarBookedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CarBookingPublisher {

    private final RabbitTemplate rabbitTemplate;

    @Value("${car.booking.queue.name}")
    private String queueName;

    public CarBookingPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishCarBookedEvent(CarBookedEvent event) {
        rabbitTemplate.convertAndSend(queueName, event);
    }
}
