package com.github.lemongrab32.somecrud.controllers;

import com.github.lemongrab32.somecrud.dto.AddressDto;
import com.github.lemongrab32.somecrud.dto.EmployeeDto;
import com.github.lemongrab32.somecrud.repository.entities.Address;
import com.github.lemongrab32.somecrud.repository.entities.Employee;
import com.github.lemongrab32.somecrud.services.AddressService;
import com.github.lemongrab32.somecrud.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final EmployeeService employeeService;
    private final AddressService addressService;

    @GetMapping("/")
    public String showMain(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/add")
    public String addEmployeeForm(@ModelAttribute(name = "employee") EmployeeDto employee,@ModelAttribute(name = "address") AddressDto address) {
        return "add";
    }

    @PostMapping("/add")
    public String addEmployee(EmployeeDto person, AddressDto address) {
        employeeService.save(person, address);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String updateEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.findById(id).orElseThrow();
        model.addAttribute("employee", employee);
        model.addAttribute("address", employee.getAddress());
        return "update";
    }

    @PostMapping("/edit")
    public String updateEmployee(Employee employee, Address address) {
        addressService.save(address);
        employee.setAddress(address);
        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "redirect:/";
    }

}
