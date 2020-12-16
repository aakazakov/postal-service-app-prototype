package dev.fun.app.employee_service.controllers;

import java.util.logging.Logger;

import dev.fun.app.employee_service.entities.Manager;
import dev.fun.app.employee_service.services.ManagerService;

public class ManagerController {
	
	private Logger logger = Logger.getLogger("ManagerController");
	
	private ManagerService managerService;

	public ManagerController(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	public Manager create(Manager manager) {
		logger.info("`create` method invoked");
		return managerService.create(manager);
	}
	
	public Manager update(Manager manager) {
		logger.info("`update` method invoked");
		return managerService.update(manager);
	}
	
	public Manager get(Integer id) {
		logger.info("`get` method invoked");
		return managerService.get(id);
	}
	
	public void delete(Integer id) {
		logger.info("`delete` method invoked");
		managerService.delete(id);
	}
	
}
