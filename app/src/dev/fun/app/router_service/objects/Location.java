package dev.fun.app.router_service.objects;

public class Location {
	
	private final String gps;
	
	public Location(String gps) {
		this.gps = gps;
	}
	
	public String getGps() {
		return gps;
	}

	@Override
	public int hashCode() {	
		return gps.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		Location l = (Location) obj;
		return this.gps.equals(l.getGps());
	}

}
