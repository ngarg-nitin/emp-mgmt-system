package com.nitin.studies.empmgmt.data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_sequence")
	@SequenceGenerator(name = "emp_sequence")
	private long id;

	private String firstName;

	private String lastName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Department department;

	protected Employee() {
	}

	public Employee(String firstName, String lastName, Department department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
	}
}
