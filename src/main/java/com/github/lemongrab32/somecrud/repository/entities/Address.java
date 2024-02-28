package com.github.lemongrab32.somecrud.repository.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer apartmentNumber;
    private String postalCode;

    @OneToOne(mappedBy = "address")
    private Employee employee;

}
