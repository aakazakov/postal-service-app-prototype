package dev.fun.app.client_service.services;

import dev.fun.app.client_service.entities.Client;

public class ClientServiceImpl implements ClientService {

	@Override
	public Client getCurrent() {
		return new Client.Builder().setName("current_client").build();
	}

}
