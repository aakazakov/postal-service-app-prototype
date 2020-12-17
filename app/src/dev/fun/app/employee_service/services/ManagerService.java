package dev.fun.app.employee_service.services;

import java.util.logging.Logger;

import dev.fun.app.employee_service.datamappers.EmployeeMapper;
import dev.fun.app.employee_service.entities.Manager;

public class ManagerService implements EmployeeService<Manager> {
	
	private Logger logger = Logger.getLogger("ManagerService");
	
	private EmployeeMapper<Manager> managerMapper;

	public ManagerService(EmployeeMapper<Manager> managerMapper) {
		this.managerMapper = managerMapper;
	}

	@Override
	public Manager get(Integer id) {
		logger.info("`get` method ivoked");
		return managerMapper.findById(id);
	}

	@Override
	public Manager create(Manager manager) {
		logger.info("`create` method ivoked");
		return managerMapper.save(manager);
	}

	@Override
	public Manager update(Manager manager) {
		throw new UnsupportedOperationException("not yet supported");
	}

	@Override
	public void delete(Integer id) {
		logger.info("`delete` method ivoked");
		managerMapper.delete(id);
	}

}
