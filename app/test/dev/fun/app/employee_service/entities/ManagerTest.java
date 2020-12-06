package dev.fun.app.employee_service.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dev.fun.app.employee_service.enums.Position;

class ManagerTest {

	@Test
	void should_build_a_manager() {
		Manager manager = new Manager.Builder()
				.setId(1)
				.setName("TestName")
				.setPassword("TestPassword")
				.setPosition(Position.MANAGER)
				.setTel("9999999999")
				.build();
		
		assertNotNull(manager);
		assertEquals(1, manager.getId());
		assertEquals("TestName", manager.getName());
		assertEquals("TestPassword", manager.getPassword());
		assertEquals(Position.MANAGER, manager.getPosition());
		assertEquals("9999999999", manager.getTel());
	}

}
