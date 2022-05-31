package com.truck.vehicle.services;

import com.truck.vehicle.models.VehicleModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleService {
    List<VehicleModel> findAll();

    Optional<VehicleModel> findById(UUID vehiclId);


    void delete(VehicleModel vehicleModel);

    void save(VehicleModel vehicleModel);
}
