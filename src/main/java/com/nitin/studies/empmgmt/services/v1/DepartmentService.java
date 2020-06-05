package com.nitin.studies.empmgmt.services.v1;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitin.studies.empmgmt.dao.DepartmentRepository;
import com.nitin.studies.empmgmt.data.Department;

@Service
public final class DepartmentService {

	@Autowired
	private DepartmentRepository repository;

	public Collection<Department> retrieveAllDepartments() {
		return repository.findAll();
	}

	public boolean deleteDepartment(final long departmentId) {
		boolean isDeleted = false;
		if (repository.existsById(departmentId)) {
			repository.deleteById(departmentId);
			isDeleted = true;
		}
		return isDeleted;
	}

	public Department createDepartment(final Department department) {
		return repository.save(department);
	}

}
