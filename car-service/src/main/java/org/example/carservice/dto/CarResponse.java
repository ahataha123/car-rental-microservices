package org.example.carservice.dto;

public class CarResponse {
    private Long id;
    private String brand;
    private String model;
    private String licensePlate;
    private int year;
    private double pricePerDayUsd;
    private boolean available;
    private Long userId;

    public CarResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
