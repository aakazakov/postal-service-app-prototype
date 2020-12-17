package dev.fun.app.common.dbconnectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class SQLiteConnector implements DBConnector {
	
	private Logger logger = Logger.getLogger("SQLiteConnector");
	
	private static final String DRIVER = "jdbc:sqlite:postal.db";
	
	private Connection connection;
	
	public SQLiteConnector() {
		connection = null;
	}

	@Override
	public Connection connect() {
		logger.info("`connect` method invoked");
		try {
			connection = DriverManager.getConnection(DRIVER);
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		return connection;
	}

	@Override
	public void disconnect() {
		logger.info("`disconnect` method invoked");
		if (connection == null) return;
		try {
			connection.close();
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
	}

}
