package dev.fun.app.order_service.datamappers;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;

import dev.fun.app.db.connectors.DBConnector;
import dev.fun.app.finance.money.Money;
import dev.fun.app.order_service.entities.Order;

public class OrderMapperImpl implements OrderMapper {
	
	private Logger logger = Logger.getLogger("OrderMapperImpl");
	
	private final Map<Integer, Order> identityMap = new HashMap<>();
	
	private final String tableName = "orders";
	
	private DBConnector connector;

	public OrderMapperImpl(DBConnector connector) {
		this.connector = connector;
	}

	@Override
	public Order save(Order order) {
		String query = "INSERT INTO " + tableName +
				" (weight, height, width, depth, sender_id, recipient_id, cost, state) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Order newOrder = null;
		Integer id = -1;
		try (Connection connection = connector.connect();
				PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setFloat(1, order.getWeight());
			statement.setFloat(2, order.getHeight());
			statement.setFloat(3, order.getWidth());
			statement.setFloat(4, order.getDepth());
			statement.setInt(5, order.getSenderId());
			statement.setInt(6, order.getRecipientId());
			statement.setLong(7, order.getCost().getValue());
			statement.setString(8, order.getState().state());
			int exeSuccess = statement.executeUpdate();
			if (exeSuccess > 0) {
				id = getLastInsertedId(connection);
			}			
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		if (id != -1) {
			newOrder = findById(id);
		} 
		return newOrder;
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
	public Order findById(Integer id) {
		if (inCache(id)) {
			return identityMap.get(id);
		}
		Order order = null;
		String query = "SELECT id, weight, height, width, depth, sender_id, recipient_id, cost, state "
				+ "FROM " + tableName + " WHERE id=?";
		try (Connection connection = connector.connect();
				PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setInt(1, id);
			ResultSet set = statement.executeQuery();
			order = new Order.Builder()
					.setId(set.getInt(1))
					.setWeight(set.getFloat(2))
					.setHeight(set.getFloat(3))
					.setWidth(set.getFloat(4))
					.setDepth(set.getFloat(5))
					.setSenderId(set.getInt(6))
					.setRecipientId(set.getInt(7))
					.setCost(new Money(set.getLong(8), Locale.US))
					.build();
			setStatus(order, set.getString(9));
			identityMap.put(order.getId(), order);
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		return order;
	}
	
	private void setStatus(Order order, String status) {
		if (order.getState().state().equals(status)) return; // if the status is 'created' (set by default)
		try {
			Method m = Order.class.getMethod(status);
			m.invoke(order, (Object[]) null);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	@Override
	public List<Order> findByClientId(Integer id) {
		// stub code
		return new ArrayList<>();
	}
	
	@Override
	public void delete(Integer id) {
		throw new UnsupportedOperationException("not yet...");
	}
	
	private boolean inCache(Integer id) {
		return identityMap.containsKey(id);
	}
	
}
