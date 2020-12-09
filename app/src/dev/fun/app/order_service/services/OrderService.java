package dev.fun.app.order_service.services;

import java.util.List;

import dev.fun.app.order_service.entities.Order;

public interface OrderService {

	/**
	 * Returns all orders by {@link Client} id.
	 * @param clientId client id
	 * @return list of {@link Order}
	 */
	List<Order> getOrders(Integer clientId);
	
}
