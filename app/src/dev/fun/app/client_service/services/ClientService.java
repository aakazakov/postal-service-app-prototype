package dev.fun.app.client_service.services;

import dev.fun.app.client_service.entities.Client;
import dev.fun.app.exceptions.IncorrectlyFilledCredentialsException;

public interface ClientService {
		
	Client get(Integer id);
	
	Client create(Client client) throws IncorrectlyFilledCredentialsException;
	
	Client update(Client client);
	
	void delete(Integer id);
	
}
