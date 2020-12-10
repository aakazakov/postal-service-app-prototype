package dev.fun.app.order_service.services;

import java.util.ArrayList;
import java.util.List;

import dev.fun.app.order_service.entities.Order;

public class OrderServiceImpl implements OrderService {

	@Override
	public List<Order> getOrders(Integer clientId) {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order.Builder().setId(1).build());
		return orders;
	}

}
