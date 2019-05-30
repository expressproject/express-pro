package com.weatherexpress.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthenticationWebController {

	@RequestMapping(value = "/welcome")
	public String welcomePage() {
		return "welcome";
	}

	@RequestMapping(value = "/login")
	public String loginPage() {
		return "customLoginPage";
	}

	@RequestMapping(value = "/logout")
	public String logoutPage(Model model, HttpServletRequest req, HttpServletResponse res) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(req, res, auth);
		}
		model.addAttribute("messages", "you loggedout successfully");
		return "welcome";
	}

	@RequestMapping(value = "/userPost")
	public String userPost(HttpServletRequest req) {
		System.out.println(req);
		return "userPosts";
	}
}
