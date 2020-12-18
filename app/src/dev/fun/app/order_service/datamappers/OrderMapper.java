package dev.fun.app.order_service.datamappers;

import java.util.List;

import dev.fun.app.order_service.entities.Order;

public interface OrderMapper {

	Order save(Order order);
	void delete(Integer id);
	Order findById(Integer id);
	List<Order> findByClientId(Integer id);
	
}
