package dev.fun.app.employee_service.interfaces;

import java.util.List;

import dev.fun.app.client_service.entities.Client;
import dev.fun.app.order_service.entities.Order;

/**
 * Mainly provides CRUD methods for managing customers and orders
 */
public interface Management {
	
	Order createOrder(Order order);
	Order getOrder(Integer orderId);
	List<Order> getOrders(Integer clientId);
	Order update(Order order);
	void deleteOrder(Integer orderId);
	Client createClient(Client client);
	Client getClient(Integer clientId);
	Client update(Client client);
	void deleteClient(Integer clientId);
	String info();
	
}
