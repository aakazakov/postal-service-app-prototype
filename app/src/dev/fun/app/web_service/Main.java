package dev.fun.app.web_service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import dev.fun.app.client_service.datamappers.ClientMapper;
import dev.fun.app.client_service.entities.Client;
import dev.fun.app.client_service.interfaces.Customer;
import dev.fun.app.employee_service.adapters.ManagerToCustomerAdapter;
import dev.fun.app.employee_service.entities.Manager;
import dev.fun.app.employee_service.interfaces.Management;
import dev.fun.app.router_service.datamappers.RoutePointMapper;
import dev.fun.app.router_service.entities.RoutePoint;

public class Main {
	
	public static void main(String[] args) {
		
	// ================================= Demo :) ====================================
		
		{
			Customer client = new Client.Builder().setId(10).setName("Client").build();
			
			Management manager = new Manager.Builder().setId(1).setName("Manager").build();
			Customer managerAdapter = new ManagerToCustomerAdapter(manager);
			
			Customer[] customers = {client, managerAdapter};
			
			for(Customer c : customers) {
				System.out.println(c.info());
			}
		}
		
		// ================================= Demo :) ====================================
		
		{
			try (Connection connection = DriverManager.getConnection("jdbc:sqlite::memory:");
					Statement statement = connection.createStatement();) {
				statement.setQueryTimeout(30);
				
				statement.execute("drop table if exists route_points");
				statement.execute("create table route_points (id integer primary key, gps text, description text)");
				statement.execute("insert into route_points (id , gps, description) values (1, 'gps1', 'desc1')");
				
				RoutePointMapper routePointMapper = new RoutePointMapper(connection);
				RoutePoint routePoint = routePointMapper.findById(1);
				System.out.println(routePoint.getId());
				
				statement.execute("drop table if exists clients");
				statement.execute("create table clients (id integer primary key, name text, password text, tel text)");
				statement.execute("insert into clients (id, name, password, tel) values (1, 'Client1', 'pass1', '9999999999')");
				
				ClientMapper clientMapper = new ClientMapper(connection);
				
				Client client = clientMapper.findById(1);
				System.out.println(client.getName());
				
				clientMapper.save(new Client.Builder().setName("Client2").setPassword("Password2").setTel("1234567890").build());
				System.out.println(clientMapper.findById(10).getName());
				
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		
	}
	
}
