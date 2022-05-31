package com.truck.vehicle.services;

import com.truck.vehicle.models.VehicleTypeModel;

import java.util.Optional;
import java.util.UUID;

public interface VehicleTypeService {
    Optional<VehicleTypeModel> findById(UUID vehicleId);
}
