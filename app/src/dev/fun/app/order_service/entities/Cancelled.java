package dev.fun.app.order_service.entities;

import java.util.List;

import dev.fun.app.order_service.states.OrderState;
import dev.fun.app.router_service.entities.RoutePoint;

public class Cancelled implements OrderState {

	public static final String STATE = "Cancelled";
	
	private final Order order;
	
	public Cancelled(Order order) {
		this.order = order;
	}

	@Override
	public void changeRoute(List<RoutePoint> route) {
		throw new UnsupportedOperationException("cancelled");
	}

	@Override
	public void cancelled() {
		throw new UnsupportedOperationException("current state");
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
		order.setCompleted();
	}
	
}
