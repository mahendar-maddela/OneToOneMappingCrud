package com.mapping.crud.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employe_data")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name ", unique = true)
	private String name;

	@Column(name = "role")
	private String role;

	@OneToOne
//	@JoinColumn(name = "employe_tasks")
//	@ManyToOne
	@JoinColumn(name = "task_id")
	private EmployeeTask employeeTask;

	public EmployeeTask getEmployeeTask() {
		return employeeTask;
	}

	public void setEmployeeTask(EmployeeTask employeeTask) {
		this.employeeTask = employeeTask;
	}

	public Employee() {

	}

	// EmployeeTask employeeTask
	public Employee(String name, String role) {
		super();
		this.name = name;
		this.role = role;
//		this.employeeTask = employeeTask;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
