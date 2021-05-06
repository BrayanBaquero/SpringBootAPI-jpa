package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	private ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee temp= employeeService.create(employee);
		try {
			return ResponseEntity.created(new URI("api/employee"+temp.getId())).body(temp);
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping
	private ResponseEntity<List<Employee>> getAllEmployee(){
		
		return ResponseEntity.ok(employeeService.getAllEmployee());
	}
	
	@DeleteMapping("{id}")
	private ResponseEntity<List<Employee>> deleteEmployee(@PathVariable("id") long id){
		employeeService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("{id}")
	private ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable("id") Long id){
		
		return ResponseEntity.ok(employeeService.getEmployee(id));
	}
	
	@PutMapping("{id}")
	private ResponseEntity<Employee> update(@PathVariable("id")long id,@RequestBody Employee employee){
		final Employee updateEmployee=employeeService.update(id, employee);
		return  ResponseEntity.ok(updateEmployee);
	}

}
