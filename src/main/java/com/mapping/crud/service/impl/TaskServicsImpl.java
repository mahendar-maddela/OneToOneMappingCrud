package com.mapping.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.crud.entity.EmployeeTask;
import com.mapping.crud.repository.TaskRepository;
import com.mapping.crud.service.ITaskService;

@Service
public class TaskServicsImpl implements ITaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public EmployeeTask createTask(EmployeeTask task) {

		return taskRepository.save(task);
	}
	 @Override
	    public EmployeeTask getTaskByName(String taskName) {
	        return taskRepository.findByTask(taskName);
	    }

	@Override
	public EmployeeTask getTaskId(Long id) {
		// TODO Auto-generated method stub
		return taskRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}

	@Override
	public List<EmployeeTask> getAllTasks() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

}
