package com.smartinventory.smartinventoryandwarehouse.Service;

import java.util.Optional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import com.smartinventory.smartinventoryandwarehouse.Entity.User;
import com.smartinventory.smartinventoryandwarehouse.Repository.UserRepository;

@Service
public class AuthService {
	
	//login Request	
	
	public User checkUser(String email, String password) {
		
		Optional<User> optionalUser = userRepo.findByEmail(email);
		
		User user = optionalUser.get();
		
		if(user == null) return null;
		
				
		
		
		
		return user;
		
	}

}
