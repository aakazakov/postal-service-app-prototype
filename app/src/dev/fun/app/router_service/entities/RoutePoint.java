package dev.fun.app.router_service.entities;

import dev.fun.app.router_service.objects.Location;

public class RoutePoint {
	
	public static class Builder {
		private Integer id;
		private Location location;
		private String description;
		
		public Builder setId(Integer id) {
			this.id = id;
			return this;
		}
		public Builder setLocation(Location location) {
			this.location = location;
			return this;
		}
		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}
		
		public RoutePoint build() {
			return new RoutePoint(id, location, description);
		}
	}
	
	private final Integer id;
	private final Location location;
	private final String description;
	
	public Integer getId() {
		return id;
	}

	public Location getLocation() {
		return location;
	}

	public String getDescription() {
		return description;
	}

	public RoutePoint(Integer id, Location location, String description) {
		this.id = id;
		this.location = location;
		this.description = description;
	}
	
}
