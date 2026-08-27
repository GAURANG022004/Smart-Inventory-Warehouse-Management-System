package com.smartinventory.smartinventoryandwarehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import com.smartinventory.smartinventoryandwarehouse.Entity.User;

import io.jsonwebtoken.Jwts;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SmartinventoryandwarehouseApplication {

	public static void main(String[] args) {
		System.out.println("Java Version : " + System.getProperty("Java.version"));
		
		SpringApplication.run(SmartinventoryandwarehouseApplication.class, args);
	}

}


