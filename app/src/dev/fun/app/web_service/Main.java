package dev.fun.app.web_service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import dev.fun.app.client_service.entities.Client;
import dev.fun.app.client_service.interfaces.Customer;
import dev.fun.app.employee_service.adapters.ManagerToClientAdapter;
import dev.fun.app.employee_service.entities.Manager;
import dev.fun.app.employee_service.interfaces.Management;
import dev.fun.app.router_service.datamappers.RoutePointMapper;
import dev.fun.app.router_service.entities.RoutePoint;

public class Main {
	
	public static void main(String[] args) {
		
		Customer client = new Client.Builder().setId(10).setName("Client").build();
		
		Management manager = new Manager.Builder().setId(1).setName("Manager").build();
		Customer managerAdapter = new ManagerToClientAdapter(manager);
		
		System.out.println(client.info());
		System.out.println(managerAdapter.info());
		
		// ===============================================
		
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite::memory:");
				Statement statement = connection.createStatement();) {
			statement.setQueryTimeout(30);
			statement.execute("drop table if exists route_point");
			statement.execute("create table route_point (id integer primary key, gps text, description text)");
			statement.execute("insert into route_point (id , gps, description) values (1, 'gps1', 'desc1')");
			
			RoutePointMapper mapper = new RoutePointMapper(connection);
			RoutePoint actual = mapper.findById(1);
			
			System.out.println(actual.getId());
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
}
