package com.weatherexpress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationWebController {

	@RequestMapping(value = "/welcome")
	public String showForm() {
		return "welcome";
	}

	@RequestMapping(value = "/login")
	public String loginPage() {
		return "customLoginPage";
	}

	@RequestMapping(value = "/logout")
	public String logoutPage() {
		return "customLoginPage";
	}

	@RequestMapping(value = "/userPost", method = RequestMethod.POST)
	public String userPost() {
		return "userPosts";
	}
}
