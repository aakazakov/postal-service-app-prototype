package dev.fun.app.web_service.interfaces;

import dev.fun.app.client_service.entities.Client;
import dev.fun.app.employee_service.adapters.ManagerToClientAdapter;
import dev.fun.app.employee_service.entities.Manager;

public class Main {
	
	public static void main(String[] args) {
		
		Client client = new Client.Builder().setId(10).setName("Client").build();
		Manager manager = new Manager.Builder().setId(1).setName("Manager").build();
		ManagerToClientAdapter managerAdapter = new ManagerToClientAdapter(manager);
		
		System.out.println(client.info());
		System.out.println(managerAdapter.info());
		
	}
	
}
