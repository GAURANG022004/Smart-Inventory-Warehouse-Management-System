package com.smartinventory.smartinventoryandwarehouse.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.smartinventory.smartinventoryandwarehouse.DTO.AuthResponseDTO;
import com.smartinventory.smartinventoryandwarehouse.DTO.LoginRequestDTO;
import com.smartinventory.smartinventoryandwarehouse.Entity.LoginRequest;
import com.smartinventory.smartinventoryandwarehouse.Service.AuthService;



@Service
public class AuthServiceImpl implements AuthService{
	
	//login Request	
	
	private final AuthenticationManager authenticationManager;
	
	@Autowired
	public AuthServiceImpl(AuthenticationManager authenticationManager){
		this.authenticationManager =  authenticationManager;
	}

	
	public Authentication login(LoginRequestDTO request) {
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
	}
	
//							LOGIN REQUEST
//							    │
//							    ▼
//							AuthController
//							    │
//							    ▼
//							AuthService
//							    │
//							    ▼
//							AuthServiceImpl
//							    │
//							    ▼
//							AuthenticationManager
//							    │
//							    ▼
//							DaoAuthenticationProvider
//							    │
//							    ▼
//							CustomUserDetailsService
//							    │
//							    ▼
//							UserRepository
//							    │
//							    ▼
//							 MySQL
//							    │
//							User found
//							    │
//							    ▼
//							UserDetails
//							    │
//							    ▼
//							DaoAuthenticationProvider
//							    │
//							BCrypt checks
//							    │
//				   	 ┌──────────┴──────────┐
//					 │                     │
//					MATCH                  NO MATCH
//					  │                     │
//					  ▼                     ▼
//					Authentication          Exception
//					authenticated        BadCredentialsException
	//					│
	//					▼
//					AuthenticationManager
	//					│
	//					▼
//					AuthServiceImpl
	//					│
	//					▼
//					AuthController

}