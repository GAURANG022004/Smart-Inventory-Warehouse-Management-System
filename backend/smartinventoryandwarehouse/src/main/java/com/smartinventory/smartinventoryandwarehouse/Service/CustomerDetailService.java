package com.smartinventory.smartinventoryandwarehouse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.smartinventory.smartinventoryandwarehouse.Repository.UserRepository;

public class CustomerDetailService implements UserDetailsService {
	
	@Autowired 
	private  UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepo.findByEmail(email);
	}
	
	

}
