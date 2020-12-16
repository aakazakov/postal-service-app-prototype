package dev.fun.app.employee_service.services;

import dev.fun.app.employee_service.entities.Employee;

public interface EmployeeService<T extends Employee> {
	
	T get(Integer id);
	
	T create(T employee);
	
	T update(T employee);
	
	void delete(Integer id);
	
}
