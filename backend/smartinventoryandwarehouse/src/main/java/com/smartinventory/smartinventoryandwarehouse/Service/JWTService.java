package com.smartinventory.smartinventoryandwarehouse.Service;

import com.smartinventory.smartinventoryandwarehouse.Entity.User;

public interface JWTService {
	
	public String generateToken(User user);
	public long extractUserId(String token);
	public String extractEmail(String token);
	public String extractRole(String token);
	public boolean isTokenExpired(String token);
	public boolean validateToken(String token, User user);

}
