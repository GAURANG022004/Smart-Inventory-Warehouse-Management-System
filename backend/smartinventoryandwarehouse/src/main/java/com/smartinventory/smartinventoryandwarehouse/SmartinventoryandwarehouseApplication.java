package com.smartinventory.smartinventoryandwarehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartinventoryandwarehouseApplication {

	public static void main(String[] args) {
		System.out.println("Java Version : " + System.getProperty("Java.version"));
		
		SpringApplication.run(SmartinventoryandwarehouseApplication.class, args);
	}

}