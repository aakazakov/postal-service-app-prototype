package dev.fun.app.router_service.datamappers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import dev.fun.app.common.dbconnectors.DBConnector;
import dev.fun.app.employee_service.entities.Manager;
import dev.fun.app.router_service.entities.RoutePoint;
import dev.fun.app.router_service.objects.Location;


public class RoutePointMapperImpl implements RoutePointMapper {
	
	@SuppressWarnings("unused")
	private final Map<Integer, Manager> identityMap = new HashMap<>();
	
	@SuppressWarnings("unused")
	private final String tableName = "route_points";
	
	@SuppressWarnings("unused")
	private DBConnector connector;

	public RoutePointMapperImpl(DBConnector connector) {
		this.connector = connector;
	}
	
	@Override
	public RoutePoint findById(Integer id) {		
		// stub code below
		return new RoutePoint.Builder()
							.setId(id)
							.setLocation(new Location("35.681700, 139.753882"))
							.setDescription("have fun")
							.build();
	}
	
	public List<RoutePoint> findByOrderId(Integer id) {
		// stub code
		return new LinkedList<>();
	}
	
}
