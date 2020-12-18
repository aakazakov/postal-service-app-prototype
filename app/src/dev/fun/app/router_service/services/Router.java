package dev.fun.app.router_service.services;

import java.util.LinkedList;

import dev.fun.app.router_service.objects.Route;

public class Router implements RouterService {
	
	@Override
	public Route route(Integer start, Integer end) {
		return new Route(new LinkedList<>());
	}

}
