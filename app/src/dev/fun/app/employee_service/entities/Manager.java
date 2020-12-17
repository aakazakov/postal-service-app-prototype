package dev.fun.app.employee_service.entities;

import dev.fun.app.employee_service.enums.Position;
import dev.fun.app.employee_service.interfaces.Management;

public class Manager extends Employee implements Management {
	
	public static class Builder {
		private Manager manager;
		
		public Builder() {
			this.manager = new Manager();
		}
		
		public Builder setId(Integer id) {
			this.manager.setId(id);
			return this;
		}
		
		public Builder setName(String name) {
			this.manager.setName(name);
			return this;
		}
		
		public Builder setPassword(String password) {
			this.manager.setPassword(password);
			return this;
		}
		
		public Builder setPosition(Position position) {
			this.manager.setPosition(position);
			return this;
		}
		
		public Builder setTel(String tel) {
			this.manager.setTel(tel);
			return this;
		}
		
		public Manager build() {
			return this.manager;
		}
	}
	
	private String name;
	private String password;
	private Position position;
	private String tel;
	
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

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public Manager() {
		
	}

	public Manager(Integer id, String name, String password, Position position, String tel) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.position = position;
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return String.format(this.getClass() + "%n id: %d,%n pos: %s,%n name: %s,%n password: %s,%n tel: %s%n",
				id, position.name(), name, password, tel);
	}

	@Override
	public String info() {
		return "manager info";
	}

}
