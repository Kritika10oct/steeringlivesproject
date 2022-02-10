package com.steering.assignment.Service.impl;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

import com.steering.assignment.request.EmployeeUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.steering.assignment.Service.EmployeeService;
import com.steering.assignment.Validation.EmployeeValidation;
import com.steering.assignment.model.Employee;
import com.steering.assignment.repository.EmployeeRepository;

@Service
 public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo ;
	
	@Override
	public ResponseEntity addEmployee(Employee newEmployee) {
		HashMap<String, Object> response = new HashMap<>();
	        if (EmployeeValidation.isValid(newEmployee)) {
	           Employee emp =  employeeRepo.save(newEmployee);
	           response.put("Status", "Employee Created");
	           response.put("data", emp);
	           return ResponseEntity.ok(response);
	        }
	        return ResponseEntity.badRequest().build();
	    }
	

	@Override
	public ResponseEntity updateEmployee(EmployeeUpdateRequest updateRequest) {
		System.out.println(updateRequest);
		System.out.println(EmployeeValidation.isValidPhoneNo(updateRequest.getPhoneNo()));

		HashMap<String, Object> response = new HashMap<>();
		System.out.println("inside update method");

		if (EmployeeValidation.isValidPhoneNo(updateRequest.getPhoneNo()))
		{
			System.out.println("phone is valid");
			Optional<Employee> optionalEmployee=employeeRepo.findById(updateRequest.getId());
			if(optionalEmployee.isPresent()) {
				System.out.println("employee present");
				Employee emp=optionalEmployee.get();
				emp.setName(updateRequest.getName());
				emp.setPhoneNo(updateRequest.getPhoneNo());
				employeeRepo.save(emp);
				response.put("Status", "Updated");
				response.put("data", emp);
				return ResponseEntity.ok(response);
				
			}else {
				System.out.println("employee does not exist");
				response.put("Status", "Employee Does not Exist");
				return ResponseEntity.ok(response);
			}

		}else
			return ResponseEntity.badRequest().build();
	}

	@Override
	public ResponseEntity getEmployee(String id, String phone) {
		HashMap<String, Object> response =new HashMap<>();
		if (!Objects.isNull(id)) {
			Optional<Employee> employeeOptional = employeeRepo.findById(id);
			if (employeeOptional.isPresent()) {
				response.put("Status", "Exist");
				response.put("Name", employeeOptional.get().getName());
				return ResponseEntity.ok(response);
			}
		}
		if(!Objects.isNull(phone)) {
			Optional<Employee> employeeOptional = employeeRepo.findByPhoneNo(phone);
			if (employeeOptional.isPresent()) {
				response.put("Status", "Exist");
				response.put("Name", employeeOptional.get().getName());
				return ResponseEntity.ok(response);
			}
		}
		response.put("Status", "Not Found");
		response.put("Name", "N.A");
		return ResponseEntity.ok(response);
	}
}

