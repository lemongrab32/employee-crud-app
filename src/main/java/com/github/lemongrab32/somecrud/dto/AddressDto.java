package com.github.lemongrab32.somecrud.dto;

import lombok.Data;

@Data
public class AddressDto {

    private String country;
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer apartmentNumber;
    private String postalCode;

}
