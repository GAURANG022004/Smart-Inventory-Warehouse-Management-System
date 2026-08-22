package com.smartinventory.smartinventoryandwarehouse.DTO;

import java.time.LocalDateTime;

import com.smartinventory.smartinventoryandwarehouse.Entity.User.Role;
import com.smartinventory.smartinventoryandwarehouse.Entity.User.Status;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record RegisterRequestDTO (
	
	 
		
		@Valid @NotBlank(message = "First Name is required.")
		@Size(max = 50, message = "First name must not exceeds 50 characters")
	    String firstName,
	   
	    @Valid @NotBlank(message = "Last Name is required.")
		@Size(max = 50, message = "First name must not exceeds 50 characters")
		String lastName,
	    
		@Valid @NotBlank(message = "Email is required.")
		@Size(max = 50, message = "Email must not exceeds 50 ccharacters")
		@Email
		String email,
	    
	    
		@Valid @NotBlank(message = "Password is required.")
		String password,
	    
		@Valid @NotBlank(message = "First Name is required.")
		String phone,
	    
	    
	    
		Role role,
	    
	    
	    
		Status status,
	    
	    
	    LocalDateTime createdAt,
	    LocalDateTime updatedAt
	    

	   
) {
	
}
