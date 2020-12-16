package dev.fun.app.web_service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import dev.fun.app.common.dbconnectors.DBConnector;
import dev.fun.app.common.dbconnectors.DBConnectorFactory;
import dev.fun.app.common.dbconnectors.SQLiteConnetorFactory;
import dev.fun.app.employee_service.datamappers.ManagerMapper;
import dev.fun.app.employee_service.entities.Manager;
import dev.fun.app.employee_service.enums.Position;

public class Main {
	
	public static void main(String[] args) {
		
	// ================================= Demo :) ====================================
		
//		{
//			Customer client = new Client.Builder().setId(10).setName("Client").build();
//			
//			Management manager = new Manager.Builder().setId(1).setName("Manager").build();
//			Customer managerAdapter = new ManagerToCustomerAdapter(manager);
//			
//			Customer[] customers = {client, managerAdapter};
//			
//			for(Customer c : customers) {
//				System.out.println(c.info());
//			}
//		}
		
		// ================================= Demo :) ====================================
		

		// DB preparation
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite::memory:"); 
			Statement s = connection.createStatement();
			s.execute("create table managers "
					+ "(id integer primary key autoincrement, name text, password text, position text, tel text)");
			connection.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		DBConnectorFactory connectorFactory = new SQLiteConnetorFactory();
		DBConnector connector = connectorFactory.create();
		
		ManagerMapper managerMapper = new ManagerMapper(connector);
		
		Manager m = new Manager.Builder()
				.setName("name")
				.setPassword("pass")
				.setPosition(Position.MANAGER)
				.setTel("123456")
				.build();
	
		Manager newManager = managerMapper.save(m);
		System.out.println(newManager.getName());
	}
	
}
