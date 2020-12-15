package dev.fun.app.client_service.datamappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.fun.app.client_service.entities.Client;

public class ClientMapper {
	
	private Connection connection;

	public ClientMapper(Connection connection) {
		this.connection = connection;
	}
	
	public Client findById(Integer id) throws SQLException {
		Client client = null;
		String query = "SELECT id, name, password, tel FROM clients WHERE clients.id=?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			client = new Client.Builder()
					.setId(resultSet.getInt(1))
					.setName(resultSet.getString(2))
					.setPassword(resultSet.getString(3))
					.setTel(resultSet.getString(4))
					.build();
		}
		return client;
	}
	
	// temporarily void, should actually return the saved client
	public void save(Client client) throws SQLException {
		String query = "INSERT INTO clients (id, name, password, tel) values (?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, 10);
			statement.setString(2, client.getName());
			statement.setString(3, client.getPassword());
			statement.setString(4, client.getTel());
			statement.execute();
		}
	}
	
	public void deleteById(Integer id) {
		
		// remove client by id from the DB
		
	}
	
}
