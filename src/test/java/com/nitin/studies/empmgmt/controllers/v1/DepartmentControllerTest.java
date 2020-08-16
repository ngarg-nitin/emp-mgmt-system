package com.nitin.studies.empmgmt.controllers.v1;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.StringUtils;

import com.nitin.studies.empmgmt.dto.DeptResponseDTO;
import com.nitin.studies.empmgmt.services.v1.DepartmentService;

@ExtendWith(RestDocumentationExtension.class)
@AutoConfigureRestDocs(uriScheme = "http", uriHost = "localhost", uriPort = 8080)
@WebMvcTest(DepartmentController.class)
@AutoConfigureMockMvc
class DepartmentControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	DepartmentService departmentService;

	List<DeptResponseDTO> existingDepts = new ArrayList<>();

	@BeforeEach
	public void setUp() {
		DeptResponseDTO dept_1 = DeptResponseDTO.builder().id(1).name("IT").build();
		DeptResponseDTO dept_2 = DeptResponseDTO.builder().id(2).name("HR").build();
		existingDepts = asList(dept_1, dept_2);
	}

//	@Test
//	void getAllDepartments() throws Exception {
//		given(departmentService.retrieveAllDepartments()).willReturn(existingDepts);
//
//		ConstrainedFields fields = new ConstrainedFields(DeptResponseDTO.class);
//
//		mockMvc.perform(get("/api/v1/departments")).andExpect(status().isOk()).andDo(
//				document("v1/dept-all", responseFields(fields.withPath("[].id").description("Id of Dept").type(long.class),
//						fields.withPath("[].name").description("Department Name"))));
//	}

	@Test
	@Disabled
	void getAllDepartmentsDefault() throws Exception {
		given(departmentService.retrieveAllDepartments()).willReturn(existingDepts);

		mockMvc.perform(get("/api/v1/departments")).andExpect(status().isOk())
				.andDo(document("v1/dept-all", preprocessResponse(prettyPrint())));
	}

	@Test
	void getAllDepartmentsDocumentAllResponses() throws Exception {
		given(departmentService.retrieveAllDepartments()).willReturn(existingDepts);

		mockMvc.perform(get("/api/v1/departments")).andExpect(status().isOk())
				.andDo(document("v1/dept-all", preprocessResponse(prettyPrint()),
						responseFields(fieldWithPath("[].id").description("Id of Dept").type(long.class),
								fieldWithPath("[].name").description("Department Name"))));
	}

	@Test
	void getDepartmentById() throws Exception {
		given(departmentService.retrieveDepartment(anyLong())).willReturn(existingDepts.get(0));

		mockMvc.perform(get("/api/v1/departments/{id}", existingDepts.get(0).getId())).andExpect(status().isOk())
				.andDo(document("v1/dept-get", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint()),
						pathParameters(parameterWithName("id").description("Department's Id")),
						responseFields(fieldWithPath("id").description("Department Id").type(long.class),
								fieldWithPath("name").description("Department Name"))));

	}

	private static class ConstrainedFields {
		private final ConstraintDescriptions constraintDescriptions;

		ConstrainedFields(Class<?> input) {
			this.constraintDescriptions = new ConstraintDescriptions(input);
		}

		private FieldDescriptor withPath(String path) {
			return fieldWithPath(path).attributes(key("constraints").value(StringUtils
					.collectionToDelimitedString(this.constraintDescriptions.descriptionsForProperty(path), ". ")));
		}
	}
}
