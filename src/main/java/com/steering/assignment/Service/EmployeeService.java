package com.steering.assignment.Service;

import com.steering.assignment.request.EmployeeUpdateRequest;
import org.springframework.http.ResponseEntity;

import com.steering.assignment.model.Employee;
import com.steering.assignment.response.Response;

public interface EmployeeService {

	ResponseEntity addEmployee(Employee newEmployee);
	ResponseEntity updateEmployee(EmployeeUpdateRequest updateRequest);

	ResponseEntity getEmployee(String id, String phone);
}