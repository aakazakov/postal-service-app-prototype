package dev.fun.app.order_service.entities;

import dev.fun.app.client_service.entities.Client;
import dev.fun.app.order_service.states.*;
import dev.fun.app.router_service.objects.Route;

public class Order {
	
	public static class Builder {
		private Integer id;
		private Float weight;
		private Float height;
		private Float width;
		private Float depth;
		private Route route;
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
		
		public Builder setRoute(Route route) {
			this.route = route;
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
			return new Order(id, weight, height, width, depth, route, sender, recipient);
		}		
	}
	
	private final OrderState created;
	private final OrderState awaiting;
	private final OrderState cancelled;
	private final OrderState completed;
	private final OrderState shipped;
	
	private final Integer id;
	private final Float weight;
	private final Float height;
	private final Float width;
	private final Float depth;
	private final Client sender;
	private final Client recipient;	
	
	private Route route;
	private OrderState state;
 	
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
	
	public OrderState getState() {
		return state;
	}

	public Route getRoute() {
		return route;
	}
	
	public Client getSender() {
		return sender;
	}
	
	public Client getRecipient() {
		return recipient;
	}

	public Order(Integer id, Float weight, Float height, Float width, Float depth,
			Route route, Client sender, Client recipient) {
		this.id = id;
		this.weight = weight;
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.route = route;
		this.sender = sender;
		this.recipient = recipient;
		this.created = new Created(this);
		this.awaiting = new Awaiting(this);
		this.cancelled = new Cancelled(this);
		this.completed = new Completed(this);
		this.shipped = new Shipped(this);
		this.state = this.created;
	}
	
	public void changeRoute(Route route) {
		state.changeRoute(route);
	}
	
	void setRoute(Route route) {
		this.route = route;
	}
	
	public void cancelled() {
		state.cancelled();
	}
	
	public void awaiting() {
		state.awaiting();
	}
	
	public void shipped() {
		state.shipped();
	}
	
	public void completed() {
		state.completed();
	}
	
	void setCancelled() {
		state = cancelled;
	}
	
	void setAwaiting() {
		state = awaiting;
	}
	
	void setShipped() {
		state = shipped;
	}

	void setCompleted() {
		state = completed;
	}
	
}
