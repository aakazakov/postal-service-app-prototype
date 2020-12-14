package dev.fun.app.router_service.datamappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.fun.app.router_service.entities.RoutePoint;
import dev.fun.app.router_service.objects.Location;

public class RoutePointMapper {
	
	private Connection connection;

	public RoutePointMapper(Connection connection) {
		this.connection = connection;
	}
	
	public RoutePoint findById(Integer id) throws SQLException {
		RoutePoint routePoint = null;
		String query = "SELECT id, description, gps FROM route_points WHERE route_points.id=?";
		try (PreparedStatement prepareStatement = connection.prepareStatement(query)) {
			prepareStatement.setInt(1, id);
			ResultSet resultSet = prepareStatement.executeQuery();
			routePoint = new RoutePoint.Builder()
					.setId(resultSet.getInt(1))
					.setDescription(resultSet.getString(2))
					.setLocation(new Location(resultSet.getString(3)))
					.build();
		}
		return routePoint;
	}
	
}
