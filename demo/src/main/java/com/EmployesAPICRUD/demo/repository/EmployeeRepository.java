package com.EmployesAPICRUD.demo.repository;

import com.EmployesAPICRUD.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findEmployeeByCity(String city);

    Employee findEmployeeByName(String name);

    List<Employee> findEmployeeBySalary(float salary);

    List<Employee> findEmployeeByAge(int age);
}
