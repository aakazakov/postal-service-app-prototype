package dev.fun.app.employee_service.services;

import dev.fun.app.employee_service.datamappers.EmployeeMapper;
import dev.fun.app.employee_service.entities.Manager;

public class ManagerService implements EmployeeService<Manager> {
	
	private EmployeeMapper<Manager> managerMapper;

	public ManagerService(EmployeeMapper<Manager> managerMapper) {
		this.managerMapper = managerMapper;
	}

	@Override
	public Manager get(Integer id) {
		return managerMapper.findById(id);
	}

	@Override
	public Manager create(Manager manager) {
		return managerMapper.save(manager);
	}

	@Override
	public Manager update(Manager manager) {
		throw new UnsupportedOperationException("not yet supported");
	}

	@Override
	public void delete(Integer id) {
		managerMapper.delete(id);
	}

}
