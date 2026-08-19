package com.smartinventory.smartinventoryandwarehouse.Controller;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartinventory.smartinventoryandwarehouse.Service.AuthService;

@Controller
public class AuthController {
	
	@Autowired
	private AuthService authservice;
	
	@GetMapping("/")
	public String start() {
		return login;
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return login;
	}
	
	@PutMapping("/login")
	public String loginUser(@RequestParam String email, @RequestParam String password, HttpRequest request) {
		
		
		authservice.checkUser(email, password);
		
		
		return "AdminDashBoard";
		return "CustomerDashBoard";
		
	}
	
	
	
	

}
