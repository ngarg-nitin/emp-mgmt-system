package com.nitin.studies.empmgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitin.studies.empmgmt.data.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
