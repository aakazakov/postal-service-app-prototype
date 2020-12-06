package dev.fun.app.employee_service.entities;

import java.util.List;


import dev.fun.app.client_service.entities.Client;
import dev.fun.app.employee_service.enums.Position;
import dev.fun.app.order_service.entities.Order;
import dev.fun.app.web_service.interfaces.ClientService;
import dev.fun.app.web_service.interfaces.ManagerService;

public class Manager implements ClientService, ManagerService {
	
	public static class Builder {
		private Integer id;
		private String name;
		private String password;
		private Position position;
		private String tel;
		
		public Builder setId(Integer id) {
			this.id = id;
			return this;
		}
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}
		
		public Builder setPosition(Position position) {
			this.position = position;
			return this;
		}
		
		public Builder setTel(String tel) {
			this.tel = tel;
			return this;
		}
		
		public Manager build() {
			return new Manager(id, name, password, position, tel);
		}
	}
	
	private final Integer id;
	private final String name;
	private final String password;
	private final Position position;
	private final String tel;
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public Position getPosition() {
		return position;
	}

	public String getTel() {
		return tel;
	}
	
	public Manager(Integer id, String name, String password, Position position, String tel) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.position = position;
		this.tel = tel;
	}

	@Override
	public Order createOrder(Order order) {
		throw new UnsupportedOperationException("createOrder");
	}

	@Override
	public Order getOrder(Integer orderId) {
		throw new UnsupportedOperationException("getOrder");
	}

	@Override
	public Client createClient(Client client) {
		throw new UnsupportedOperationException("createClient");
	}

	@Override
	public void deleteOrder(Integer orderId) {
		throw new UnsupportedOperationException("deleteOrder");
	}

	@Override
	public void deleteClient(Integer clientId) {
		throw new UnsupportedOperationException("deleteClient");
	}

	@Override
	public List<Order> getOrders(Integer clientId) {
		throw new UnsupportedOperationException("getOrders");
	}

	@Override
	public Order update(Order order) {
		throw new UnsupportedOperationException("update");
	}

	@Override
	public Client update(Client client) {
		throw new UnsupportedOperationException("update");
	}

	@Override
	public Client getClient(Integer clientId) {
		throw new UnsupportedOperationException("getClient");
	}

}
