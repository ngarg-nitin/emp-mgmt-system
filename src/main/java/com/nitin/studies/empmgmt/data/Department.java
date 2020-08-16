package com.nitin.studies.empmgmt.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_sequence")
	@SequenceGenerator(name = "dept_sequence")
	private long id;

	private String name;

	protected Department() {
	}

	public Department(String name) {
		this.name = name;
	}
}
