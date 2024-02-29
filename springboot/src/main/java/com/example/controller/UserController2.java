package com.example.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request2")
@SpringBootApplication
public class UserController2 {

	@GetMapping("/2")
	String home1() {
		return "222";
	}

}
