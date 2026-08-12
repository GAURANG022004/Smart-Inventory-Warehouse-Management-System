package com.smartinventory.smartinventoryandwarehouse.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@jakarta.persistence.Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	
    private String firstName;
    private String lastName;
    
    
    @Column(unique = true, nullable = false)
    private String email;
    
    
    @Column(nullable = false)
    private String password;
    
    
    private String phone;
    
    
    @Enumerated(EnumType.STRING)
    private Role role;
    
    
    @Enumerated(EnumType.STRING)
    private Status status;
    
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    

    public enum Role{
    	SUPER_ADMIN,
    	ADMIN,
    	CEO,
    	INVENTORY_MANAGER,
    	WAREHOUSE_MANAGER,
    	PURCHASE_MANAGER,
    	SALES_MANAGER,
    	CUSTOMER
    }
    
    
    public enum Status{
        ACTIVE,
        INACTIVE,
        LOCKED
    }




}
