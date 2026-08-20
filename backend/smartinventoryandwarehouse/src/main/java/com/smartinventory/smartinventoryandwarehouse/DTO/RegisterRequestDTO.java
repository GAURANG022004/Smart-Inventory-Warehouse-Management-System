package com.smartinventory.smartinventoryandwarehouse.DTO;

import java.time.LocalDateTime;

import com.smartinventory.smartinventoryandwarehouse.Entity.User.Role;
import com.smartinventory.smartinventoryandwarehouse.Entity.User.Status;


public record RegisterRequestDTO (
	
	 
		
		
	   String firstName,
	   String lastName,
	    
	    
	   String email,
	    
	    
	    
	   String password,
	    
	    
	   String phone,
	    
	    
	    
	   Role role,
	    
	    
	    
	    Status status,
	    
	    
	    LocalDateTime createdAt,
	    LocalDateTime updatedAt
	    

	   
) {
	
}
