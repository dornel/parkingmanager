package com.dorneleduardo.parkingmanager.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ParkingDto(@NotNull String plate , @NotNull String vehicleType , @NotEmpty Long companyId) {




}
