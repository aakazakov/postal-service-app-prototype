package dev.fun.app.client_service.entities;

import dev.fun.app.client_service.interfaces.Clientable;

public class Client implements Clientable {
	
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
	}

	@Override
	public String info() {
		throw new UnsupportedOperationException("temporarily)");
	}

}
