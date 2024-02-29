package com.example.controller;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

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

	// 这是用来注册的,输入注册信息，成功则返回“创建成功”，失败则返回"该用户已存在"
	@GetMapping("/addoneuser")
	String addoneusers(JSONObject json) {
		// 这里暂时假装收到了一个来自前端的注册信息,之后要通过该函数的参数传入这个json
		json = new JSONObject();
		json.put("name", "huskar");
		json.put("password", "125213");
		json.put("enddate", "1243");
		json.put("phone", "12345");
		return userservice.addoneusers(json);
	}

	// 这是管理员用来查看所有用户的，返回一个list，返回到网页中会自动变为json
	@GetMapping("/getallusers")
	List<Map<String, Object>> getallusers() {
		return userservice.getallusers();
	}

	// 这是用来登录的，输入用户名和密码，会返回“该用户不存在”，“密码错误”，“登录成功”
	@GetMapping("/login")
	String login(String name, String password) {
		// 在参数出现后删除下面这两行
		name = "huskar";
		password = "125213";
		return userservice.login(name, password);
	}

	// 这是页面用来获取用户信息的，输入用户名，会返回该用户的所有信息，如果没有则返回null，类型是map，返回到网页中会自动变为json
	@GetMapping("/afterlogin")
	Map<String, Object> getuserbyname(String name) {
		// 在参数出现后删除下面这一行
		name = "huskar";
		return userservice.getuserbyname(name);
	}

}
