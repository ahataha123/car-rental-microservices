package org.example.carservice.listener;

import org.example.common.events.CarReturnedEvent;
import org.example.carservice.repository.CarRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CarReturnedEventListener {

    private final CarRepository carRepository;

    public CarReturnedEventListener(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @RabbitListener(queues = "${car.return.queue.name}")
    public void handleCarReturned(CarReturnedEvent event) {
        var car = carRepository.findById(Long.parseLong(event.getCarId()))
                .orElseThrow(() -> new RuntimeException("Car not found"));

        car.setAvailable(true);
        car.setUserId(null);  // Benutzerbindung lösen
        carRepository.save(car);

        System.out.println("Car marked as available again: " + car.getId());
    }
}
