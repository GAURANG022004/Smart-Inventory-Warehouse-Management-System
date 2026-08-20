package com.smartinventory.smartinventoryandwarehouse.Service;


import org.springframework.security.core.Authentication;
import com.smartinventory.smartinventoryandwarehouse.DTO.LoginRequestDTO;

public interface AuthService {
	
	Authentication login(LoginRequestDTO request);

}