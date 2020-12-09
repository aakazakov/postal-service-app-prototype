package dev.fun.app.client_service.facades;

import java.util.List;

import dev.fun.app.client_service.entities.Client;
import dev.fun.app.client_service.services.ClientService;
import dev.fun.app.client_service.services.ClientServiceImpl;
import dev.fun.app.order_service.entities.Order;
import dev.fun.app.order_service.services.OrderService;
import dev.fun.app.order_service.services.OrderServiceImpl;

public class ClientInfoFacadeImpl implements ClientInfoFacade {

	private ClientService clientService;
	private OrderService orderService;
	
	public ClientInfoFacadeImpl(ClientServiceImpl clientService, OrderServiceImpl orderService) {
		this.clientService = clientService;
		this.orderService = orderService;
	}

	@Override
	public String getInfo() {
		Client client = clientService.getCurrent();
		
		@SuppressWarnings("unused")
		List<Order> orders = orderService.getOrders(client.getId());
		
		// Formation of general information...
		
		return "Info {" + "Client: " + client.getName() + " Orders: " + orders.size() + "}";
	}
	
}
