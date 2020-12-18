package dev.fun.app.router_service.services;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import dev.fun.app.router_service.datamappers.RoutePointMapper;
import dev.fun.app.router_service.entities.RoutePoint;

public class Router implements RouterService {
	
	private RoutePointMapper routePointMapper;
	
	public Router(RoutePointMapper routePointMapper) {
		this.routePointMapper = routePointMapper;
	}

	@Override
	public List<RoutePoint> newRoute(Integer start, Integer end) {
		// stub code below
		RoutePoint startPoint = routePointMapper.findById(start);
		RoutePoint endPoint = routePointMapper.findById(end);
		return new LinkedList<>(Arrays.asList(startPoint, endPoint));
	}

	@Override
	public List<RoutePoint> route(Integer orderId) {
		return null;
	}

}
