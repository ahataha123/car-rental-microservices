package org.example.carservice.controller;

import jakarta.validation.Valid;
import org.example.carservice.dto.CarRequest;
import org.example.carservice.dto.CarResponse;
import org.example.carservice.model.Car;
import org.example.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public ResponseEntity<CarResponse> addCar(@RequestBody @Valid CarRequest request) {
        return ResponseEntity.ok(carService.addCar(request));
    }

    @GetMapping
    public ResponseEntity<List<CarResponse>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/available")
    public ResponseEntity<List<CarResponse>> getAvailableCars() {
        return ResponseEntity.ok(carService.getAvailableCars());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CarResponse>> getCarsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(carService.getCarsByUserId(userId));
    }
    @GetMapping("/{carId}/available")
    public ResponseEntity<Boolean> isCarAvailable(@PathVariable Long carId) {
        Optional<Car> carOpt = carService.getCarById(carId);
        if (carOpt.isPresent()) {
            return ResponseEntity.ok(carOpt.get().isAvailable());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
