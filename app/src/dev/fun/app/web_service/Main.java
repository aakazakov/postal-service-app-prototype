package dev.fun.app.web_service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Locale;

import dev.fun.app.client_service.datamappers.ClientMapper;
import dev.fun.app.client_service.entities.Client;
import dev.fun.app.client_service.interfaces.Customer;
import dev.fun.app.common.money.Money;
import dev.fun.app.employee_service.adapters.ManagerToCustomerAdapter;
import dev.fun.app.employee_service.entities.Manager;
import dev.fun.app.employee_service.interfaces.Management;
import dev.fun.app.order_service.datamappers.IdentityMap;
import dev.fun.app.order_service.datamappers.OrderMapper;
import dev.fun.app.order_service.entities.Order;
import dev.fun.app.router_service.datamappers.RoutePointMapper;
import dev.fun.app.router_service.entities.Route;
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
				
				Client client1 = clientMapper.findById(1);
				System.out.println(client1.getName());
				
				clientMapper.save(new Client.Builder().setName("Client2").setPassword("Password2").setTel("1234567890").build());
				Client client2 = clientMapper.findById(10);
				System.out.println(client2.getName());
				
				statement.execute("drop table if exists orders");
				statement.execute("create table orders"
						+ " (id integer primary key, weight real, height real, width real, depth real,"
						+ " sender integer, recipient integer, route integer, cost integer, state text)");
				
				OrderMapper orderMapper = new OrderMapper(connection);
				orderMapper.save(new Order.Builder().setWeight(10.0f)
						.setHeight(20.0f).setDepth(15.0f).setWidth(20.0f)
						.setCost(new Money(100L, Locale.US)).setSender(client1).setRecipient(client2)
						.setRoute(new Route(1, new LinkedList<>())).build());
				
				Order order = orderMapper.findById(1);
				
				IdentityMap.init();
				IdentityMap.getCurrent().add(order);
				
				System.out.println(IdentityMap.getCurrent().find(1).getId());
				
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		
	}
	
}
