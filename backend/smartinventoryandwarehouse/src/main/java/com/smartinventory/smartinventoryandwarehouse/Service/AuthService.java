package com.smartinventory.smartinventoryandwarehouse.Service;


import org.springframework.security.core.Authentication;

import com.smartinventory.smartinventoryandwarehouse.DTO.LoginRequestDTO;
import com.smartinventory.smartinventoryandwarehouse.DTO.RegisterRequestDTO;
import com.smartinventory.smartinventoryandwarehouse.Entity.User;

public interface AuthService {
	
	Authentication login(LoginRequestDTO request);

	User register(RegisterRequestDTO request);

}