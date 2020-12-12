package dev.fun.app.web_service.interfaces;

import dev.fun.app.client_service.entities.Client;
import dev.fun.app.client_service.interfaces.Customer;
import dev.fun.app.employee_service.adapters.ManagerToClientAdapter;
import dev.fun.app.employee_service.entities.Manager;
import dev.fun.app.employee_service.interfaces.Management;

public class Main {
	
	public static void main(String[] args) {
		
		Customer client = new Client.Builder().setId(10).setName("Client").build();
		
		Management manager = new Manager.Builder().setId(1).setName("Manager").build();
		Customer managerAdapter = new ManagerToClientAdapter(manager);
		
		System.out.println(client.info());
		System.out.println(managerAdapter.info());
		
	}
	
}
