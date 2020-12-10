package dev.fun.app.order_service.entities;

import java.util.List;

import dev.fun.app.order_service.states.OrderState;
import dev.fun.app.router_service.entities.RoutePoint;

public class Awaiting implements OrderState {
 
	public static final String STATE = "Awaiting";
	
	private final Order order;
	
	public Awaiting(Order order) {
		this.order = order;
	}

	@Override
	public void changeRoute(List<RoutePoint> route) {
		order.setRoute(route);
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
		throw new UnsupportedOperationException("current state");
	}

	@Override
	public void completed() {
		order.setCompleted();
	}

}
