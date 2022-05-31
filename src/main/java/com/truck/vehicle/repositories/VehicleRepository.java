package com.truck.vehicle.repositories;

import com.truck.vehicle.models.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VehicleRepository extends JpaRepository<VehicleModel, UUID> {
}
