package com.mapping.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.crud.entity.Employee;
import com.mapping.crud.entity.EmployeeTask;
import com.mapping.crud.service.ITaskService;
import com.mapping.crud.utility.ResponseUtility;

@RestController
@RequestMapping("/Employee")
public class EmployeeTaskController {

	@Autowired
	private ITaskService iTaskService;
	
	@PostMapping("/task/save")
	public ResponseEntity<ResponseUtility<EmployeeTask>> createTask(@RequestBody EmployeeTask task) {
	    // Check if a task with the same name already exists
	    EmployeeTask existingTask = iTaskService.getTaskByName(task.getTask());

	    if (existingTask != null) {
	        // If the task already exists, return a response indicating the conflict
	        String message = "Task '" + task.getTask() + "' already exists.";
	        return ResponseUtility.notAcceptable(message);
	    } else {
	        // If the task doesn't exist, save it
	        EmployeeTask savedTask = iTaskService.createTask(task);
	        // Return a response indicating successful creation
	        return ResponseUtility.successCreated("Task created successfully", savedTask);
	    }
	}

	
//	@PostMapping("/task/save")
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public ResponseEntity<?> createTask(@RequestBody EmployeeTask task) {
//	    // Check if a task with the same name already exists
//	    EmployeeTask existingTask = iTaskService.getTaskByName(task.getTask());
//
//	    if (existingTask != null) {
//	        // If the task already exists, return a response indicating the conflict
//	    	   String message = "Task '" + task.getTask() + "' already exists.";
//	           return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(message);
//	    } else {
//	        // If the task doesn't exist, save it
//	        EmployeeTask savedTask = iTaskService.createTask(task);
//	        return ResponseEntity.ok(savedTask);
//	    }
//	}

//	// adding the tasks
//	@PostMapping("/task/save")
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public ResponseEntity<EmployeeTask> createTask(@RequestBody EmployeeTask task) {
//		EmployeeTask savedTask = iTaskService.createTask(task);
//		return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
//	}

	// getting by id
	@GetMapping("/task/get/{id}")
	public EmployeeTask getTaskById(@PathVariable Long id) {
		return iTaskService.getTaskId(id);
	}

	// getting all tasks
	@GetMapping("/task/getall")
	public List<EmployeeTask> getAllTasks() {
		return iTaskService.getAllTasks();
	}

	// deleting the task by id
	@DeleteMapping("/task/delete/{id}")
	public void deleteTask(@PathVariable Long id) {
		iTaskService.deleteTask(id);
	}

//	  @PostMapping("/task/save")
//	  @ResponseStatus(code=HttpStatus.CREATED)
//	  public ResponseEntity<EmployeeTask> createTask(@RequestBody EmployeeTask employeeTask) {
//	      // Ensure that employeeId is provided in the request body
//	      Long employeeId = employeeTask.getEmployee().getId();
//
//	      // Fetch the corresponding Employee object using the employeeId
//	      Employee employee = employeeService.getById(employeeId);
//
//	      // Set the fetched Employee object to the employee field of the EmployeeTask
//	      employeeTask.setEmployee(employee);
//
//	      // Save the EmployeeTask with the associated Employee
//	      EmployeeTask createdTask = iTaskService.createTask(employeeTask);
//	      return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
//	  }

}
