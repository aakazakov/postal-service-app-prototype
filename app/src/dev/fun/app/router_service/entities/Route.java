package dev.fun.app.router_service.entities;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Route {
		
	private final List<RoutePoint> list;
	
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Route(List<RoutePoint> list) {
		this.list = new LinkedList<>(list);
	}
	
	public Route(Integer id, List<RoutePoint> list) {
		this.id = id;
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
