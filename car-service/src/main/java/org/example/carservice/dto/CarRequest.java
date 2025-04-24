package org.example.carservice.dto;

import jakarta.validation.constraints.*;

public class CarRequest {

    @NotBlank(message = "Brand is required")
    private String brand;

    @NotBlank(message = "Model is required")
    private String model;

    @NotBlank(message = "License plate is required")
    private String licensePlate;

    @Min(value = 1886, message = "Year must be a valid year (>= 1886)")
    @Max(value = 2100, message = "Year must be reasonable")
    private int year;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price per day must be greater than 0")
    private double pricePerDayUsd;

    private boolean available;

    private Long userId;
    // Getters and Setters

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPricePerDayUsd() {
        return pricePerDayUsd;
    }

    public void setPricePerDayUsd(double pricePerDayUsd) {
        this.pricePerDayUsd = pricePerDayUsd;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
