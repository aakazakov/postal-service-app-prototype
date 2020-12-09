package dev.fun.app.order_service.services;

import java.util.ArrayList;
import java.util.List;

import dev.fun.app.order_service.entities.Order;
import dev.fun.app.order_service.enums.OrderStatus;

public class OrderServiceImpl implements OrderService {

	@Override
	public List<Order> getOrders(Integer clientId) {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order.Builder().setOrderStatus(OrderStatus.SHIPPED).build());
		return orders;
	}

}
