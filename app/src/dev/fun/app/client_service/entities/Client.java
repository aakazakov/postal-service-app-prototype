package dev.fun.app.client_service.entities;

import dev.fun.app.client_service.facades.ClientInfoFacade;
import dev.fun.app.client_service.facades.ClientInfoFacadeImpl;
import dev.fun.app.client_service.interfaces.Customer;
import dev.fun.app.client_service.services.ClientServiceImpl;
import dev.fun.app.order_service.services.OrderServiceImpl;

public class Client implements Customer {
	
	public static class Builder {
		private Client client;
		
		public Builder() {
			this.client = new Client();
		}
		
		public Builder setId(Integer id) {
			this.client.setId(id);
			return this;
		}
		
		public Builder setName(String name) {
			this.client.setName(name);
			return this;
		}
		
		public Builder setPassword(String password) {
			this.client.setPassword(password);
			return this;
		}
		
		public Builder setTel(String tel) {
			this.client.setTel(tel);
			return this;
		}
		
		public Client build() {
			return this.client;
		}			
	}
	
	private Integer id;
	private String name;
	private String password;
	private String tel;
	private ClientInfoFacade clientInfoFacade;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Client() {
		this.clientInfoFacade = new ClientInfoFacadeImpl(new ClientServiceImpl(), new OrderServiceImpl());
	}
	
 	public Client(Integer id, String name, String password, String tel) {
 		this();
		this.id = id;
		this.name = name;
		this.password = password;
		this.tel = tel;
	}

	@Override
	public String info() {
		return clientInfoFacade.getInfo();
	}

}
