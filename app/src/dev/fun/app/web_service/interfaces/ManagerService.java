package dev.fun.app.web_service.interfaces;

import dev.fun.app.client_service.entities.Client;
import dev.fun.app.order_service.entities.Order;

public interface ManagerService {
	
	Order createOrder(Order order);
	Order getOrder(Integer orderId);
	Client createClient(Client client);
	void deleteOrder(Integer orderId);
	void deleteClient(Integer clientId);
	
}
