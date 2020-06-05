package com.nitin.studies.empmgmt.controllers.v1;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nitin.studies.empmgmt.data.Employee;
import com.nitin.studies.empmgmt.exceptions.EntityNotFoundException;
import com.nitin.studies.empmgmt.services.v1.EmployeeService;

@RestController
@RequestMapping("/v1/employees")
public final class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping
	public Collection<Employee> retrieveAllEmployees() {
		return service.retrieveAllEmployees();
	}

	@DeleteMapping("/{id}")
	public void removeEmployee(@PathVariable long id) {
		boolean isDeleted = service.deleteEmployee(id);
		if (!isDeleted) {
			throw new EntityNotFoundException(String.format("Employee with id{%d} doesnot exist", id));
		}
	}

	@PostMapping
	public ResponseEntity<Employee> addUser(@RequestBody Employee employee) {
		Employee createdEmployee = service.createEmployee(employee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdEmployee.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}