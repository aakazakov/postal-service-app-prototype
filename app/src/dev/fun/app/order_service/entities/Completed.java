package dev.fun.app.order_service.entities;

import java.util.List;

import dev.fun.app.order_service.states.OrderState;
import dev.fun.app.router_service.entities.RoutePoint;

public class Completed implements OrderState {

	public static final String STATE = "Completed";
	
	private final Order order;
	
	public Completed(Order order) {
		this.order = order;
	}

	@Override
	public void changeRoute(List<RoutePoint> route) {
		throw new UnsupportedOperationException("completed");
	}
	
	@Override
	public void cancelled() {
		order.setCancelled();
	}

	@Override
	public void shipped() {
		order.setShipped();
	}

	@Override
	public void awaiting() {
		order.setAwaiting();
	}

	@Override
	public void completed() {
		throw new UnsupportedOperationException("current state");
	}
	
}
