package dev.fun.app.order_service.services;


import java.util.List;

import dev.fun.app.order_service.datamappers.OrderMapper;
import dev.fun.app.order_service.entities.Order;
import dev.fun.app.order_service.objects.Route;
import dev.fun.app.router_service.controllers.RouterController;
import dev.fun.app.router_service.entities.RoutePoint;

public class OrderServiceImpl implements OrderService {
	
	private OrderMapper orderMapper;
	private RouterController routerController;
	
	public OrderServiceImpl(OrderMapper orderMapper, RouterController routerController) {
		this.orderMapper = orderMapper;
		this.routerController = routerController;
	}

	@Override
	public List<Order> getOrders(Integer clientId) {
		return orderMapper.findByClientId(clientId);
	}

	@Override
	public Order create(Order order) {
		List<RoutePoint> route = routerController.newRoute(1, 2);
		Order o = orderMapper.save(order);
		o.changeRoute(new Route(route));
		return o;
	}

	@Override
	public Order update(Order order) {
		throw new UnsupportedOperationException("not yet...");
	}

	@Override
	public void delete(Integer id) {
		orderMapper.delete(id);
	}

	@Override
	public Order get(Integer id) {
		return orderMapper.findById(id);
	}

}
