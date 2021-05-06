package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.IEmployeeRepository;



@Service
public class EmployeeService {
	@Autowired
	private IEmployeeRepository _employeeReporitory;
	
	public Employee create(Employee employee) {
		return _employeeReporitory.save(employee);
		
	}
	
	public List<Employee> getAllEmployee() {
		
		return _employeeReporitory.findAll();
	}
	
	public void delete(long id) {
	  _employeeReporitory.deleteById(id);
	}
	
	public Optional<Employee> getEmployee(Long id) {
		return _employeeReporitory.findById(id);
	}
	
	
	public Employee update(long id, Employee employee)
	{
	    Optional<Employee> temp=_employeeReporitory.findById(id);
	    if(temp.isPresent()) {
	    	Employee _employee=temp.get();
	    	_employee.setName(employee.getName());
	    	_employee.setEmail(employee.getEmail());
	    	_employee.setDeparment(employee.getDeparment());
	    	return _employeeReporitory.save(_employee);
	    }else {
	    	return employee;
	    }
		
	}
	
	
	
}
