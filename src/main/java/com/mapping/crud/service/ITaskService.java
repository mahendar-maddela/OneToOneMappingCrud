package com.mapping.crud.service;

import java.util.List;

import com.mapping.crud.entity.EmployeeTask;

public interface ITaskService {

	public EmployeeTask createTask(EmployeeTask task);

	public EmployeeTask getTaskId(Long id);

	public void deleteTask(Long id);

	public List<EmployeeTask> getAllTasks();

	public EmployeeTask getTaskByName(String taskName);

}
