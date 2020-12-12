package dev.fun.app.router_service.services;

import java.util.ArrayList;
import java.util.List;

import dev.fun.app.router_service.entities.RoutePoint;

public interface RouterService {
	
	/**
	 * Computes a route.
	 * @param start an id of {@link RoutePoint}.
	 * @param end an id of {@link RoutePoint}.
	 * @return {@link ArrayList} of {@link RoutePoint}.
	 */
	List<RoutePoint> route(Integer start, Integer end);
	
}
