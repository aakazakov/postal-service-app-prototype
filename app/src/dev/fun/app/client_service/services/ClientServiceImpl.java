package dev.fun.app.client_service.services;

import dev.fun.app.client_service.datamappers.ClientMapper;
import dev.fun.app.client_service.entities.Client;

public class ClientServiceImpl implements ClientService {

	private ClientMapper clientMapper;
	
	public ClientServiceImpl(ClientMapper clientMapper2) {
		this.clientMapper = clientMapper2;
	}

	@Override
	public Client get(Integer id) {
		return clientMapper.findById(id);
	}

	@Override
	public Client create(Client client) {
		return clientMapper.save(client);
	}

	@Override
	public Client update(Client client) {
		throw new UnsupportedOperationException("not yet supported");
	}

	@Override
	public void delete(Integer id) {
		clientMapper.delete(id);
	}

}
