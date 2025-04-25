package org.example.bookingservice.repository;

import org.example.bookingservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);
    List<Booking> findByCarId(Long carId);
    List<Booking> findByReturnedFalse();
}
