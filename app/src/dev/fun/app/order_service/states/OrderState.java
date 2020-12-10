package dev.fun.app.order_service.states;

import java.util.List;

import dev.fun.app.router_service.entities.RoutePoint;

public interface OrderState {
	
	void changeRoute(List<RoutePoint> route);
	
	void cancelled();
	
	void shipped();
	
	void awaiting();
	
	void completed();
}
