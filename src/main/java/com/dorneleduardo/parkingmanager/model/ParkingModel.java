package com.dorneleduardo.parkingmanager.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;


@Entity
public class ParkingModel {

    @Id
    public String plate;
    public Long companyId;
    public String vehicleType;
    public LocalDateTime localDateTimeEntrance;
    public LocalDateTime localDateTimeExit;

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public LocalDateTime getLocalDateTimeEntrance() {
        return localDateTimeEntrance;
    }

    public void setLocalDateTimeEntrance(LocalDateTime localDateTimeEntrance) {
        this.localDateTimeEntrance = localDateTimeEntrance;
    }

    public LocalDateTime getLocalDateTimeExit() {
        return localDateTimeExit;
    }

    public void setLocalDateTimeExit(LocalDateTime localDateTimeExit) {
        this.localDateTimeExit = localDateTimeExit;
    }
}
