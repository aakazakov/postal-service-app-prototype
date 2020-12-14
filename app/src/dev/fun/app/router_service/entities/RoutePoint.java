package dev.fun.app.router_service.entities;

import dev.fun.app.router_service.objects.Location;

public class RoutePoint {
	
	public static class Builder {
		private RoutePoint routePoint;
		
		public Builder() {
			this.routePoint = new RoutePoint();
		}
		
		public Builder setId(Integer id) {
			this.routePoint.setId(id);
			return this;
		}
		public Builder setLocation(Location location) {
			this.routePoint.setLocation(location);
			return this;
		}
		public Builder setDescription(String description) {
			this.routePoint.setDescription(description);
			return this;
		}
		
		public RoutePoint build() {
			return this.routePoint;
		}
	}
	
	private Integer id;
	private Location location;
	private String description;
	
	public Integer getId() {
		return id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RoutePoint() {
		
	}

	public RoutePoint(Integer id, Location location, String description) {
		this.id = id;
		this.location = location;
		this.description = description;
	}
	
}
