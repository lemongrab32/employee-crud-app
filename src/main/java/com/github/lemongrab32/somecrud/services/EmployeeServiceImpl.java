package com.github.lemongrab32.somecrud.services;

import com.github.lemongrab32.somecrud.dto.AddressDto;
import com.github.lemongrab32.somecrud.dto.EmployeeDto;
import com.github.lemongrab32.somecrud.repository.EmployeeRepository;
import com.github.lemongrab32.somecrud.repository.entities.Address;
import com.github.lemongrab32.somecrud.repository.entities.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final AddressService addressService;

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employeeRepository.findAll());
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(EmployeeDto person, AddressDto location) {
        Employee employee = new Employee();
        Address address = new Address();
        employee.setFirstName(person.getFirstName());
        employee.setLastName(person.getLastName());
        employee.setGender(person.getGender());
        employee.setEmail(person.getEmail());
        employee.setPost(person.getPost());
        employee.setSalary(person.getSalary());
        address.setCountry(location.getCountry());
        address.setCity(location.getCity());
        address.setStreet(location.getStreet());
        address.setHouseNumber(location.getHouseNumber());
        address.setApartmentNumber(location.getApartmentNumber());
        address.setPostalCode(location.getPostalCode());
        addressService.save(address);
        employee.setAddress(addressService.findById(address.getId()));
        employeeRepository.save(employee);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

}
