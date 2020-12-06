package dev.fun.app.router_service.entities;

import java.util.ArrayList;
import java.util.List;

public class Router {
	
	/**
	 * Computes a route.
	 * @param start an id of {@link RoutePoint}.
	 * @param end an id of {@link RoutePoint}.
	 * @return {@link ArrayList} of {@link RoutePoint}.
	 */
	public List<RoutePoint> route(Integer start, Integer end) {
		return new ArrayList<>();
	}

}
