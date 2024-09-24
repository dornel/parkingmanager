package com.dorneleduardo.parkingmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

@Entity
public class CompanyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cnpj;
    private String address;
    private String number;
    private Long vacancymot;
    private Long vacancycars;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getVacancymot() {
        return vacancymot;
    }

    public void setVacancymot(Long vacancymot) {
        this.vacancymot = vacancymot;
    }

    public Long getVacancycars() {
        return vacancycars;
    }

    public void setVacancycars(Long vacancycars) {
        this.vacancycars = vacancycars;
    }
}
