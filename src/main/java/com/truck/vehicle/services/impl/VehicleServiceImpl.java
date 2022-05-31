package com.truck.vehicle.services.impl;

import com.truck.vehicle.models.VehicleModel;
import com.truck.vehicle.repositories.VehicleRepository;
import com.truck.vehicle.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public List<VehicleModel> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Optional<VehicleModel> findById(UUID vehicleId) {
        return vehicleRepository.findById(vehicleId);
    }

    @Override
    public void delete(VehicleModel vehicleModel) {
        vehicleRepository.delete(vehicleModel);
    }

    @Override
    public void save(VehicleModel vehicleModel) {
        vehicleRepository.save(vehicleModel);
    }
}
