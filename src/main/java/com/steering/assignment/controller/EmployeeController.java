package com.steering.assignment.controller;


import com.steering.assignment.Service.EmployeeService;
import com.steering.assignment.request.EmployeeUpdateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import com.steering.assignment.model.Employee;
import com.steering.assignment.response.Response;


import javax.validation.constraints.Size;


@RestController
@RequestMapping("api/v1/employee")
@Validated
public class EmployeeController {

	public  static  final Logger LOG= LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
    public ResponseEntity addEmployee( @RequestBody @Validated Employee newEmployee) {
		LOG.info("Request received for adding employee");
        return employeeService.addEmployee(newEmployee);
    }
	
	@PutMapping
	public ResponseEntity updateEmployee(@RequestBody EmployeeUpdateRequest updateRequest){
		LOG.info("Request received for updating employee");
		return employeeService.updateEmployee(updateRequest);
	}
	@GetMapping
	public ResponseEntity getEmployee(
			 @RequestParam(value = "id", required = false)
			 @Size(min = 4, max = 10)  String id,
			@RequestParam(value = "phone", required = false)String phone) {
		LOG.info("Request received for getting employee");
	    return employeeService.getEmployee(id, phone);
	}
}
