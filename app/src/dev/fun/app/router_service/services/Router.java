package dev.fun.app.router_service.services;

import java.util.ArrayList;
import java.util.List;

import dev.fun.app.router_service.entities.RoutePoint;

public class Router implements RouterService {
	
	@Override
	public List<RoutePoint> route(Integer start, Integer end) {
		return new ArrayList<>();
	}

}
