package com.smartinventory.smartinventoryandwarehouse.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.smartinventory.smartinventoryandwarehouse.Entity.User;



public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);
	
	boolean existByEmail(String email);
}
