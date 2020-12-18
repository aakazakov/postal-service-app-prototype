package dev.fun.app.order_service.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import dev.fun.app.common.money.Money;
import dev.fun.app.router_service.objects.Route;
import dev.fun.app.router_service.services.Router;

class OrderTest {

	@Test
	void should_buid_an_order() {
		Route route = (new Router()).route(1, 2);
		Order order = new Order.Builder()
				.setId(1)
				.setWeight(1.0f)
				.setHeight(2.0f)
				.setWidth(3.0f)
				.setDepth(4.0f)
				.setRoute(route)
				.setSenderId(1)
				.setRecipientId(2)
				.setCost(new Money(123456L, Locale.US))
				.build();
		
		assertNotNull(order);
		assertEquals(1, order.getId());
		assertEquals(1.0f, order.getWeight());
		assertEquals(2.0f, order.getHeight());
		assertEquals(3.0f, order.getWidth());
		assertEquals(4.0f, order.getDepth());
		assertEquals(route, order.getRoute());
		assertEquals(1, order.getSenderId());
		assertEquals(2, order.getRecipientId());
		assertEquals(123456L, order.getCost().getValue());
		
		String currentState = order.getState().state();
		
		assertEquals("Created", currentState);
	}
	
	@Test
	void should_change_route() {
		Route route = (new Router()).route(1, 2);
		Route newRoute = (new Router()).route(3, 4);
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
		
		String newState = order.getState().state();
		
		assertEquals("Completed", newState);
	}

}
