package org.example.bookingservice.service;

import org.example.bookingservice.dto.BookingRequest;
import org.example.bookingservice.dto.BookingResponse;
import org.example.bookingservice.model.Booking;
import org.example.bookingservice.publisher.CarBookingPublisher;
import org.example.bookingservice.publisher.CarReturnPublisher;
import org.example.bookingservice.repository.BookingRepository;
import org.example.common.events.CarBookedEvent;
import org.example.common.events.CarReturnedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CarBookingPublisher carBookingPublisher;
    @Autowired
    private CarReturnPublisher carReturnPublisher;



    public BookingService(BookingRepository bookingRepository) {
    }

    public BookingResponse bookCar(BookingRequest request) {
        Booking booking = new Booking();
        booking.setUserId(request.getUserId());
        booking.setCarId(request.getCarId());
        booking.setStartDate(request.getStartDate());
        booking.setEndDate(request.getEndDate());
        booking.setPricePerDayUsd(request.getPricePerDayUsd());

        long duration = java.time.temporal.ChronoUnit.DAYS.between(request.getStartDate(), request.getEndDate());
        double totalCost = duration * request.getPricePerDayUsd();
        booking.setTotalCostUsd(totalCost);

        Booking saved = bookingRepository.save(booking);

        //Nach dem Speichern, Event schicken
        carBookingPublisher.publishCarBookedEvent(
                new CarBookedEvent(saved.getCarId().toString(), saved.getUserId().toString())
        );
        return mapToResponse(saved);
    }

    public List<BookingResponse> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public List<BookingResponse> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public List<BookingResponse> getBookingsByCar(Long carId) {
        return bookingRepository.findByCarId(carId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public void returnCar(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + bookingId));

        if (booking.isReturned()) {
            throw new IllegalStateException("Car has already been returned for this booking.");
        }

        booking.setReturned(true);
        bookingRepository.save(booking);

        //Neues Event verschicken:
        CarReturnedEvent event = new CarReturnedEvent(
                booking.getCarId().toString(),
                booking.getUserId().toString()
        );

        carReturnPublisher.publishCarReturnedEvent(event);
        System.out.println("CarReturnedEvent published for Car ID: " + booking.getCarId() + ", returned by User ID: " + booking.getUserId());

    }

    private BookingResponse mapToResponse(Booking booking) {
        BookingResponse response = new BookingResponse();
        response.setBookingId(booking.getId());
        response.setUserId(booking.getUserId());
        response.setCarId(booking.getCarId());
        response.setStartDate(booking.getStartDate());
        response.setEndDate(booking.getEndDate());
        response.setTotalCostUsd(booking.getPricePerDayUsd());
        response.setTotalCostUsd(booking.getTotalCostUsd());
        return response;
    }
}
