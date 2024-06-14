package com.mapping.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapping.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


	  boolean existsByName(String name);

}
