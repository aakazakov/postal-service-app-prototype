package dev.fun.app.order_service.states;

import dev.fun.app.router_service.objects.Route;

public interface OrderState {
	
	void changeRoute(Route route);
	
	void cancelled();
	
	void shipped();
	
	void awaiting();
	
	void completed();
	
	String state();
}
