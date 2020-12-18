package dev.fun.app.order_service.objects;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import dev.fun.app.router_service.entities.RoutePoint;

public class Route {
		
	private final List<RoutePoint> pointList;
	
	public Route(List<RoutePoint> list) {
		this.pointList = new LinkedList<>(list);
	}
	
	public List<RoutePoint> getPointList() {
		return pointList;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		Route r = (Route) obj;
		return this.pointList.equals(r.getPointList());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(pointList);
	}
}
