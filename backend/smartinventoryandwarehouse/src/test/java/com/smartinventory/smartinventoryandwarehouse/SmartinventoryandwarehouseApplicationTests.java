package com.smartinventory.smartinventoryandwarehouse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.smartinventory.smartinventoryandwarehouse.Entity.User;
import com.smartinventory.smartinventoryandwarehouse.Entity.User.Role;
import com.smartinventory.smartinventoryandwarehouse.Service.JWTService;

@SpringBootTest
class SmartinventoryandwarehouseApplicationTests {

	@Autowired
	private JWTService jwtService;
	
	@Test
	void shouldGenerateAndReadJwtToken() {
		
		//Arrange
		
		User user = new User();
		
		user.setId(100L);
		user.setEmail("test@example.com");
		user.setRole(Role.CUSTOMER);
		
		//Act
		
		String token = jwtService.generateToken(user);
		
		
		//Assert
		
		assertNotNull(token);
		assertFalse(token.isBlank());
		
		assertEquals(
				100L,
				jwtService.extractUserId(token)
		);
		
		assertEquals(
				"test@example.com",
				jwtService.extractEmail(token)
		);
		
		assertEquals(
				"CUSTOMER",
				jwtService.extractRole(token)
		);
		
		assertFalse(jwtService.isTokenExpired(token));

		
		assertTrue(jwtService.validateToken(token, user));
		
		
	}
	
	@Test
	void shouldNotValidateTokenForDifferentUser() {
		
		//Arange
		User originalUser = new User();
		
		originalUser.setId(100L);
		originalUser.setEmail("test@example.com");
		originalUser.setRole(Role.CUSTOMER);
		
		User differentUser = new User();
		
		differentUser.setId(200L);
		originalUser.setEmail("other@example.com");
		originalUser.setRole(Role.CUSTOMER);
		
		//Act 
		String token = jwtService.generateToken(originalUser);
		
		//Assert
		
		assertFalse(jwtService.validateToken(token, differentUser));
		
		
		
	}
	

}
