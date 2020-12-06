package dev.fun.app.order_service.entities;

import java.util.List;

import dev.fun.app.client_service.entities.Client;
import dev.fun.app.order_service.enums.OrderStatus;
import dev.fun.app.router_service.entities.RoutePoint;

public class Order {
	
	public static class Builder {
		private Integer id;
		private Float weight;
		private Float height;
		private Float width;
		private Float depth;
		private List<RoutePoint> route;
		private OrderStatus orderStatus;
		private Client sender;
		private Client recipient;
		
		public Builder setId(Integer id) {
			this.id = id;
			return this;
		}
		
		public Builder setWeight(Float weight) {
			this.weight = weight;
			return this;
		}
		
		public Builder setHeight(Float height) {
			this.height = height;
			return this;
		}
		
		public Builder setWidth(Float width) {
			this.width = width;
			return this;
		}
		
		public Builder setDepth(Float depth) {
			this.depth = depth;
			return this;
		}
		
		public Builder setRoute(List<RoutePoint> route) {
			this.route = route;
			return this;
		}
		
		public Builder setOrderStatus(OrderStatus orderStatus) {
			this.orderStatus = orderStatus;
			return this;
		}
		
		public Builder setSender(Client sender) {
			this.sender = sender;
			return this;
		}
		
		public Builder setRecipient(Client recipient) {
			this.recipient = recipient;
			return this;
		}
		
		public Order build() {
			return new Order(id, weight, height, width, depth, route, orderStatus, sender, recipient);
		}		
	}
	
	private final Integer id;
	private final Float weight;
	private final Float height;
	private final Float width;
	private final Float depth;
	private final List<RoutePoint> route;
	private final OrderStatus orderStatus;
	private final Client sender;
	private final Client recipient;
	
	public Integer getId() {
		return id;
	}
	
	public Float getWeight() {
		return weight;
	}
	
	public Float getHeight() {
		return height;
	}
	
	public Float getWidth() {
		return width;
	}
	
	public Float getDepth() {
		return depth;
	}
	
	public List<RoutePoint> getRoute() {
		return route;
	}
	
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	
	public Client getSender() {
		return sender;
	}
	
	public Client getRecipient() {
		return recipient;
	}

	public Order(Integer id, Float weight, Float height, Float width, Float depth, List<RoutePoint> route,
			OrderStatus orderStatus, Client sender, Client recipient) {
		this.id = id;
		this.weight = weight;
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.route = route;
		this.orderStatus = orderStatus;
		this.sender = sender;
		this.recipient = recipient;
	}
	
}
