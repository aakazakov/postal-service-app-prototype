package dev.fun.app.employee_service.datamappers;

import dev.fun.app.employee_service.entities.Employee;

public interface EmployeeMapper<T extends Employee> {
	
	T save(T manager);
	
	T findById(Integer id);
	
	void delete(Integer id);
	
}
