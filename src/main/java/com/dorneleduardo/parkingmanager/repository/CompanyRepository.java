package com.dorneleduardo.parkingmanager.repository;

import com.dorneleduardo.parkingmanager.model.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyModel,Long> {

   List<?> findByName(String name);


}
