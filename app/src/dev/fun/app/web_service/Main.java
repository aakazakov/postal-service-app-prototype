package dev.fun.app.web_service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import dev.fun.app.common.dbconnectors.DBConnector;
import dev.fun.app.common.dbconnectors.DBConnectorFactory;
import dev.fun.app.common.dbconnectors.SQLiteConnetorFactory;
import dev.fun.app.employee_service.controllers.ManagerController;
import dev.fun.app.employee_service.datamappers.ManagerMapper;
import dev.fun.app.employee_service.entities.Manager;
import dev.fun.app.employee_service.enums.Position;
import dev.fun.app.employee_service.services.ManagerService;

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
		
		Manager manager = new Manager.Builder()
				.setName("JohnTheManager")
				.setPassword("secure")
				.setPosition(Position.MANAGER)
				.setTel("99999999999")
				.build();
	
		Manager newManager = managerController.create(manager);
		
		System.out.println(newManager);
		
		
		
		// >>>>> Delete used DB file <<<<<
		try {
			Files.delete(Paths.get("postal.db"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
