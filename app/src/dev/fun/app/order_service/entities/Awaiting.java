package dev.fun.app.order_service.entities;


import dev.fun.app.order_service.states.OrderState;
import dev.fun.app.router_service.objects.Route;

public class Awaiting implements OrderState {
 
	public static final String STATE = "Awaiting";
	
	private final Order order;
	
	public Awaiting(Order order) {
		this.order = order;
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
