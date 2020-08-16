package com.nitin.studies.empmgmt.services.v1;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitin.studies.empmgmt.dao.DepartmentRepository;
import com.nitin.studies.empmgmt.data.Department;
import com.nitin.studies.empmgmt.dto.DeptRequestDTO;
import com.nitin.studies.empmgmt.dto.DeptResponseDTO;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;

	public Collection<DeptResponseDTO> retrieveAllDepartments() {
		return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
	}

	public boolean deleteDepartment(final long id) {
		boolean isDeleted = false;
		if (repository.existsById(id)) {
			repository.deleteById(id);
			isDeleted = true;
		}
		return isDeleted;
	}

	public DeptResponseDTO createDepartment(final DeptRequestDTO requestDto) {
		return mapToDto(repository.save(mapToDomain(requestDto)));
	}

	private Department mapToDomain(final DeptRequestDTO requestDto) {
		Objects.requireNonNull(requestDto, "RequestDTO must be initialized");
		return new Department(requestDto.getName());
	}

	private DeptResponseDTO mapToDto(final Department domain) {
		DeptResponseDTO responseObject = DeptResponseDTO.builder().id(domain.getId()).name(domain.getName()).build();
		return responseObject;
	}

}
