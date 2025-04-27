package org.example.common.events;

import java.io.Serializable;

public class CarBookedEvent implements Serializable {
    private String carId;
    private String userId;

    public CarBookedEvent() {}

    public CarBookedEvent(String carId, String userId) {
        this.carId = carId;
        this.userId = userId;
    }

    public String getCarId() {
        return carId;
    }

    public String getUserId() {
        return userId;
    }
}
