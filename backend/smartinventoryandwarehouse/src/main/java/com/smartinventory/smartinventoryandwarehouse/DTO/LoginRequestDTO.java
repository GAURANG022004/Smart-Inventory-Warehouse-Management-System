package com.smartinventory.smartinventoryandwarehouse.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO (
		@Email @NotBlank(message = "Invalid Email Format")
		String email,
		
		@NotBlank(message = "Password Cannot be Null")
		String password) {
	

}
