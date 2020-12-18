package dev.fun.app.router_service.controllers;

import java.util.List;

import dev.fun.app.router_service.entities.RoutePoint;
import dev.fun.app.router_service.services.RouterService;

public class RouterController {
	
	private RouterService routerService;
	
	public RouterController(RouterService routerService) {
		this.routerService = routerService;
	}

	public List<RoutePoint> newRoute(Integer start, Integer end) {		
		return routerService.newRoute(start, end);
	}
	
	public List<RoutePoint> getRoute(Integer orderId) {
		return routerService.route(orderId);
	}
	
}
