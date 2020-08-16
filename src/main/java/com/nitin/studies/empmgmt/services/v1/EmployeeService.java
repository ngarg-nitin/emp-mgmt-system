package com.nitin.studies.empmgmt.services.v1;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitin.studies.empmgmt.dao.DepartmentRepository;
import com.nitin.studies.empmgmt.dao.EmployeeRepository;
import com.nitin.studies.empmgmt.data.Department;
import com.nitin.studies.empmgmt.data.Employee;
import com.nitin.studies.empmgmt.dto.DeptResponseDTO;
import com.nitin.studies.empmgmt.dto.EmpRequestDTO;
import com.nitin.studies.empmgmt.dto.EmpResponseDTO;
import com.nitin.studies.empmgmt.exceptions.EntityNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Autowired
	private DepartmentRepository deptRepository;

	public Collection<EmpResponseDTO> retrieveAllEmployees() {
		return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
	}

	public boolean deleteEmployee(final long id) {
		boolean isDeleted = false;
		if (repository.existsById(id)) {
			repository.deleteById(id);
			isDeleted = true;
		}
		return isDeleted;
	}

	public EmpResponseDTO createEmployee(final EmpRequestDTO requestDto) {
		return mapToDto(repository.save(mapToDomain(requestDto)));
	}

	private Employee mapToDomain(final EmpRequestDTO requestDto) {
		Objects.requireNonNull(requestDto, "RequestDTO must be initialized");
		Long departmentId = requestDto.getDepartmentId();
		Department department = deptRepository.findById(departmentId).orElseThrow(
				() -> new EntityNotFoundException(String.format("Department with id {%d} not found", departmentId)));
		return new Employee(requestDto.getFirstName(), requestDto.getLastName(), department);
	}

	private DeptResponseDTO mapToDto(final Department domain) {
		DeptResponseDTO responseObject = DeptResponseDTO.builder().id(domain.getId()).name(domain.getName()).build();
		return responseObject;
	}

	private EmpResponseDTO mapToDto(final Employee domain) {
		EmpResponseDTO responseObject = EmpResponseDTO.builder().id(domain.getId()).firstName(domain.getFirstName())
				.lastName(domain.getLastName()).department(mapToDto(domain.getDepartment())).build();
		return responseObject;
	}
}
