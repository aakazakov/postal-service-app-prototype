package dev.fun.app.order_service.entities;

import dev.fun.app.client_service.entities.Client;
import dev.fun.app.common.money.Money;
import dev.fun.app.order_service.states.*;
import dev.fun.app.router_service.entities.Route;

public class Order {
	
	public static class Builder {
		private Order order;
		
		public Builder() {
			this.order = new Order();
		} 
		
		public Builder setId(Integer id) {
			this.order.setId(id);
			return this;
		}
		
		public Builder setWeight(Float weight) {
			this.order.setWeight(weight);
			return this;
		}
		
		public Builder setHeight(Float height) {
			this.order.setHeight(height);
			return this;
		}
		
		public Builder setWidth(Float width) {
			this.order.setWidth(width);
			return this;
		}
		
		public Builder setDepth(Float depth) {
			this.order.setDepth(depth);
			return this;
		}
		
		public Builder setRoute(Route route) {
			this.order.setRoute(route);
			return this;
		}
				
		public Builder setSender(Client sender) {
			this.order.setSender(sender);
			return this;
		}
		
		public Builder setRecipient(Client recipient) {
			this.order.setRecipient(recipient);
			return this;
		}
		
		public Builder setCost(Money cost) {
			this.order.setCost(cost);
			return this;
		}
		
		public Order build() {
			this.order.setCreated();
			return this.order;
		}		
	}
	
	private final OrderState created;
	private final OrderState awaiting;
	private final OrderState cancelled;
	private final OrderState completed;
	private final OrderState shipped;
	
	private Integer id;
	private Float weight;
	private Float height;
	private Float width;
	private Float depth;
	private Client sender;
	private Client recipient;
	private Route route;
	private Money cost;
	private OrderState state;
 	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public Float getDepth() {
		return depth;
	}

	public void setDepth(Float depth) {
		this.depth = depth;
	}

	public Client getSender() {
		return sender;
	}

	public void setSender(Client sender) {
		this.sender = sender;
	}

	public Client getRecipient() {
		return recipient;
	}

	public void setRecipient(Client recipient) {
		this.recipient = recipient;
	}

	public Route getRoute() {
		return route;
	}

	void setRoute(Route route) {
		this.route = route;
	}
	
	public Money getCost() {
		return cost;
	}
	
	public void setCost(Money cost) {
		this.cost = cost;
	}

	public OrderState getState() {
		return state;
	}

	public OrderState getShipped() {
		return shipped;
	}

	public Order() {
		this.created = new Created(this);
		this.awaiting = new Awaiting(this);
		this.cancelled = new Cancelled(this);
		this.completed = new Completed(this);
		this.shipped = new Shipped(this);
	}

	public Order(Integer id, Float weight, Float height, Float width, Float depth,
			Route route, Client sender, Client recipient, Money cost) {
		this();
		this.id = id;
		this.weight = weight;
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.route = route;
		this.sender = sender;
		this.recipient = recipient;
		this.cost = cost;
		this.state = this.created;
	}
	
	public void changeRoute(Route route) {
		state.changeRoute(route);
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
	
	void setAwaiting() {
		state = awaiting;
	}
	
	void setShipped() {
		state = shipped;
	}

	void setCompleted() {
		state = completed;
	}
	
	void setCancelled() {
		state = cancelled;
	}
	
	void setCreated() {
		state = created;
	}
}
