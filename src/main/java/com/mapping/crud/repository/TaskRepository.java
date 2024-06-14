package com.mapping.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapping.crud.entity.EmployeeTask;

public interface TaskRepository extends JpaRepository<EmployeeTask, Long> {

	EmployeeTask findByTask(String taskName);

}
