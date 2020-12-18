package dev.fun.app.client_service.facades;

import dev.fun.app.client_service.services.LoggedInImpl;
import dev.fun.app.order_service.controllers.OrderController;

public class ClientInfoFacadeImpl implements ClientInfoFacade {

	private LoggedInImpl currentClient;
	private OrderController orderController;
	
	public ClientInfoFacadeImpl(LoggedInImpl currentClient, OrderController orderController) {
		this.currentClient = currentClient;
		this.orderController = orderController;
	}

	@Override
	public String getInfo() {
		
		// Formation of general information...
		
		return "Info {" + "Client: " + currentClient + " Orders: " + orderController + "}";
	}
	
}
