package dev.fun.app.router_service.objects;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import dev.fun.app.router_service.entities.RoutePoint;

public class Route {
	
	private final List<RoutePoint> list;
	
	public Route(List<RoutePoint> list) {
		this.list = new LinkedList<>(list);
	}
	
	public List<RoutePoint> getList() {
		return list;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		Route r = (Route) obj;
		return this.list.equals(r.getList());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(list);
	}
}
