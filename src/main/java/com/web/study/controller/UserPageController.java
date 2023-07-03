package com.web.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserPageController {
	
	@GetMapping("/page/user/addition")
	public String addUser() {
		return "AddUser";
	}
	
	@GetMapping("/page/user/search")
	public String getUser() {
		return "FindUser";
	}
	
	@GetMapping("/page/users")
	public String getUsers() {
		return "UserList";
	}
}
