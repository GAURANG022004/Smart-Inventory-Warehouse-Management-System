package com.smartinventory.smartinventoryandwarehouse.Controller;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartinventory.smartinventoryandwarehouse.DTO.AuthResponseDTO;
import com.smartinventory.smartinventoryandwarehouse.DTO.LoginRequestDTO;
import com.smartinventory.smartinventoryandwarehouse.DTO.RegisterRequestDTO;
import com.smartinventory.smartinventoryandwarehouse.Entity.LoginRequest;
import com.smartinventory.smartinventoryandwarehouse.Entity.RegisterResponseDTO;
import com.smartinventory.smartinventoryandwarehouse.Entity.User;
import com.smartinventory.smartinventoryandwarehouse.Exception.EmailAlreadyExistsException;
import com.smartinventory.smartinventoryandwarehouse.Service.AuthService;
import com.smartinventory.smartinventoryandwarehouse.serviceImpl.AuthServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
//	private HttpRequest http;
	
	@Autowired
	private AuthService authservice;
	
//	@GetMapping("/")
//	public String start() {
//		return http.;
//	}
//	
//	@GetMapping("/login")
//	public String showLoginPage() {
//		return login;
//	}
	
	@PostMapping("/login")
	public ResponseEntity<Authentication> loginUser(@Valid @RequestBody LoginRequestDTO request ) {
		
		
		Authentication authentication = authservice.login(request);
		return ResponseEntity.ok(authentication);
		
//		return "AdminDashBoard";
//		return "CustomerDashBoard";
//		
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<RegisterResponseDTO> registerUser(@Valid @RequestBody RegisterRequestDTO request) throws EmailAlreadyExistsException{
		
		User user= authservice.register(request);
		
		RegisterResponseDTO response = new RegisterResponseDTO(
				user.getFirstName(),
				user.getLastName(),
				user.getEmail(),
				user.getPhone(),
				user.getRole().name(),
				user.getStatus().name()
				);
				
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(response);
	}
	
	
	

}
