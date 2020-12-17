package dev.fun.app.client_service.services;

import dev.fun.app.client_service.entities.Client;

public interface Current {

	/**
	 * Returns the currently logged in {@link Client}
	 * @return
	 */
	Client getCurrent();
	
}
