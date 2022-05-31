package com.truck.vehicle.repositories;

import com.truck.vehicle.models.VehicleTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VehicleTypeRepository extends JpaRepository<VehicleTypeModel, UUID> {
}
