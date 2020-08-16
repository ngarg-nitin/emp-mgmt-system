package com.nitin.studies.empmgmt.controllers.v1;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.beneathPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.nitin.studies.empmgmt.dto.DeptResponseDTO;
import com.nitin.studies.empmgmt.dto.EmpResponseDTO;
import com.nitin.studies.empmgmt.services.v1.EmployeeService;

@ExtendWith(RestDocumentationExtension.class)
@AutoConfigureRestDocs(uriScheme = "http", uriHost = "localhost", uriPort = 8080)
@WebMvcTest(EmployeeController.class)
@AutoConfigureMockMvc
class EmployeeControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	EmployeeService employeeService;

	Collection<EmpResponseDTO> existingEmps = new ArrayList<>();

	@BeforeEach
	public void setUp() {
		DeptResponseDTO dept = DeptResponseDTO.builder().id(1).name("IT").build();
		
		EmpResponseDTO emp_1 = EmpResponseDTO.builder().id(1).firstName("Nitin").lastName("Garg").department(dept).build();
		EmpResponseDTO emp_2 = EmpResponseDTO.builder().id(2).firstName("Tia").lastName("Garg").department(dept).build();

		existingEmps = asList(emp_1,emp_2);
	}

	@Test
	@Disabled
	// NOTES: Will document the Request,Response and Response body. No documentation
	// for the response fields would be generated
	void getAllEmployeesDefault() throws Exception {
		given(employeeService.retrieveAllEmployees()).willReturn(existingEmps);
		mockMvc.perform(get("/api/v1/employees")).andExpect(status().isOk()).andDo(document("v1/emp-all",preprocessResponse(prettyPrint())));

	}

	@Test
	@Disabled
	void getAllEmployeesWithDeptSubsection() throws Exception {
		given(employeeService.retrieveAllEmployees()).willReturn(existingEmps);

		mockMvc.perform(get("/api/v1/employees")).andExpect(status().isOk()).andDo(document("v1/emp-all",preprocessResponse(prettyPrint()),
				responseFields(fieldWithPath("[].id").description("Employee Id").type(long.class),
						fieldWithPath("[].firstName").description("Emp's First Name"),
						fieldWithPath("[].lastName").description("Emp's Last Name"), subsectionWithPath("[].department")
								.type(DeptResponseDTO.class).description("Emp's department details"))));

	}

	@Test
//	@Disabled
	void getAllEmployeesWithDeptsDocumented() throws Exception {
		given(employeeService.retrieveAllEmployees()).willReturn(existingEmps);

		mockMvc.perform(get("/api/v1/employees")).andExpect(status().isOk())
				.andDo(document("v1/emp-all",preprocessResponse(prettyPrint()),
						responseFields(fieldWithPath("[].id").description("Employee Id").type(long.class),
								fieldWithPath("[].firstName").description("Emp's First Name"),
								fieldWithPath("[].lastName").description("Emp's Last Name"),
//						responseFields(beneathPath("[].department").withSubsectionId("emp-dept"),
								fieldWithPath("[].department.id").description("Id of Dept").type(long.class),
								fieldWithPath("[].department.name").description("Department Name"))));

	}

}
