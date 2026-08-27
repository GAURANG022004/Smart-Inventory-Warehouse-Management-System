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


@jakarta.persistence.Entity
@Getter
@Setter
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
    
    
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
	






}
