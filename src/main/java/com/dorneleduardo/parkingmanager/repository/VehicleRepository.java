package com.dorneleduardo.parkingmanager.repository;

import com.dorneleduardo.parkingmanager.model.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehicleRepository extends JpaRepository<VehicleModel,String> {


}
