package com.EmployesAPICRUD.demo.repository;

import com.EmployesAPICRUD.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
