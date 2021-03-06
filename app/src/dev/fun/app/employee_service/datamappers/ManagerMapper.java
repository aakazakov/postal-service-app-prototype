package dev.fun.app.employee_service.datamappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import dev.fun.app.db.connectors.DBConnector;
import dev.fun.app.employee_service.entities.Manager;
import dev.fun.app.employee_service.enums.Position;

public class ManagerMapper implements EmployeeMapper<Manager> {
	
	private Logger logger = Logger.getLogger("ManagerMapper");
	
	private final Map<Integer, Manager> identityMap = new HashMap<>();
	
	private final String tableName = "managers";
	
	private DBConnector connector;

	public ManagerMapper(DBConnector connector) {
		this.connector = connector;
	}

	@Override
	public Manager save(Manager manager) {
		String query = "INSERT INTO " + tableName + " (name, password, position, tel) VALUES (?, ?, ?, ?)";
		Manager newManager = null;
		Integer id = -1;
		try (Connection connection = connector.connect();
				PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setString(1, manager.getName());
			statement.setString(2, manager.getPassword());
			statement.setString(3, manager.getPosition().name());
			statement.setString(4, manager.getTel());
			int exeSuccess = statement.executeUpdate();
			if (exeSuccess > 0) {
				id = getLastInsertedId(connection);
			}			
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		if (id != -1) {
			newManager = findById(id);
		} 
		return newManager;
	}
	
	private Integer getLastInsertedId(Connection connection) {
		Integer id = null;
		try (Statement statement = connection.createStatement()) {
			ResultSet set = statement.executeQuery("SELECT last_insert_rowid() FROM " + tableName);
			id = set.getInt(1);
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		logger.info("last inserted id = " + id);
		return id;
	}

	@Override
	public Manager findById(Integer id) {
		if (inCache(id)) {
			return identityMap.get(id);
		}
		Manager manager = null;
		String query = "SELECT id, name, password, position, tel FROM " + tableName + " WHERE id=?";
		try (Connection connection = connector.connect();
				PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setInt(1, id);
			ResultSet set = statement.executeQuery();
			manager = new Manager.Builder()
					.setId(set.getInt(1))
					.setName(set.getString(2))
					.setPassword(set.getString(3))
					.setPosition(Position.valueOf(set.getString(4)))
					.setTel(set.getString(5))
					.build();			
			identityMap.put(manager.getId(), manager);
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		return manager;
	}

	@Override
	public void delete(Integer id) {
		throw new UnsupportedOperationException("not yet supported");
	}
	
	private boolean inCache(Integer id) {
		return identityMap.containsKey(id);
	}

}
