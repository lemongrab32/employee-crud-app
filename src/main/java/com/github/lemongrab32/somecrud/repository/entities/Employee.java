package com.github.lemongrab32.somecrud.repository.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email")
    private String email;

    @Column(name = "post")
    private String post;

    @Column(name = "salary")
    private int salary;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "address_id")
    private Address address;

}
