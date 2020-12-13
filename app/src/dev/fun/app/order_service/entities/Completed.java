package dev.fun.app.order_service.entities;

import dev.fun.app.order_service.states.OrderState;
import dev.fun.app.router_service.objects.Route;

public class Completed implements OrderState {

	public static final String STATE = "Completed";
	
	private final Order order;
	
	public Completed(Order order) {
		this.order = order;
	}

	@Override
	public void changeRoute(Route route) {
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
