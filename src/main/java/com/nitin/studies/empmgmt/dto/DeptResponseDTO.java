package com.nitin.studies.empmgmt.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeptResponseDTO {

	private long id;

	private String name;
}
