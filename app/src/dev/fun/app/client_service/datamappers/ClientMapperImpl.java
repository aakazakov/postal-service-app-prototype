package dev.fun.app.client_service.datamappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import dev.fun.app.client_service.entities.Client;
import dev.fun.app.common.dbconnectors.DBConnector;

public class ClientMapperImpl implements ClientMapper {
	
	private Logger logger = Logger.getLogger("ClientMapperImpl");
	
	private final Map<Integer, Client> identityMap = new HashMap<>();
	
	private final String tableName = "clients";
	
	private DBConnector connector;

	public ClientMapperImpl(DBConnector connector) {
		this.connector = connector;
	}
	
	@Override
	public Client save(Client client) {
		String query = "INSERT INTO " + tableName + " (name, password, tel) VALUES (?, ?, ?)";
		Client newClient = null;
		Integer id = -1;
		try (Connection connection = connector.connect();
				PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setString(1, client.getName());
			statement.setString(2, client.getPassword());
			statement.setString(3, client.getTel());
			int exeSuccess = statement.executeUpdate();
			if (exeSuccess > 0) {
				id = getLastInsertedId(connection);
			}			
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		if (id != -1) {
			newClient = findById(id);
		} 
		return newClient;
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
	public Client findById(Integer id) {
		if (inCache(id)) {
			return identityMap.get(id);
		}
		Client client = null;
		String query = "SELECT id, name, password, tel FROM " + tableName + " WHERE id=?";
		try (Connection connection = connector.connect();
				PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setInt(1, id);
			ResultSet set = statement.executeQuery();
			client = new Client.Builder()
					.setId(set.getInt(1))
					.setName(set.getString(2))
					.setPassword(set.getString(3))
					.setTel(set.getString(4))
					.build();
			identityMap.put(client.getId(), client);
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		return client;
	}

	@Override
	public void delete(Integer id) {
		throw new UnsupportedOperationException("not yet supported");
	}
	
	private boolean inCache(Integer id) {
		return identityMap.containsKey(id);
	}

	
}
