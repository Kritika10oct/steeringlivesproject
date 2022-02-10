package com.steering.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.steering.assignment.model.Employee;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Optional<Employee> findByPhoneNo(String phone);
}
