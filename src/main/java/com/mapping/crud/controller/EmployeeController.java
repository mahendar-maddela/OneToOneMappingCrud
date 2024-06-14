package com.mapping.crud.controller;

import com.mapping.crud.entity.Employee;
import com.mapping.crud.entity.EmployeeTask;
import com.mapping.crud.service.IEmployeeService;
import com.mapping.crud.service.ITaskService;
import com.mapping.crud.utility.ResponseUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService iemployeeService;

	@Autowired
	private ITaskService iTaskService;

	// Creating Employee
	@PostMapping("/save")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void saveEmployee(@RequestBody Employee employee) {
		iemployeeService.saveEmployee(employee);
	}

	// getting all employee details
	@GetMapping("/getall")
	public List<Employee> allEmployee() {
		return iemployeeService.getAllEmployee();
	}

	// getting by id employee details
	@GetMapping("/get/{id}")
	public Employee getById(@PathVariable Long id) {
		return iemployeeService.getById(id);
	}

	// deleting employee details
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		iemployeeService.delete(id);
	}

	// editing the employee details
	@PutMapping("/edit/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		Employee updatedEmployee = iemployeeService.editEmployee(id, employee);

		if (updatedEmployee != null) {
			return ResponseEntity.ok(updatedEmployee);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/task/add")
	public ResponseEntity<ResponseUtility<Employee>> assignTaskToEmployee(@RequestBody Employee employee) {
	    // Check if the employee's name already exists
	    String employeeName = employee.getName();
	    boolean employeeExists = iemployeeService.doesEmployeeExist(employeeName);
	    if (employeeExists) {
	        // If the employee's name already exists, return a response indicating the conflict
	        String message = "Employee with name '" + employeeName + "' already exists.";
	        return ResponseUtility.notAcceptable(message);
	    }

	    // Save the updated employee with the assigned task
	    Employee savedEmployee = iemployeeService.saveEmployeetask(employee);

	    return ResponseUtility.successCreated("Employee Task created successfully", savedEmployee);
	}

//	// Assign a task to an employee
//	@PostMapping("/task/add")
//	public ResponseEntity<Employee> assignTaskToEmployee(@RequestBody Employee employee) {
//	    EmployeeTask employeeTask = employee.getEmployeeTask();
//
//	    // Check if the task already exists
//	    EmployeeTask existingTask = iTaskService.getTaskId(employeeTask.getId());
// 
//	    // Save the updated employee with the assigned task
//	    Employee savedEmployee = iemployeeService.saveEmployeetask(employee);
//
//	    return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
//	}

}
