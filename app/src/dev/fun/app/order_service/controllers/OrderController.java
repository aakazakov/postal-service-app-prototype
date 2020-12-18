package dev.fun.app.order_service.controllers;

import java.util.List;

import dev.fun.app.order_service.entities.Order;
import dev.fun.app.order_service.services.OrderService;

public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public Order create(Order order) {
		return orderService.create(order);
	}
	
	public Order get(Integer id) {
		return orderService.get(id);
	}
	
	public List<Order> clientOrders(Integer clientId) {
		return orderService.getOrders(clientId);
	}
	
	public Order update(Order order) {
		return orderService.update(order);
	}
	
	public void delete(Integer id) {
		orderService.delete(id);
	}
	
}
