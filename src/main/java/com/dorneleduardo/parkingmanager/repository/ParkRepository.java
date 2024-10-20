package com.dorneleduardo.parkingmanager.repository;

import com.dorneleduardo.parkingmanager.dto.ParkingDto;
import com.dorneleduardo.parkingmanager.model.ParkingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkRepository extends JpaRepository<ParkingModel,String> {
}
