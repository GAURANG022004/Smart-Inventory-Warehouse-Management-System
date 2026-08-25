package com.smartinventory.smartinventoryandwarehouse.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartinventory.smartinventoryandwarehouse.Entity.User;



public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);
	
	boolean existsByEmail(String email);
}
