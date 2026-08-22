package com.smartinventory.smartinventoryandwarehouse.DTO;

import java.time.LocalDateTime;

import com.smartinventory.smartinventoryandwarehouse.Entity.User.Role;
import com.smartinventory.smartinventoryandwarehouse.Entity.User.Status;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record RegisterRequestDTO (
	
	 
		
		@NotBlank(message = "First Name is required.")
		@Size(max = 50, message = "First name must not exceeds 50 characters")
	    String firstName,
	   
	    @NotBlank(message = "Last Name is required.")
		@Size(max = 50, message = "First name must not exceeds 50 characters")
		String lastName,
	    
		@NotBlank(message = "Email is required.")
		@Size(max = 50, message = "Email must not exceeds 50 ccharacters")
		@Email
		String email,
	    
	    
		@NotBlank(message = "Password is required.")
		@Size(min = 8, max = 100, message = "password must be minimum 8 characters")
		String password,
	    
		@NotBlank(message = "phone no. is required.")
		@Size(max = 20, message = "Phone no. must not exceed 20 character")
		String phone,
	    
	    
	    
		Role role,
	    
	    
	    
		Status status,
	    
	    
	    LocalDateTime createdAt,
	    LocalDateTime updatedAt
	    

	   
) {
	
}
