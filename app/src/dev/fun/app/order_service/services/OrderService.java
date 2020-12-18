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
	
	Order create(Order order);
	
	Order update(Order order);
	
	void delete(Integer id);
	
	/**
	 * Returns an order by its id.
	 * @param id {@link Order} id
	 * @return {@link Order}
	 */
	Order get(Integer id);
	
}
