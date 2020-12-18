package dev.fun.app.web_service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import dev.fun.app.client_service.controllers.ClientController;
import dev.fun.app.client_service.datamappers.ClientMapper;
import dev.fun.app.client_service.datamappers.ClientMapperImpl;
import dev.fun.app.client_service.entities.Client;
import dev.fun.app.client_service.facades.ClientInfoFacade;
import dev.fun.app.client_service.facades.ClientInfoFacadeImpl;
import dev.fun.app.client_service.interfaces.Customer;
import dev.fun.app.client_service.services.ClientService;
import dev.fun.app.client_service.services.ClientServiceImpl;
import dev.fun.app.client_service.services.LoggedInImpl;
import dev.fun.app.common.dbconnectors.DBConnector;
import dev.fun.app.common.dbconnectors.DBConnectorFactory;
import dev.fun.app.common.dbconnectors.SQLiteConnetorFactory;
import dev.fun.app.common.money.Money;
import dev.fun.app.employee_service.adapters.ManagerToCustomerAdapter;
import dev.fun.app.employee_service.controllers.ManagerController;
import dev.fun.app.employee_service.datamappers.ManagerMapper;
import dev.fun.app.employee_service.entities.Manager;
import dev.fun.app.employee_service.enums.Position;
import dev.fun.app.employee_service.services.ManagerService;
import dev.fun.app.order_service.controllers.OrderController;
import dev.fun.app.order_service.datamappers.OrderMapper;
import dev.fun.app.order_service.datamappers.OrderMapperImpl;
import dev.fun.app.order_service.entities.Order;
import dev.fun.app.order_service.services.OrderService;
import dev.fun.app.order_service.services.OrderServiceImpl;
import dev.fun.app.router_service.controllers.RouterController;
import dev.fun.app.router_service.datamappers.RoutePointMapper;
import dev.fun.app.router_service.datamappers.RoutePointMapperImpl;
import dev.fun.app.router_service.services.Router;
import dev.fun.app.router_service.services.RouterService;

public class Main {
	
	public static void main(String[] args) {

		// ================================ Demo :) ================================
		
		// >>>>> DB preparation <<<<<
		
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:postal.db");
				 Statement s = connection.createStatement();) {
			s.setQueryTimeout(30);
			
			s.execute("drop table if exists managers");
			s.execute("create table managers "
					+ "(id integer primary key autoincrement, name text, password text, position text, tel text)");
			
			s.execute("drop table if exists clients");
			s.execute("create table clients "
					+ "(id integer primary key autoincrement, name text, password text, tel text)");
			
			s.execute("drop table if exists orders");
			s.execute("create table orders "
					+ "(id integer primary key autoincrement, weight real, height real, width real, "
					+ "depth real, sender_id integer, recipient_id integer, cost integer, state text)");
	
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		// >>>>>>>>>>>>><<<<<<<<<<<<<
		
		// >>>>>>>> Action ) <<<<<<<<	
		
		DBConnectorFactory connectorFactory = new SQLiteConnetorFactory();
		DBConnector connector = connectorFactory.create();
		
		ManagerMapper managerMapper = new ManagerMapper(connector);
		ManagerService managerService = new ManagerService(managerMapper);
		ManagerController managerController = new ManagerController(managerService);
		
		ClientMapper clientMapper = new ClientMapperImpl(connector);
		ClientService clientService = new ClientServiceImpl(clientMapper);
		ClientController clientController = new ClientController(clientService);
		
		RoutePointMapper routePointMapper = new RoutePointMapperImpl(connector);
		RouterService routerService = new Router(routePointMapper);
		RouterController routerController = new RouterController(routerService);
		
		OrderMapper orderMapper = new OrderMapperImpl(connector);
		OrderService orderService = new OrderServiceImpl(orderMapper,routerController);
		OrderController orderController = new OrderController(orderService);
		
		ClientInfoFacade clientInfoFacade = new ClientInfoFacadeImpl(new LoggedInImpl(), orderController);
		
		Manager m = new Manager.Builder()
				.setName("JohnTheManager")
				.setPassword("secure")
				.setPosition(Position.MANAGER)
				.setTel("99999999999")
				.build();
	
		Manager manager = managerController.create(m); // we have got a manager	
		System.out.println(manager);
		
		Client c1 = new Client.Builder()
				.setName("TomTheSender")
				.setPassword("123")
				.setTel("88888888888")
				.build();	
		
		Client sender = clientController.create(c1); // we have got a sender
		
		sender.setClientInfoFacade(clientInfoFacade);
		
		System.out.println(sender);
		
		Client c2 = new Client.Builder()
				.setName("MaryTheRecipient")
				.setPassword("pass")
				.setTel("77777777777")
				.build();
		
		Client recipient = clientController.create(c2);	// we have got a recipient
		
		recipient.setClientInfoFacade(clientInfoFacade);
		
		System.out.println(recipient);
		
		Order o = new Order.Builder()
				.setWeight(10.0f)
				.setWidth(1.0f)
				.setHeight(3.5f)
				.setDepth(2.0f)
				.setCost(new Money(500L, Locale.US))
				.setSenderId(sender.getId())
				.setRecipientId(recipient.getId())
				.build();
		
		Order order = orderController.create(o);
		System.out.println(order);
		
		// manager adapter check
		List<Customer> customers = new ArrayList<>();	
		ManagerToCustomerAdapter managerAdapter = new ManagerToCustomerAdapter(manager);		
		customers.add(managerAdapter);
		customers.add(sender);
		customers.add(recipient);
		customers.forEach(c -> System.out.println(c.info()));
		
		
		// >>>>> Delete used DB file <<<<<
		try {
			Files.delete(Paths.get("postal.db"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
