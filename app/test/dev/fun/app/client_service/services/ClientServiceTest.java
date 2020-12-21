package dev.fun.app.client_service.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.fun.app.client_service.entities.Client;
import dev.fun.app.common.exceptions.IncorrectlyFilledCredentialsException;

class ClientServiceTest {

	@Test
	@DisplayName("check IncorrectlyFilledCredentialsException thrown")
	void test() {
		ClientServiceImpl service = new ClientServiceImpl(null, null);
		
		Client client = new Client.Builder().setTel("1234567890").build();
		
		assertThrows(IncorrectlyFilledCredentialsException.class, () -> {
			service.create(client);
		});
	}

}
