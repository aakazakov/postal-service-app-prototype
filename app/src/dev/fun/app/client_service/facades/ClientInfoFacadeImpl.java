package dev.fun.app.client_service.facades;

import dev.fun.app.client_service.services.CurrentImpl;
import dev.fun.app.order_service.controllers.OrderController;

public class ClientInfoFacadeImpl implements ClientInfoFacade {

	private CurrentImpl currentClient;
	private OrderController orderController;
	
	public ClientInfoFacadeImpl(CurrentImpl currentClient, OrderController orderController) {
		this.currentClient = currentClient;
		this.orderController = orderController;
	}

	@Override
	public String getInfo() {
		
		// Formation of general information...
		
		return "Info {" + "Client: " + currentClient + " Orders: " + orderController + "}";
	}
	
}
