package dev.fun.app.order_service.datamappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import dev.fun.app.client_service.datamappers.ClientMapperImpl;
import dev.fun.app.client_service.entities.Client;
import dev.fun.app.common.money.Money;
import dev.fun.app.order_service.entities.Order;
import dev.fun.app.router_service.entities.Route;

/**
 * All SQL queries are for method testing only
 */
public class OrderMapper {
	
//	private Connection connection;
//	private ClientMapperImpl clientMapper;
//
//	public OrderMapper(Connection connection) {
//		this.connection = connection;
//		this.clientMapper = new ClientMapperImpl(connection);
//	}
//	
//	// temporarily void, should actually return the saved order
//	public void save(Order order) throws SQLException {
//		String query = "INSERT INTO orders (id, weight, height, width, depth, sender, recipient, route, cost, state) "
//				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//		try (PreparedStatement statement = connection.prepareStatement(query)) {			
//			statement.setInt(1, 1);
//			statement.setFloat(2, order.getWeight());
//			statement.setFloat(3, order.getHeight());
//			statement.setFloat(4, order.getWidth());
//			statement.setFloat(5, order.getDepth());
//			statement.setInt(6, order.getSender().getId());
//			statement.setInt(7, order.getRecipient().getId());
//			statement.setInt(8, 1);
//			statement.setLong(9, order.getCost().getValue());
//			statement.setString(10, order.getState().state());
//			statement.execute();
//		}
//	}
//	
//	public Order findById(Integer id) throws SQLException {
//		Order order = null;
//		String query = "SELECT id, weight, height, width, depth, sender, recipient, route, cost, state "
//				+ "FROM orders WHERE orders.id=?";
//		try (PreparedStatement statement = connection.prepareStatement(query)) {
//			statement.setInt(1, id);
//			ResultSet resultSet = statement.executeQuery();
//			
//			Client sender = clientMapper.findById(resultSet.getInt("sender"));
//			Client recipient = clientMapper.findById(resultSet.getInt("recipient"));
//			
//			order = new Order.Builder()
//					.setId(resultSet.getInt(1))
//					.setWeight(resultSet.getFloat(2))
//					.setHeight(resultSet.getFloat(3))
//					.setWidth(resultSet.getFloat(4))
//					.setDepth(resultSet.getFloat(5))
//					.setSender(sender)
//					.setRecipient(recipient)
//					// Should actually get the route from the DB, but below is just for demo
//					.setRoute(new Route(resultSet.getInt("route"), new LinkedList<>()))
//					.setCost(new Money(resultSet.getLong("cost"), Locale.US))
//					.build();
//			
//			String state = resultSet.getString("state");
//			if (state.equals("awaiting")) order.awaiting();
//			if (state.equals("completed")) order.completed();
//			if (state.equals("cancelled")) order.cancelled();
//			if (state.equals("shipped")) order.shipped();
//			
//		}
//		return order;
//	}
//	
//	public List<Order> findByClientId(Integer id) {
//		
//		// ...
//		
//		return null;
//	}
//	
//	public void deleteById(Integer id) {
//		
//		// remove order by id from the DB
//		
//	}
//	
}
