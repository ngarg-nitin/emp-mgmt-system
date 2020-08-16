package com.nitin.studies.empmgmt.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class EmpResponseDTO {

	private long id;

	private String firstName;

	private String lastName;

	private DeptResponseDTO department;
}
