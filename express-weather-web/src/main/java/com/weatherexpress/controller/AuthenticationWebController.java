package com.weatherexpress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weatherexpress.dto.LoginForm;

@Controller
public class AuthenticationWebController {

	@RequestMapping(value = "/login")
	public String showForm(LoginForm loginForm) {
		return "welcome";
	}
}
