package com.dorneleduardo.parkingmanager.controller;

import com.dorneleduardo.parkingmanager.dto.CompanyDto;
import com.dorneleduardo.parkingmanager.model.CompanyModel;
import com.dorneleduardo.parkingmanager.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:5500")
public class CompanyController {


    @Autowired
    CompanyRepository companyRepository;

    @PutMapping(value = "/company/{id}")
    public ResponseEntity<?> updateCompany(@PathVariable Long id , @RequestBody CompanyDto companyDto){

        var company1 = companyRepository.findById(id);


        company1.get().setName(companyDto.name());
        company1.get().setCnpj(companyDto.cnpj());
        company1.get().setAddress(companyDto.address());
        company1.get().setNumber(companyDto.number());
        company1.get().setVacancymot(companyDto.vacancymot());
        company1.get().setVacancycars(companyDto.vacancycars());


        companyRepository.save(company1.get());


        return ResponseEntity.status(HttpStatus.OK).body("Company "+id+" updated!");



    }


    @PostMapping(value = "/company")
    public ResponseEntity<CompanyModel> addCompany(@RequestBody CompanyDto companyDto){

        var company1 = new CompanyModel();

        company1.setName(companyDto.name());
        company1.setAddress(companyDto.address());
        company1.setCnpj(companyDto.cnpj());
        company1.setNumber(companyDto.number());
        company1.setVacancymot(companyDto.vacancymot());
        company1.setVacancycars(companyDto.vacancycars());


        return ResponseEntity.status(HttpStatus.CREATED).body(companyRepository.save(company1));

    }

    @GetMapping(value = "/company")
    public ResponseEntity<?> getAllCompanies(){

       return ResponseEntity.status(HttpStatus.FOUND).body(companyRepository.findAll());

            }

    @GetMapping(value = "/company/{id}")
    public ResponseEntity<?> getOneCompany(@PathVariable Long id){


        if (companyRepository.findById(id).isPresent()){

            return ResponseEntity.status(HttpStatus.FOUND).body(companyRepository.findById(id));

        } return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company with ID "+id+" not found!");

    }

    @DeleteMapping(value = "/company/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long id){

        companyRepository.deleteById(id);

    return ResponseEntity.status(HttpStatus.FOUND).body("Company with id "+id+ " deleted!");

    }




}
