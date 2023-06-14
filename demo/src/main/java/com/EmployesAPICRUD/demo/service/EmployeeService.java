package com.EmployesAPICRUD.demo.service;

import com.EmployesAPICRUD.demo.model.Employee;
import com.EmployesAPICRUD.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployeeByCity(String city) {

        /*List<Employee> employees = employeeRepository.findAll();

        List<Employee> chooseEmployees = new ArrayList<>();

        for(Employee emp : employees) {
            if(emp.getCity().equalsIgnoreCase(city)) {
                chooseEmployees.add(emp);
            }
        }

        return chooseEmployees;*/
        return employeeRepository.findEmployeeByCity(city);
    }

}
