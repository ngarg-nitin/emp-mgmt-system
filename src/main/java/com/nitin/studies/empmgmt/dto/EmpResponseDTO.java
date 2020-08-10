package com.nitin.studies.empmgmt.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Response object for Employee creation")
public final class EmpResponseDTO {

	private long id;

	private String firstName;

	private String lastName;

	private DeptResponseDTO department;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public DeptResponseDTO getDepartment() {
		return department;
	}

	public void setDepartment(DeptResponseDTO department) {
		this.department = department;
	}

}
