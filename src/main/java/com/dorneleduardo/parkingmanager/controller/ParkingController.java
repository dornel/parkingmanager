package com.dorneleduardo.parkingmanager.controller;


import com.dorneleduardo.parkingmanager.dto.ParkingDto;
import com.dorneleduardo.parkingmanager.model.ParkingModel;
import com.dorneleduardo.parkingmanager.repository.CompanyRepository;
import com.dorneleduardo.parkingmanager.repository.ParkRepository;
import com.dorneleduardo.parkingmanager.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;


@RestController
@CrossOrigin(origins = "http://localhost:5500")
public class ParkingController implements Serializable {

    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    ParkRepository parkRepository;



    @PostMapping("/parking/entrance")
    ResponseEntity<?> parkVehicle(@RequestBody ParkingDto parkingDto) {

        var company1 = companyRepository.findById(parkingDto.companyId());
        var vehicle1 = vehicleRepository.findById(parkingDto.plate());

        if (!parkingDto.vehicleType().equals("car")){
            return ResponseEntity.status(HttpStatus.CREATED).body("Vehicle type not allowed!");
        }
        else if (!vehicle1.isPresent()){

            return ResponseEntity.status(HttpStatus.CREATED).body("Vehicle is not in the database!");

        } else if (company1.get().getVacancycars() == 0) {

                return ResponseEntity.status(HttpStatus.CREATED).body("There is no vacancy in the parking lot!");

        }else{

                var vacancys1 = company1.get().getVacancycars();
                company1.get().setVacancycars(vacancys1 - 1);


                var park1 = new ParkingModel();

                park1.setCompanyId(parkingDto.companyId());
                park1.setPlate(parkingDto.plate());
                park1.setVehicleType(parkingDto.vehicleType());
                park1.setLocalDateTimeEntrance(LocalDateTime.now());
                parkRepository.save(park1);
                return ResponseEntity.status(HttpStatus.CREATED).body("Vehicle parked successfully");
            }

        }

        @PostMapping("/parking/exit/{plate}")
        ResponseEntity<?> unparkVehicle(@PathVariable String plate){

        var company0 = parkRepository.findById(plate);

        if(company0.isEmpty()){

           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This car is not parked!");

        }else {



            var car1 = parkRepository.findById(plate);
            var company1 = companyRepository.findById(car1.get().companyId);


            company1.get().setVacancycars(company1.get().getVacancycars() + 1);
            car1.get().setLocalDateTimeExit(LocalDateTime.now());

            parkRepository.save(car1.get());
            companyRepository.save(company1.get());



            return ResponseEntity.status(HttpStatus.OK).body("Car unparked succesfully");
        }



    }



    @GetMapping("/reports/{plate}")
    ResponseEntity<?> reports(@PathVariable String plate){


        var parking1 = parkRepository.findById(plate);

        Duration duration = Duration.between(parking1.get().getLocalDateTimeEntrance(),parking1.get().getLocalDateTimeExit());

        long duration1 = duration.toHours();


        return ResponseEntity.status(HttpStatus.OK).body("The car "+plate+" has been parked for "+duration1+" hours!");
    }


        @GetMapping("/parking")
        ResponseEntity<?> getParkedVehicles () {

        if (!parkRepository.findAll().isEmpty()){

            return ResponseEntity.status(HttpStatus.OK).body(parkRepository.findAll());


        } return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No vehicles parked here");


        }




    }


