package dev.fun.app.employee_service.adapters;

import dev.fun.app.client_service.interfaces.Customer;
import dev.fun.app.employee_service.entities.Manager;

/**
 * Provides a customer interface for use by a manager.
 */
public class ManagerToCustomerAdapter implements Customer {
	
	private Manager manager;
	
	public Manager getManger() {
		return manager;
	}
	
	public ManagerToCustomerAdapter(Manager manager) {
		this.manager = manager;	
	}

	@Override
	public String info() {
		return manager.info();
	}
	
}
