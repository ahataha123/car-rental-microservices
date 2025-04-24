package org.example.carservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private String licensePlate;
    @Column(name = "`year`")
    private int year;
    private double pricePerDayUsd;
    private boolean available = true;
    private Long userId;
    // Constructors
    public Car() {
    }

    public Car(String brand, String model, String licensePlate, int year, double pricePerDayUsd, boolean available) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.year = year;
        this.pricePerDayUsd = pricePerDayUsd;
        this.available = available;
    }

    // Getters and Setters
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
