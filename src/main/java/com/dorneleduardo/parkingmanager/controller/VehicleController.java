package com.dorneleduardo.parkingmanager.controller;


import com.dorneleduardo.parkingmanager.dto.VehicleDto;
import com.dorneleduardo.parkingmanager.model.VehicleModel;
import com.dorneleduardo.parkingmanager.repository.VehicleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;



    @GetMapping("/vehicle")
    public ResponseEntity<?> findAllVehicles(){

        return ResponseEntity.status(HttpStatus.FOUND).body(vehicleRepository.findAll());

    }

    @GetMapping("/vehicle/{plate}")
    public ResponseEntity<?> findByPlate(@PathVariable String plate){

        if (vehicleRepository.findById(plate).isEmpty()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle with plate "+plate+" NOT found!");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(vehicleRepository.findById(plate));
    }


    @PostMapping("/vehicle")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDto vehicleDto){

        var vehicle1 = new VehicleModel();
        BeanUtils.copyProperties(vehicleDto,vehicle1);
        vehicleRepository.save(vehicle1);

       return ResponseEntity.status(HttpStatus.CREATED).body("Vehicle "+vehicle1.getModel()+" added succesfully!");

    }

    @PutMapping("/vehicle/{plate}")
    public ResponseEntity<?> updateVehicle(@RequestBody VehicleDto vehicleDto, @PathVariable String plate){

       var vehicle1 = vehicleRepository.findById(plate);

        vehicle1.get().setBrand(vehicleDto.brand());
        vehicle1.get().setColor(vehicleDto.color());
        vehicle1.get().setModel(vehicleDto.model());
        vehicle1.get().setType(vehicleDto.type());
        vehicle1.get().setColor(vehicleDto.color());

       vehicleRepository.save(vehicle1.get());
       return ResponseEntity.status(HttpStatus.OK).body("Vehicle "+vehicle1.get().getPlate()+" updated!");

    }

    @DeleteMapping("vehicle/{plate}")
    public ResponseEntity<?> deleteVehicle(@PathVariable String plate){



        if (vehicleRepository.findById(plate).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle with plate "+plate+" NOT FOUND!");
        }else{
            vehicleRepository.deleteById(plate);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle with plate "+plate+" DELETED!");
        }



    }


}
