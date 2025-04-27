package org.example.carservice.listener;

import org.example.carservice.repository.CarRepository;
import org.example.common.events.CarBookedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CarBookedEventListener {

    private final CarRepository carRepository;

    public CarBookedEventListener(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @RabbitListener(queues = "${car.booking.queue.name}")
    public void handleCarBooked(CarBookedEvent event) {
        var car = carRepository.findById(Long.parseLong(event.getCarId()))
                .orElseThrow(() -> new RuntimeException("Car not found"));

        car.setAvailable(false);
        car.setUserId(Long.parseLong(event.getUserId()));
        carRepository.save(car);

        System.out.println("Car marked as booked: " + car.getId() + " by User ID: " + car.getUserId());

    }
}
