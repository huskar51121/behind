package com.example.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.UserService;

@RestController
@RequestMapping("/request1")
@SpringBootApplication
public class UserController {

	private final UserService userservice;

	public UserController(UserService userservice) {
		this.userservice = userservice;
	}

	@GetMapping("/1")
	String home1() {
		return userservice.name();
	}

}
