package dev.fun.app.client_service.facades;

import dev.fun.app.client_service.services.CurrentImpl;
import dev.fun.app.order_service.services.OrderService;
import dev.fun.app.order_service.services.OrderServiceImpl;

public class ClientInfoFacadeImpl implements ClientInfoFacade {

	private CurrentImpl currentClient;
	private OrderService orderService; // Repository
	
	public ClientInfoFacadeImpl(CurrentImpl currentClient, OrderServiceImpl orderService) {
		this.currentClient = currentClient;
		this.orderService = orderService;
	}

	@Override
	public String getInfo() {
		
		// Formation of general information...
		
		return "Info {" + "Client: " + currentClient + " Orders: " + orderService + "}";
	}
	
}
