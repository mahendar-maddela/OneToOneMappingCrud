package com.mapping.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.crud.entity.Employee;
import com.mapping.crud.entity.EmployeeTask;
import com.mapping.crud.repository.EmployeeRepository;
import com.mapping.crud.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeRepository employeeRepo;

	public void saveEmployee(Employee employee) {

		employeeRepo.save(employee);
	}

	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee getById(Long id) {
		return employeeRepo.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		employeeRepo.deleteById(id);
	}

	@Override
	public Employee editEmployee(Long id, Employee employee) {
		Employee update = employeeRepo.findById(id).orElse(null);

		// Check if the employee exists
		if (update != null) {
			update.setName(employee.getName());
			update.setRole(employee.getRole());

			// Save the updated employee back to the repository
			return employeeRepo.save(update);
		} else {
			// If the employee with the given ID doesn't exist, return null or throw an
			// exception
			return null;
		}

	}

	@Override
	public Employee saveEmployeetask(Employee employee) {
		
		return employeeRepo.save(employee);
	}

	@Override
	public boolean doesEmployeeExist(String employeeName) {
	    return employeeRepo.existsByName(employeeName);
	}


}
