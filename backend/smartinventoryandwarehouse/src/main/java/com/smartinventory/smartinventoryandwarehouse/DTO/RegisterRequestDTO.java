package com.smartinventory.smartinventoryandwarehouse.DTO;

import java.time.LocalDateTime;

import com.smartinventory.smartinventoryandwarehouse.Entity.User.Role;
import com.smartinventory.smartinventoryandwarehouse.Entity.User.Status;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;


public record RegisterRequestDTO (
	
	 
		
		@Valid @NotBlank(message = "First Name is required.")
	    String firstName,
	   
	    @Valid @NotBlank(message = "Last Name is required.")
		String lastName,
	    
		@Valid @NotBlank(message = "Email is required.")
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
