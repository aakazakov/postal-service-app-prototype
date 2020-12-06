package dev.fun.app.router_service.entities;

public class RoutePoint {
	
	public static class Builder {
		private Integer id;
		private String gps;
		private String description;
		
		public Builder setId(Integer id) {
			this.id = id;
			return this;
		}
		public Builder setGps(String gps) {
			this.gps = gps;
			return this;
		}
		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}
		
		public RoutePoint build() {
			return new RoutePoint(id, gps, description);
		}
	}
	
	private final Integer id;
	private final String gps;
	private final String description;
	
	public Integer getId() {
		return id;
	}

	public String getGps() {
		return gps;
	}

	public String getDescription() {
		return description;
	}

	public RoutePoint(Integer id, String gps, String description) {
		super();
		this.id = id;
		this.gps = gps;
		this.description = description;
	}
	
}
