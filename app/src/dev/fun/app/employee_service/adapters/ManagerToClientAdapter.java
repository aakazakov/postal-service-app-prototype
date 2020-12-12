package dev.fun.app.employee_service.adapters;

import dev.fun.app.client_service.interfaces.Customer;
import dev.fun.app.employee_service.interfaces.Management;

/**
 * Provides a client interface for use by a manager.
 */
public class ManagerToClientAdapter implements Customer {
	
	private Management manger;
	
	public Management getManger() {
		return manger;
	}
	
	public ManagerToClientAdapter(Management manger) {
		this.manger = manger;	
	}

	@Override
	public String info() {
		return "Info";
	}
	
}
