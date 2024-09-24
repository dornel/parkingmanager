package com.dorneleduardo.parkingmanager.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;


public record CompanyDto(@NotNull  String name , @NotNull String cnpj, @NotNull String address, @NotEmpty String number,@NotNull Long vacancymot, @NotNull Long vacancycars)  {

    public String findBName(String name){
        return name;
            }


}
