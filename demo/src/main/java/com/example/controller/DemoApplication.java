package com.example.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.user;
import com.example.service.UserService;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/request")
@SpringBootApplication
@MapperScan("com.example.dao")
public class DemoApplication {

	@Resource
	private UserService userService;

	@GetMapping("/1")
	String home1() {
		return "Hello World1!";
	}

	@GetMapping("/getUser")
	public List<user> getUser() {
		List<user> list = userService.getUser();
		return list;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
