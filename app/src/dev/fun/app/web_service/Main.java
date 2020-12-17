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
import dev.fun.app.employee_service.datamappers.ManagerMapper;
import dev.fun.app.employee_service.entities.Manager;
import dev.fun.app.employee_service.enums.Position;

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
		
		
		// >>>>> Delete used DB file <<<<<
		try {
			Files.delete(Paths.get("postal.db"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
