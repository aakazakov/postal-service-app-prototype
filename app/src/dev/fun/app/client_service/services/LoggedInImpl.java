package dev.fun.app.client_service.services;

import dev.fun.app.client_service.entities.Client;

public class LoggedInImpl implements LoggedIn {

	@Override
	public Client getCurrent() {
		return new Client();
	}

}
