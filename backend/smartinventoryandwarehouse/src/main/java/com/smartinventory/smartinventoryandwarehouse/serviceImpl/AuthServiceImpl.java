package com.smartinventory.smartinventoryandwarehouse.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartinventory.smartinventoryandwarehouse.DTO.AuthResponseDTO;
import com.smartinventory.smartinventoryandwarehouse.DTO.LoginRequestDTO;
import com.smartinventory.smartinventoryandwarehouse.DTO.RegisterRequestDTO;
import com.smartinventory.smartinventoryandwarehouse.Entity.LoginRequest;
import com.smartinventory.smartinventoryandwarehouse.Entity.User;
import com.smartinventory.smartinventoryandwarehouse.Entity.User.Role;
import com.smartinventory.smartinventoryandwarehouse.Entity.User.Status;
import com.smartinventory.smartinventoryandwarehouse.Exception.EmailAlreadyExistsException;
import com.smartinventory.smartinventoryandwarehouse.Repository.UserRepository;
import com.smartinventory.smartinventoryandwarehouse.Service.AuthService;



@Service
public class AuthServiceImpl implements AuthService{
	
	//login Request	
	@Autowired
	private UserRepository repo;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	private final AuthenticationManager authenticationManager;
	
	
	public AuthServiceImpl(AuthenticationManager authenticationManager){
		this.authenticationManager =  authenticationManager;
	}

	
	public Authentication login(LoginRequestDTO request) {
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
	}


	@Override
	public User register(RegisterRequestDTO request) throws EmailAlreadyExistsException {
		if (repo.existByEmail(request.email())) {
	        throw new EmailAlreadyExistsException(
	                "Email already exists"
	        );
	    }
		User user  = new User();
		user.setFirstName(request.firstName());
		user.setLastName(request.lastName());
		user.setEmail(request.email());
		user.setPassword(passwordEncoder.encode(request.password()));
		user.setPhone(request.phone());
		user.setRole(Role.CUSTOMER);
		user.setStatus(Status.ACTIVE);
		
		return repo.save(user);
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