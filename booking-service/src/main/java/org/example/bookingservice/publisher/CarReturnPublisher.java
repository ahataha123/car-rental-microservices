package org.example.bookingservice.publisher;

import org.example.common.events.CarReturnedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CarReturnPublisher {

    private final RabbitTemplate rabbitTemplate;

    @Value("${car.return.queue.name}")  // eigene Queue für Rückgabe!
    private String returnQueueName;

    public CarReturnPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishCarReturnedEvent(CarReturnedEvent event) {
        rabbitTemplate.convertAndSend(returnQueueName, event);
    }
}
