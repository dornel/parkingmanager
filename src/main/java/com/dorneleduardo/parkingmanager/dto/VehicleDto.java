package com.dorneleduardo.parkingmanager.dto;


import jakarta.validation.constraints.NotNull;

public record VehicleDto(@NotNull String brand, @NotNull String model, @NotNull String color, @NotNull String plate, @NotNull String type) {


}
