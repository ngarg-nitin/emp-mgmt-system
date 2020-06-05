package com.nitin.studies.empmgmt.services.v1;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitin.studies.empmgmt.dao.EmployeeRepository;
import com.nitin.studies.empmgmt.data.Employee;

@Service
public final class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public Collection<Employee> retrieveAllEmployees() {
		return repository.findAll();
	}

	public boolean deleteEmployee(final long userId) {
		boolean isDeleted = false;
		if (repository.existsById(userId)) {
			repository.deleteById(userId);
			isDeleted = true;
		}
		return isDeleted;
	}

	public Employee createEmployee(final Employee user) {
		return repository.save(user);
	}
}
