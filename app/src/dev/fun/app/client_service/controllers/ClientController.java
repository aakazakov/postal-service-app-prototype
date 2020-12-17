package dev.fun.app.client_service.controllers;

import java.util.logging.Logger;

import dev.fun.app.client_service.entities.Client;
import dev.fun.app.client_service.services.ClientService;

public class ClientController {
	private Logger logger = Logger.getLogger("ManagerController");
	
	private ClientService clientService;
	
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	public Client create(Client client) {
		logger.info("`create` method invoked");
		return clientService.create(client);
	}
	
	public Client update(Client client) {
		logger.info("`update` method invoked");
		return clientService.update(client);
	}
	
	public Client get(Integer id) {
		logger.info("`get` method invoked");
		return clientService.get(id);
	}
	
	public void delete(Integer id) {
		logger.info("`delete` method invoked");
		clientService.delete(id);
	}
}
