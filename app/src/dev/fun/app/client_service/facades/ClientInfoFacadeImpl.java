package dev.fun.app.client_service.facades;

import java.util.List;

import dev.fun.app.client_service.entities.Client;
import dev.fun.app.client_service.services.LoggedInImpl;
import dev.fun.app.order_service.controllers.OrderController;
import dev.fun.app.order_service.entities.Order;

public class ClientInfoFacadeImpl implements ClientInfoFacade {

	private LoggedInImpl loggedIn;
	private OrderController orderController;
	
	public ClientInfoFacadeImpl(LoggedInImpl currentClient, OrderController orderController) {
		this.loggedIn = currentClient;
		this.orderController = orderController;
	}

	@Override
	public String getInfo() {
		
		// Formation of general information...
		// ...
		
		Client current = loggedIn.getCurrent();
		List<Order> orders = orderController.clientOrders(current.getId());
		
		return "Info {client: " + current.getName() + " , orders count: " + orders.size() + "}";
	}
	
}
