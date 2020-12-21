package dev.fun.app.employee_service.services;

import dev.fun.app.employee_service.entities.Employee;
import dev.fun.app.exceptions.IncorrectlyFilledCredentialsException;

public interface EmployeeService<T extends Employee> {
	
	T get(Integer id);
	
	T create(T employee) throws IncorrectlyFilledCredentialsException;
	
	T update(T employee);
	
	void delete(Integer id);
	
}
