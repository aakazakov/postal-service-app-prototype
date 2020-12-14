package dev.fun.app.employee_service.adapters;

import dev.fun.app.client_service.interfaces.Customer;
import dev.fun.app.employee_service.interfaces.Management;

/**
 * Provides a customer interface for use by a manager.
 */
public class ManagerToCustomerAdapter implements Customer {
	
	private Management manager;
	
	public Management getManger() {
		return manager;
	}
	
	public ManagerToCustomerAdapter(Management manager) {
		this.manager = manager;	
	}

	@Override
	public String info() {
		return manager.info() + " :)";
	}
	
}
