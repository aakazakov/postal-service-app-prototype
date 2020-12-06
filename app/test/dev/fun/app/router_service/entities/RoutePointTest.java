package dev.fun.app.router_service.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoutePointTest {

	@Test
	void should_build_an_object() {
		RoutePoint point = new RoutePoint.Builder()
				.setId(1)
				.setGps("55.755814, 37.617635")
				.setDescription("lol")
				.build();
		
		assertNotNull(point);
		assertEquals(1, point.getId());
		assertEquals("55.755814, 37.617635", point.getGps());
		assertEquals("lol", point.getDescription());
	}

}
