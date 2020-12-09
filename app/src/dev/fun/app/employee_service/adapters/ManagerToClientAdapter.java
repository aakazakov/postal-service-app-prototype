package dev.fun.app.employee_service.adapters;

import dev.fun.app.client_service.interfaces.Clientable;
import dev.fun.app.employee_service.interfaces.Manageable;

/**
 * Provides a client interface for use by a manager.
 */
public class ManagerToClientAdapter implements Clientable {
	
	private Manageable manger;
	
	public Manageable getManger() {
		return manger;
	}
	
	public ManagerToClientAdapter(Manageable manger) {
		this.manger = manger;	
	}

	@Override
	public String info() {
		return "Info";
	}
	
}
