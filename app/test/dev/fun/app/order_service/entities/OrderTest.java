package dev.fun.app.order_service.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dev.fun.app.client_service.entities.Client;
import dev.fun.app.router_service.entities.RoutePoint;
import dev.fun.app.router_service.services.Router;

class OrderTest {

	@Test
	void should_buid_an_order() {
		List<RoutePoint> route = (new Router()).route(1, 2);
		Order order = new Order.Builder()
				.setId(1)
				.setWeight(1.0f)
				.setHeight(2.0f)
				.setWidth(3.0f)
				.setDepth(4.0f)
				.setRoute(route)
				.setSender(new Client.Builder().setName("Sender").build())
				.setRecipient(new Client.Builder().setName("Recipient").build())
				.build();
		
		assertNotNull(order);
		assertEquals(1, order.getId());
		assertEquals(1.0f, order.getWeight());
		assertEquals(2.0f, order.getHeight());
		assertEquals(3.0f, order.getWidth());
		assertEquals(4.0f, order.getDepth());
		assertEquals(route, order.getRoute());
		assertEquals("Sender", order.getSender().getName());
		assertEquals("Recipient", order.getRecipient().getName());
		
		@SuppressWarnings("static-access")
		String currentState = ((Created)order.getState()).STATE;
		
		assertEquals(Created.STATE, currentState);
	}
	
	@Test
	void should_change_route() {
		List<RoutePoint> route = (new Router()).route(1, 2);
		List<RoutePoint> newRoute = (new Router()).route(3, 4);
		Order order = new Order.Builder()
				.setId(1)
				.setRoute(route)
				.build();
		
		assertEquals(route, order.getRoute());
		
		order.changeRoute(newRoute);
		
		assertEquals(newRoute, order.getRoute());
	}
	
	@Test
	void should_change_state() {
		Order order = new Order.Builder().build();
		
		order.completed();
		
		@SuppressWarnings("static-access")
		String newState = ((Completed)order.getState()).STATE;
		
		assertEquals(Completed.STATE, newState);
	}

}
