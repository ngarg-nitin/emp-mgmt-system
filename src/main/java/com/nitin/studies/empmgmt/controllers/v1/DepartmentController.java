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

import com.nitin.studies.empmgmt.data.Department;
import com.nitin.studies.empmgmt.exceptions.EntityNotFoundException;
import com.nitin.studies.empmgmt.services.v1.DepartmentService;

@RestController
@RequestMapping("/v1/departments")
public final class DepartmentController {

	@Autowired
	private DepartmentService service;

	@GetMapping
	public Collection<Department> retrieveAllDepartments() {
		return service.retrieveAllDepartments();
	}

	@DeleteMapping("/{id}")
	public void removeDepartment(@PathVariable long id) {
		boolean isDeleted = service.deleteDepartment(id);
		if (!isDeleted) {
			throw new EntityNotFoundException(String.format("Department with id{%d} doesnot exist", id));
		}
	}

	@PostMapping
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		Department createdDept = service.createDepartment(department);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdDept.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
