package com.nitin.studies.empmgmt.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Model for creating departments")
public class DeptRequestDTO {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
