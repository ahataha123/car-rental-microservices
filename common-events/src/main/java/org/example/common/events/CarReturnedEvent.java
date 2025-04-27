package org.example.common.events;

import java.io.Serializable;

public class CarReturnedEvent implements Serializable {
    private String carId;
    private String userId;

    public CarReturnedEvent() {
    }

    public CarReturnedEvent(String carId, String userId) {
        this.carId = carId;
        this.userId = userId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
