package com.nitin.studies.empmgmt.controllers.v1;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.nitin.studies.empmgmt.services.v1.DepartmentService;

@WebMvcTest(DepartmentController.class)
@AutoConfigureMockMvc
class DepartmentControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	DepartmentService departmentService;

	@Test
	void getAllDepartments() throws Exception {
		given(departmentService.retrieveAllDepartments()).willReturn(Collections.emptyList());

		mockMvc.perform(get("/api/v1/departments")).andExpect(status().isOk());
	}

}
