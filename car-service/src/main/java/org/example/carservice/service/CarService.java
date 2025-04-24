package org.example.carservice.service;

import org.example.carservice.dto.CarRequest;
import org.example.carservice.dto.CarResponse;
import org.example.carservice.model.Car;
import org.example.carservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;
    private CarResponse mapToResponse(Car car) {
        CarResponse response = new CarResponse();
        response.setId(car.getId());
        response.setBrand(car.getBrand());
        response.setModel(car.getModel());
        response.setYear(car.getYear());
        response.setLicensePlate(car.getLicensePlate());
        response.setAvailable(car.isAvailable());
        response.setPricePerDayUsd(car.getPricePerDayUsd());
        response.setUserId(car.getUserId());
        return response;
    }

    // Save a new car
    public CarResponse addCar(CarRequest request) {
        Car car = new Car();
        car.setBrand(request.getBrand());
        car.setModel(request.getModel());
        car.setLicensePlate(request.getLicensePlate());
        car.setYear(request.getYear());
        car.setAvailable(request.isAvailable());
        car.setPricePerDayUsd(request.getPricePerDayUsd());
        car.setUserId(request.getUserId());

        Car saved = carRepository.save(car);
        return mapToResponse(saved); // this method maps Car -> CarResponse
    }


    public List<CarResponse> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public List<CarResponse> getAvailableCars() {
        return carRepository.findByAvailableTrue()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public List<CarResponse> getCarsByUserId(Long userId) {
        return carRepository.findByUserId(userId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // Get a car by its ID
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    // Update car availability or any other field
    public Car updateCar(Car car) {
        return carRepository.save(car);
    }
}
