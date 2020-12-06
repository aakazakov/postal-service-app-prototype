package dev.fun.app.client_service.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClientTest {

	@Test
	void should_build_a_client() {
		Client client = new Client.Builder()
				.setId(1)
				.setName("TestName")
				.setPassword("TestPassword")
				.setTel("9999999999").build();
		
		assertNotNull(client);
		assertEquals(1, client.getId());
		assertEquals("TestName", client.getName());
		assertEquals("TestPassword", client.getPassword());
		assertEquals("9999999999", client.getTel());
	}

}
