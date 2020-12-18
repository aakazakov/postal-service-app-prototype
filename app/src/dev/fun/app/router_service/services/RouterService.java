package dev.fun.app.router_service.services;

import java.util.LinkedList;
import java.util.List;

import dev.fun.app.router_service.entities.RoutePoint;

public interface RouterService {
	
	/**
	 * Computes a route.
	 * @param start an id of {@link RoutePoint}.
	 * @param end an id of {@link RoutePoint}.
	 * @return {@link LinkedList} of {@link RoutePoint}.
	 */
	List<RoutePoint> newRoute(Integer start, Integer end);
	
	/**
	 * Returns the existing route associated with the {@link Order} id
	 * @param orderId {@link Order} id
	 * @return {@link LinkedList} of {@link RoutePoint}
	 */
	List<RoutePoint> route(Integer orderId);
	
}
