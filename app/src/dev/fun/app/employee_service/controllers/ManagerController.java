package dev.fun.app.employee_service.controllers;

import dev.fun.app.common.exceptions.IncorrectlyFilledCredentialsException;
import dev.fun.app.employee_service.entities.Manager;
import dev.fun.app.employee_service.services.ManagerService;

public class ManagerController {
	
	private ManagerService managerService;

	public ManagerController(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	public Manager create(Manager manager) throws IncorrectlyFilledCredentialsException {
		return managerService.create(manager);
	}
	
	public Manager update(Manager manager) {
		return managerService.update(manager);
	}
	
	public Manager get(Integer id) {
		return managerService.get(id);
	}
	
	public void delete(Integer id) {
		managerService.delete(id);
	}
	
}
