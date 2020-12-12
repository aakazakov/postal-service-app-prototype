package dev.fun.app.client_service.entities;

import dev.fun.app.client_service.facades.ClientInfoFacade;
import dev.fun.app.client_service.facades.ClientInfoFacadeImpl;
import dev.fun.app.client_service.interfaces.Customer;
import dev.fun.app.client_service.services.ClientServiceImpl;
import dev.fun.app.order_service.services.OrderServiceImpl;

public class Client implements Customer {
	
	public static class Builder {
		private Integer id;
		private String name;
		private String password;
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
		
		public Builder setTel(String tel) {
			this.tel = tel;
			return this;
		}
		
		public Client build() {
			return new Client(id, name, password, tel);
		}			
	}
	
	private final Integer id;
	private final String name;
	private final String password;
	private final String tel;
	private final ClientInfoFacade clientInfoFacade;
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getTel() {
		return tel;
	}
	
	public Client(Integer id, String name, String password, String tel) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.tel = tel;
		this.clientInfoFacade = new ClientInfoFacadeImpl(new ClientServiceImpl(), new OrderServiceImpl());
	}

	@Override
	public String info() {
		return clientInfoFacade.getInfo();
	}

}
