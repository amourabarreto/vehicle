package com.truck.vehicle.services.impl;

import com.truck.vehicle.models.VehicleTypeModel;
import com.truck.vehicle.repositories.VehicleTypeRepository;
import com.truck.vehicle.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {

    @Autowired
    VehicleTypeRepository vehicleTypeRepository;
    @Override
    public Optional<VehicleTypeModel> findById(UUID vehicleId) {
        return vehicleTypeRepository.findById(vehicleId);
    }
}
