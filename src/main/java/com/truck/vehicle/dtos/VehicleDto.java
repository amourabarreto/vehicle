package com.truck.vehicle.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.truck.vehicle.enums.VehicleStatus;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleDto {

    private UUID vehicleId;

    @NotBlank
    private String name;

    @NonNull
    private Integer numTires;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NonNull
    private Integer year;

    @NotBlank
    private String placa;


    private VehicleStatus vehicleStatus;

    @NotNull
    private UUID vehicleTypeId;


    private String imageUrl;
}
