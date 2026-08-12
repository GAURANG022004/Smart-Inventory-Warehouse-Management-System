package com.smartinventory.smartinventoryandwarehouse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.smartinventory.smartinventoryandwarehouse.Entity.User;



public interface UserRepository extends JpaRepository<Long, User>{
	UserDetails findByEmail(String email);
}
