package com.nitin.studies.empmgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitin.studies.empmgmt.data.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
