package org.example.bookingservice.controller;

import org.example.bookingservice.dto.BookingRequest;
import org.example.bookingservice.dto.BookingResponse;
import org.example.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public BookingResponse bookCar(@RequestBody BookingRequest request) {
        return bookingService.bookCar(request);
    }

    @GetMapping
    public List<BookingResponse> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/user/{userId}")
    public List<BookingResponse> getBookingsByUser(@PathVariable Long userId) {
        return bookingService.getBookingsByUser(userId);
    }

    @GetMapping("/car/{carId}")
    public List<BookingResponse> getBookingsByCar(@PathVariable Long carId) {
        return bookingService.getBookingsByCar(carId);
    }

    @PutMapping("/{bookingId}/return")
    public ResponseEntity<String> returnCar(@PathVariable Long bookingId) {
        try {
            bookingService.returnCar(bookingId);
            return ResponseEntity.ok("Car returned successfully.");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
