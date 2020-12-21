package dev.fun.app.client_service.services;

import dev.fun.app.client_service.datamappers.ClientMapper;
import dev.fun.app.client_service.entities.Client;
import dev.fun.app.client_service.facades.ClientInfoFacade;

public class ClientServiceImpl implements ClientService {

	private ClientMapper clientMapper;
	private ClientInfoFacade clientInfoFacade;
	
	public ClientServiceImpl(ClientMapper clientMapper, ClientInfoFacade clientInfoFacade) {
		this.clientMapper = clientMapper;
		this.clientInfoFacade = clientInfoFacade;
	}

	@Override
	public Client get(Integer id) {
		Client client = clientMapper.findById(id);
		client.setClientInfoFacade(clientInfoFacade);
		return client;
	}

	@Override
	public Client create(Client c) {
		Client client = clientMapper.save(c);
		client.setClientInfoFacade(clientInfoFacade);
		return client;
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
