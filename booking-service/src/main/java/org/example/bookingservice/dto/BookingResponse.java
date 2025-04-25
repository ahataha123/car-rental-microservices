package org.example.bookingservice.dto;

import java.time.LocalDate;

public class BookingResponse {

    private Long bookingId;
    private Long userId;
    private Long carId;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalCostUsd;


    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getTotalCostUsd() {
        return totalCostUsd;
    }

    public void setTotalCostUsd(double totalCostUsd) {
        this.totalCostUsd = totalCostUsd;
    }

}
