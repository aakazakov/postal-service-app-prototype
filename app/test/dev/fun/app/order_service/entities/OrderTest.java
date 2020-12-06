package dev.fun.app.order_service.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dev.fun.app.client_service.entities.Client;
import dev.fun.app.order_service.enums.OrderStatus;
import dev.fun.app.router_service.entities.RoutePoint;
import dev.fun.app.router_service.entities.Router;

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
				.setOrderStatus(OrderStatus.SHIPPED)
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
	}

}
