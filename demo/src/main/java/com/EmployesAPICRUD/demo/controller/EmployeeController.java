package com.EmployesAPICRUD.demo.controller;

import com.EmployesAPICRUD.demo.model.Employee;
import com.EmployesAPICRUD.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employees")
    public String createNewEmployee(@RequestBody  Employee employee) {
        employeeRepository.save(employee);
        return "Employee Created in database";
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeRepository.findAll().forEach(employeeList::add);
        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            return new ResponseEntity<Employee>(employee.get(), HttpStatus.FOUND);
        }else {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/employees/{id}")
    public String updateEmployeeById(@PathVariable int id, @RequestBody Employee theEmployee) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            Employee existEmployee = employee.get();
            existEmployee.setAge(theEmployee.getAge());
            existEmployee.setCity(theEmployee.getCity());
            existEmployee.setName(theEmployee.getName());
            existEmployee.setSalary(theEmployee.getSalary());

            employeeRepository.save(existEmployee);
            return "Employee Details against Id :  " + id + " updated";
        } else {
            return "Employee Details does not exist for Id : " + id;
        }
    }

    @DeleteMapping()



}
