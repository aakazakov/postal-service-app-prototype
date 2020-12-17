package dev.fun.app.client_service.services;

import dev.fun.app.client_service.entities.Client;

public interface ClientService {
		
	Client get(Integer id);
	
	Client create(Client client);
	
	Client update(Client client);
	
	void delete(Integer id);
	
}
