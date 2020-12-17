package dev.fun.app.client_service.datamappers;

import dev.fun.app.client_service.entities.Client;

public interface ClientMapper {
	
	Client save(Client manager);
	
	Client findById(Integer id);
	
	void delete(Integer id);
	
}
