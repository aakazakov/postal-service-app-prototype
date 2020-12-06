package dev.fun.app.web_service.interfaces;

import java.util.List;

import dev.fun.app.client_service.entities.Client;
import dev.fun.app.order_service.entities.Order;


public interface ClientService {

	List<Order> getOrders(Integer clientId);
	Order update(Order order);
	Client update(Client client);
	Client getClient(Integer clientId);
	
}
