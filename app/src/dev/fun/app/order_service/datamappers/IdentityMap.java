package dev.fun.app.order_service.datamappers;

import java.util.HashMap;
import java.util.Map;

import dev.fun.app.order_service.entities.Order;

public class IdentityMap {
	
	private static ThreadLocal<IdentityMap> current = new ThreadLocal<>();
	
	private Map<Integer, Order> entities;
	
	public static IdentityMap getCurrent() {
		return current.get();
	}
	
	public IdentityMap() {
		entities = new HashMap<>();
	}
	
	public static void init() {
		current.set(new IdentityMap());
	}
	
	public void add(Order order) {
		entities.put(order.getId(), order);
	}
	
	public Order find(Integer id) {
		return entities.get(id);
	}
	
	public void remove(Order order) {
		entities.remove(order.getId());
	}
	
	public void clear() {
		entities.clear();
	}

}
