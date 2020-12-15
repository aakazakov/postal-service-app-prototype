package dev.fun.app.order_service.entities;


import dev.fun.app.order_service.states.OrderState;
import dev.fun.app.router_service.entities.Route;

public class Awaiting implements OrderState {
 
	private final String state;
	private final Order order;

	public Awaiting(Order order) {
		this.state = "Awaiting";
		this.order = order;
	}
	
	@Override
	public String state() {
		return state;
	}

	@Override
	public void changeRoute(Route route) {
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
