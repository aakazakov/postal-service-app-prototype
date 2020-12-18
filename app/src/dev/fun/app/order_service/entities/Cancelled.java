package dev.fun.app.order_service.entities;

import dev.fun.app.order_service.objects.Route;
import dev.fun.app.order_service.states.OrderState;

public class Cancelled implements OrderState {

	private final String state;
	private final Order order;

	public Cancelled(Order order) {
		this.state = "cancelled";
		this.order = order;
	}
	
	@Override
	public String state() {
		return state;
	}

	@Override
	public void changeRoute(Route route) {
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
