package com.github.lemongrab32.somecrud.services;

import com.github.lemongrab32.somecrud.dto.AddressDto;
import com.github.lemongrab32.somecrud.dto.EmployeeDto;
import com.github.lemongrab32.somecrud.repository.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    void save(EmployeeDto person, AddressDto address);
    void save(Employee employee);
    void deleteById(Long id);

}
