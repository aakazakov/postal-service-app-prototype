package dev.fun.app.client_service.controllers;

import dev.fun.app.client_service.entities.Client;
import dev.fun.app.client_service.services.ClientService;
import dev.fun.app.common.exceptions.IncorrectlyFilledCredentialsException;

public class ClientController {
	
	private ClientService clientService;
	
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	public Client create(Client client) throws IncorrectlyFilledCredentialsException {
		return clientService.create(client);
	}
	
	public Client update(Client client) {
		return clientService.update(client);
	}
	
	public Client get(Integer id) {
		return clientService.get(id);
	}
	
	public void delete(Integer id) {
		clientService.delete(id);
	}
}
