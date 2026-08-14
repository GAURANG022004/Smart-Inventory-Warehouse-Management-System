package com.smartinventory.smartinventoryandwarehouse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smartinventory.smartinventoryandwarehouse.Entity.CustomUserDetails;
import com.smartinventory.smartinventoryandwarehouse.Entity.User;
import com.smartinventory.smartinventoryandwarehouse.Repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired 
	private  UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email)
	        throws UsernameNotFoundException {

	    User user = userRepo.findByEmail(email)
	            .orElseThrow(() ->
	                new UsernameNotFoundException("User not found: " + email)
	            );

	    return new CustomUserDetails(user);
	}

}
