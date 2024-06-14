package com.mapping.crud.service;

import java.util.List;

import com.mapping.crud.entity.Employee;

public interface IEmployeeService {

	public void saveEmployee(Employee employee);

	public List<Employee> getAllEmployee();

	public Employee editEmployee(Long id, Employee employee);

	public void delete(Long id);

	public Employee getById(Long id);

	public Employee saveEmployeetask(Employee employee);



	boolean doesEmployeeExist(String employeeName);



}
