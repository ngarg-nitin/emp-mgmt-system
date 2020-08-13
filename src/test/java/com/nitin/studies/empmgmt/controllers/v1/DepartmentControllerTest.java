package com.nitin.studies.empmgmt.controllers.v1;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
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

	Collection<DeptResponseDTO> existingDepts = new ArrayList<>(); 
	
	@BeforeEach
	public void setUp() {
		DeptResponseDTO dept_1 = new DeptResponseDTO();
		dept_1.setId(1);
		dept_1.setName("IT");
		
		DeptResponseDTO dept_2 = new DeptResponseDTO();
		dept_2.setId(2);
		dept_2.setName("HR");
    
		existingDepts.add(dept_1);
		existingDepts.add(dept_2);
	}
	
	@Test
	void getAllDepartments() throws Exception {
		given(departmentService.retrieveAllDepartments()).willReturn(existingDepts);

		ConstrainedFields fields = new ConstrainedFields(DeptResponseDTO.class);

		mockMvc.perform(get("/api/v1/departments")).andExpect(status().isOk()).andDo(
				document("v1/dept-all", responseFields(fields.withPath("[].id").description("Id of Dept").type(long.class),
						fields.withPath("[].name").description("Department Name"))));
	}

	@Test
	void addDepartment() throws Exception {
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
