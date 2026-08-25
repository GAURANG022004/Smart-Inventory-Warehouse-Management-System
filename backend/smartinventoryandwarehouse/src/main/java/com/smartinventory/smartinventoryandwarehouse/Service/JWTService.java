package com.smartinventory.smartinventoryandwarehouse.Service;

import com.smartinventory.smartinventoryandwarehouse.Entity.User;

public interface JWTService {
	
	public String generatedToken(User user);
	public User extractUser(User user);
	public User extractEmail(User user);
	public User extractRole(token);
	public User isTokenExpired(token);
	public validateToken(token, user);

}
