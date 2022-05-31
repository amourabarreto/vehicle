package com.truck.vehicle.controllers;

import com.truck.vehicle.dtos.VehicleDto;
import com.truck.vehicle.enums.VehicleStatus;
import com.truck.vehicle.models.VehicleModel;
import com.truck.vehicle.models.VehicleTypeModel;
import com.truck.vehicle.services.VehicleService;
import com.truck.vehicle.services.VehicleTypeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Log4j2
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    VehicleTypeService vehicleTypeService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid VehicleDto vehicleDto){
        log.debug("POST save vehicle VehicleDto RECEIVED {} ", vehicleDto.toString());
        Optional<VehicleTypeModel> vehicleTypeModel = vehicleTypeService.findById(vehicleDto.getVehicleTypeId());
        if(vehicleTypeModel.isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Tipo de veículo não encontrado!");
        }
        var vehicleModel = new VehicleModel();
        BeanUtils.copyProperties(vehicleDto,vehicleModel);
        vehicleModel.setVehicleType(vehicleTypeModel.get());
        vehicleService.save(vehicleModel);
        log.debug("POST save vehicle VehicleDto Saved {} ", vehicleDto.getVehicleId());
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleModel);
    }

    @GetMapping
    public ResponseEntity<List<VehicleModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findAll());
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<Object> getOne(@PathVariable(name = "vehicleId") UUID vehicleId){
        Optional<VehicleModel> vehicleServiceById = vehicleService.findById(vehicleId);
        if (vehicleServiceById.isEmpty()){
          return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veículo não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vehicleServiceById.get());
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<Object> delete(@PathVariable("vehicleId") UUID vehicleId){
        Optional<VehicleModel> vehicleServiceById = vehicleService.findById(vehicleId);
        if (vehicleServiceById.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veículo não encontrado!");
        }
       vehicleService.delete(vehicleServiceById.get());
       return ResponseEntity.status(HttpStatus.OK).body("Veículo deletado com sucesso!");
    }

}
