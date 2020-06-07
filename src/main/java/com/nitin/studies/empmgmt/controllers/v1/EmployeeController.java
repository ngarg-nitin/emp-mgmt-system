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

import com.nitin.studies.empmgmt.dto.EmpRequestDTO;
import com.nitin.studies.empmgmt.dto.EmpResponseDTO;
import com.nitin.studies.empmgmt.exceptions.EntityNotFoundException;
import com.nitin.studies.empmgmt.services.v1.EmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
public final class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping
	public Collection<EmpResponseDTO> retrieveAllEmployees() {
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
	public ResponseEntity<EmpResponseDTO> addUser(@RequestBody EmpRequestDTO employee) {
		EmpResponseDTO createdEmployee = service.createEmployee(employee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdEmployee.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
