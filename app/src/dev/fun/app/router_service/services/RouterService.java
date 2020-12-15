package dev.fun.app.router_service.services;

import dev.fun.app.router_service.entities.Route;
import dev.fun.app.router_service.entities.RoutePoint;

public interface RouterService {
	
	/**
	 * Computes a route.
	 * @param start an id of {@link RoutePoint}.
	 * @param end an id of {@link RoutePoint}.
	 * @return {@link Route}.
	 */
	Route route(Integer start, Integer end);
	
}
